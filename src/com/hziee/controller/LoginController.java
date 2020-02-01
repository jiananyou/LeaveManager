package com.hziee.controller;

import com.hziee.po.*;
import com.hziee.service.EduService;
import com.hziee.service.StudentService;
import com.hziee.service.TeacherService;
import com.hziee.service.TutorService;
import com.hziee.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private EduService eduService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("login")
    public User login(@RequestParam("id") String id,
                      @RequestParam("pwd") String pwd,
                      @RequestParam("identity") String identity) {
        String encodedId = EncodeUtil.transcoding(identity);
        switch (encodedId) {
            case "学生":
                Student student = studentService.findStudentById(id);
                if (student != null && pwd.equals(student.getPwd())) {
                    return student;
                }
                return null;
            case "辅导员":
                Tutor tutor = tutorService.findTutorById(id);
                if (tutor != null && pwd.equals(tutor.getPwd())) {
                    return tutor;
                }
                return null;
            case "学院":
                Edu edu = eduService.findEduById(id);
                if (edu != null && pwd.equals(edu.getPwd())) {
                    return edu;
                }
                return null;
            case "老师":
                Teacher teacher = teacherService.findTeacherById(id);
                if (teacher != null && pwd.equals(teacher.getPwd())) {
                    return teacher;
                }
                return null;
            default:
                System.out.println("未匹配");
                return null;
        }
    }

    @GetMapping("changePwd")
    public User changePwd(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          @RequestParam("identity") String identity) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("pwd", pwd);
        String encodedId = EncodeUtil.transcoding(identity);
        switch (encodedId) {
            case "学生":
                studentService.updatePwdById(map);
                return studentService.findStudentById(id);
            case "辅导员":
                tutorService.updatePwdById(map);
                return tutorService.findTutorById(id);
            case "学院":
                eduService.updatePwdById(map);
                return eduService.findEduById(id);
            case "老师":
                teacherService.updatePwdById(map);
                return teacherService.findTeacherById(id);
            default:
                System.out.println("未匹配");
                return null;
        }
    }
}
