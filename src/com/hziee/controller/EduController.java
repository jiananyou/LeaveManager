package com.hziee.controller;

import com.hziee.po.TeacherVacate;
import com.hziee.po.Tutor;
import com.hziee.po.Vacate;
import com.hziee.service.EduService;
import com.hziee.util.DateUtil;
import com.hziee.util.EncodeUtil;
import com.hziee.util.ExcelUtil;
import com.hziee.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("edu")
public class EduController {
    @Autowired
    private EduService eduService;

    @GetMapping("accept")
    public List<Vacate> accept(@RequestParam("user_id") String edu_id,
                               @RequestParam("vacate_id") String vacate_id) {
        eduService.updateVacate(vacate_id);
        eduService.updateAcceptEduVacate(vacate_id);
        eduService.updateAcceptStudentVacate(vacate_id);
        String courseList = eduService.findCourseListByVacateId(vacate_id);
        List<String> teacherList = eduService.findTeacherIdByCourseList(Arrays.asList(courseList.split(",")));
        for (String teacherId : teacherList) {
            TeacherVacate teacherVacate = new TeacherVacate(teacherId, vacate_id, 0);
            eduService.addTeacherVacate(teacherVacate);
        }
        return findCheckingVacate(edu_id);
    }

    @GetMapping("refuse")
    public List<Vacate> refuse(@RequestParam("user_id") String edu_id,
                               @RequestParam("vacate_id") String vacate_id) {
        eduService.updateRefuseStudentVacate(vacate_id);
        eduService.updateRefuseEduVacate(vacate_id);
        return findCheckingVacate(edu_id);
    }

    @GetMapping("find_passVacate")
    public List<Vacate> findPassVacate(@RequestParam("edu_id") String edu_id) {
        List<Vacate> list = eduService.findPassVacate(edu_id);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_checkingVacate")
    public List<Vacate> findCheckingVacate(@RequestParam("id") String edu_id) {
        List<Vacate> list = eduService.findCheckingVacate(edu_id);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_failVacate")
    public List<Vacate> findFailVacate(@RequestParam("edu_id") String edu_id) {
        List<Vacate> list = eduService.findFailVacate(edu_id);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_byTime")
    public List<Vacate> findByTime(@RequestParam("user_id") String edu_id,
                                   @RequestParam("start_time") String start_time,
                                   @RequestParam("end_time") String end_time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long start_times = dateFormat.parse(start_time).getTime();
        long end_times = dateFormat.parse(end_time).getTime();
        HashMap<String, Object> map = new HashMap<>();
        map.put("edu_id", edu_id);
        map.put("start_time", String.valueOf(start_times));
        map.put("end_time", String.valueOf(end_times));
        List<Vacate> list = eduService.findByTime(map);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_byTerm")
    public List<Vacate> findByTerm(@RequestParam("user_id") String edu_id,
                                   @RequestParam("term") String term) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("edu_id", edu_id);
        map.put("term", term);
        List<Vacate> list = eduService.findByTerm(map);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_byType")
    public List<Vacate> findByResult(@RequestParam("user_id") String edu_id,
                                     @RequestParam("type") String type) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("edu_id", edu_id);
        map.put("type", EncodeUtil.transcoding(type));
        List<Vacate> list = eduService.findByType(map);
        return DateUtil.formatList(list);
    }

    /* Web接口 分页+单条件查询 */
    @GetMapping("find_vacate")
    public PageUtil findVacate(@RequestParam("user_id") String edu_id,
                               @RequestParam("page_no") Integer page_no,
                               @RequestParam("page_size") Integer page_size,
                               @RequestParam("start_time") String start_time,
                               @RequestParam("end_time") String end_time,
                               @RequestParam("term") String term,
                               @RequestParam("type") String type) throws ParseException {
        Integer start = (page_no - 1) * page_size;
        HashMap<String, Object> map1 = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (!start_time.isEmpty()) {
            start_time = String.valueOf(dateFormat.parse(start_time).getTime());
        }
        if (!end_time.isEmpty()) {
            end_time = String.valueOf(dateFormat.parse(end_time).getTime());
        }
        map1.put("edu_id", edu_id);
        map1.put("start", start);
        map1.put("size", page_size);
        map1.put("start_time", start_time);
        map1.put("end_time", end_time);
        map1.put("term", term);
        map1.put("type", EncodeUtil.transcoding(type));
        List<Vacate> list = DateUtil.formatList(eduService.findVacate(map1));

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("edu_id", edu_id);
        map2.put("start_time", start_time);
        map2.put("end_time", end_time);
        map2.put("term", term);
        map2.put("type", EncodeUtil.transcoding(type));
        Integer count = eduService.findCount(map2);

        PageUtil pu = new PageUtil();
        pu.setCount(count);
        pu.setData(list);
        return pu;
    }

    /* 数据分析 */
    @GetMapping("analysis")
    public List<Integer> analysis() {
        Integer illCounts = eduService.findIll();
        Integer thingCounts = eduService.findThing();
        Integer workCounts = eduService.findWork();
        Integer othersCounts = eduService.findOthers();
        List<Integer> countList = new ArrayList<>();
        countList.add(illCounts);
        countList.add(thingCounts);
        countList.add(workCounts);
        countList.add(othersCounts);
        return countList;
    }

    @PostMapping("fileupload")
    public Integer fileUpload(@RequestParam MultipartFile file,
                             HttpServletRequest request) {
        String originalFileName = file.getOriginalFilename();
        String dirPath = request.getServletContext().getRealPath("/upload");
        File filePath = new File(dirPath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        String newFileName = UUID.randomUUID() + "_3001_" + originalFileName;
        String path = dirPath + File.separator + newFileName;
        System.out.println(path);
        List<Tutor> tutorList;
        try {
            file.transferTo(new File(path));
            tutorList = ExcelUtil.readExcel(path);
        } catch (IOException e) {
            return 0;
        }
        System.out.println(tutorList);
        eduService.addTutor(tutorList);
        return tutorList.size();
    }
}
