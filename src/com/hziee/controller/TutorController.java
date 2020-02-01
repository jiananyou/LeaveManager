package com.hziee.controller;

import com.hziee.po.EduVacate;
import com.hziee.po.Vacate;
import com.hziee.service.TutorService;
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
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("tutor")
public class TutorController {
    @Autowired
    private TutorService tutorService;

    @GetMapping("accept")
    public List<Vacate> accept(@RequestParam("user_id") String tutor_id,
                               // @RequestParam("edu_id") String edu_id,
                               @RequestParam("vacate_id") String vacate_id) {
        tutorService.updateVacate(vacate_id);
        tutorService.updateAcceptTutorVacate(vacate_id);
        EduVacate eduVacate = new EduVacate("3001", vacate_id, 0);
        tutorService.addEduVacate(eduVacate);
        return findCheckingVacate(tutor_id);
    }

    @GetMapping("refuse")
    public List<Vacate> refuse(@RequestParam("user_id") String tutor_id,
                               @RequestParam("vacate_id") String vacate_id) {
        tutorService.updateRefuseStudentVacate(vacate_id);
        tutorService.updateRefuseTutorVacate(vacate_id);
        return findCheckingVacate(tutor_id);
    }

    @GetMapping("find_passVacate")
    public List<Vacate> findPassVacate(@RequestParam("tutor_id") String tutor_id) {
        List<Vacate> list = tutorService.findPassVacate(tutor_id);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_checkingVacate")
    public List<Vacate> findCheckingVacate(@RequestParam("id") String tutor_id) {
        List<Vacate> list = tutorService.findCheckingVacate(tutor_id);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_failVacate")
    public List<Vacate> findFailVacate(@RequestParam("tutor_id") String tutor_id) {
        List<Vacate> list = tutorService.findFailVacate(tutor_id);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_byTime")
    public List<Vacate> findByTime(@RequestParam("user_id") String tutor_id,
                                   @RequestParam("start_time") String start_time,
                                   @RequestParam("end_time") String end_time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long start_times = dateFormat.parse(start_time).getTime();
        long end_times = dateFormat.parse(end_time).getTime();
        HashMap<String, Object> map = new HashMap<>();
        map.put("tutor_id", tutor_id);
        map.put("start_time", String.valueOf(start_times));
        map.put("end_time", String.valueOf(end_times));
        List<Vacate> list = tutorService.findByTime(map);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_byTerm")
    public List<Vacate> findByTerm(@RequestParam("user_id") String tutor_id,
                                   @RequestParam("term") String term) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("tutor_id", tutor_id);
        map.put("term", term);
        List<Vacate> list = tutorService.findByTerm(map);
        return DateUtil.formatList(list);
    }

    @GetMapping("find_byType")
    public List<Vacate> findByResult(@RequestParam("user_id") String tutor_id,
                                     @RequestParam("type") String type) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("tutor_id", tutor_id);
        map.put("type", EncodeUtil.transcoding(type));
        List<Vacate> list = tutorService.findByType(map);
        return DateUtil.formatList(list);
    }

    /* Web接口 分页+单条件查询 */
    @GetMapping("find_vacate")
    public PageUtil findVacate(@RequestParam("user_id") String tutor_id,
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
        map1.put("tutor_id", tutor_id);
        map1.put("start", start);
        map1.put("size", page_size);
        map1.put("start_time", start_time);
        map1.put("end_time", end_time);
        map1.put("term", term);
        map1.put("type", EncodeUtil.transcoding(type));
        List<Vacate> list = DateUtil.formatList(tutorService.findVacate(map1));

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("tutor_id", tutor_id);
        map2.put("start_time", start_time);
        map2.put("end_time", end_time);
        map2.put("term", term);
        map2.put("type", EncodeUtil.transcoding(type));
        Integer count = tutorService.findCount(map2);

        PageUtil pu = new PageUtil();
        pu.setCount(count);
        pu.setData(list);
        return pu;
    }
}
