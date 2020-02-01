package com.hziee.controller;

import com.hziee.mapper.StudentMapper;
import com.hziee.po.StudentVacate;
import com.hziee.po.TutorVacate;
import com.hziee.po.Vacate;
import com.hziee.service.StudentService;
import com.hziee.util.DateUtil;
import com.hziee.util.EncodeUtil;
import com.hziee.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("add_vacate")
    public Integer addVacate(@RequestParam("id") String id,
                             @RequestParam("stu_name") String stu_name,
                             @RequestParam("grade_id") String grade_id,
                             @RequestParam("submit_time") String submit_time,
                             @RequestParam("start_time") String start_time,
                             @RequestParam("end_time") String end_time,
                             @RequestParam("type") String type,
                             @RequestParam("result") String result,
                             @RequestParam("course_list") String course_list) throws ParseException {
        //请假总表添加记录
        String vacate_id = UUID.randomUUID().toString().replaceAll("-", "");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long submit_times = timeFormat.parse(submit_time).getTime();
        long start_times = dateFormat.parse(start_time).getTime();
        long end_times = dateFormat.parse(end_time).getTime();
        Integer period = (int) ((end_times - start_times) / 86400000L);
        stu_name = EncodeUtil.transcoding(stu_name);
        type = EncodeUtil.transcoding(type);
        result = EncodeUtil.transcoding(result);
        course_list = EncodeUtil.transcoding(course_list);
        course_list = course_list
                // .substring(1, course_list.length() - 1)
                .replaceAll("\"", "");
        Vacate vacate = new Vacate(vacate_id,
                id,
                stu_name,
                "2019-2020-1",
                String.valueOf(submit_times),
                String.valueOf(start_times),
                String.valueOf(end_times),
                period,
                type,
                result,
                course_list,
                1,
                0);
        int count = studentService.addVacate(vacate);

        //学生请假表添加记录
        StudentVacate studentVacate = new StudentVacate(id, vacate_id);
        studentService.addStudentVacate(studentVacate);

        //辅导员请假表添加记录
        String tutor_id = studentService.findTutorByGrade(grade_id);
        TutorVacate tutorVacate = new TutorVacate(tutor_id, vacate_id);
        studentService.addTutorVacate(tutorVacate);

        return count;
    }

    @GetMapping("find_course")
    public List findCourseBy(@RequestParam("start_time") String start_time,
                             @RequestParam("end_time") String end_time,
                             @RequestParam("course_list") String course_list) {
        int start_week = DateUtil.dateToWeek(start_time);
        int end_week = DateUtil.dateToWeek(end_time);
        List<String> list = Arrays.asList(course_list.split(","));
        HashMap<String, Object> map = new HashMap<>();
        map.put("start_week", start_week);
        map.put("end_week", end_week);
        map.put("course_list", list);
        List courseList = studentService.findCourse(map);
        return courseList;
    }

    // 微信小程序接口
    @GetMapping("find_passVacate")
    public List<Vacate> findPassVacate(@RequestParam("stu_id") String stu_id) {
        List<Vacate> list = studentService.findPassVacate(stu_id);
        return DateUtil.formatList(list);
    }

    // 微信小程序接口
    @GetMapping("find_checkingVacate")
    public List<Vacate> findCheckingVacate(@RequestParam("stu_id") String stu_id) {
        List<Vacate> list = studentService.findCheckingVacate(stu_id);
        return DateUtil.formatList(list);
    }

    // 微信小程序接口
    @GetMapping("find_failVacate")
    public List<Vacate> findFailVacate(@RequestParam("stu_id") String stu_id) {
        List<Vacate> list = studentService.findFailVacate(stu_id);
        return DateUtil.formatList(list);
    }

    // 微信小程序接口
    @GetMapping("find_byTime")
    public List<Vacate> findByTime(@RequestParam("user_id") String stu_id,
                                   @RequestParam("start_time") String start_time,
                                   @RequestParam("end_time") String end_time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long start_times = dateFormat.parse(start_time).getTime();
        long end_times = dateFormat.parse(end_time).getTime();
        HashMap<String, Object> map = new HashMap<>();
        map.put("stu_id", stu_id);
        map.put("start_time", String.valueOf(start_times));
        map.put("end_time", String.valueOf(end_times));
        List<Vacate> list = studentService.findByTime(map);
        return DateUtil.formatList(list);
    }

    // 微信小程序接口
    @GetMapping("find_byTerm")
    public List<Vacate> findByTerm(@RequestParam("user_id") String stu_id,
                                   @RequestParam("term") String term) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("stu_id", stu_id);
        map.put("term", term);
        List<Vacate> list = studentService.findByTerm(map);
        return DateUtil.formatList(list);
    }

    // 微信小程序接口
    @GetMapping("find_byType")
    public List<Vacate> findByResult(@RequestParam("user_id") String stu_id,
                                     @RequestParam("type") String type) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("stu_id", stu_id);
        map.put("type", EncodeUtil.transcoding(type));
        List<Vacate> list = studentService.findByType(map);
        return DateUtil.formatList(list);
    }

    /* Web接口 分页+单条件查询 */
    @GetMapping("find_vacate")
    public PageUtil findVacate(@RequestParam("user_id") String stu_id,
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
        map1.put("stu_id", stu_id);
        map1.put("start", start);
        map1.put("size", page_size);
        map1.put("start_time", start_time);
        map1.put("end_time", end_time);
        map1.put("term", term);
        map1.put("type", EncodeUtil.transcoding(type));
        List<Vacate> list = DateUtil.formatList(studentService.findVacate(map1));

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("stu_id", stu_id);
        map2.put("start_time", start_time);
        map2.put("end_time", end_time);
        map2.put("term", term);
        map2.put("type", EncodeUtil.transcoding(type));
        Integer count = studentService.findCount(map2);

        PageUtil pu = new PageUtil();
        pu.setCount(count);
        pu.setData(list);
        return pu;
    }
}
