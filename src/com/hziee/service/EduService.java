package com.hziee.service;

import com.hziee.mapper.EduMapper;
import com.hziee.po.Edu;
import com.hziee.po.TeacherVacate;
import com.hziee.po.Tutor;
import com.hziee.po.Vacate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class EduService {
    @Autowired
    private EduMapper eduMapper;

    public Edu findEduById(String edu_id) {
        return eduMapper.findEduById(edu_id);
    }

    public Integer updatePwdById(HashMap<String, Object> map) {
        return eduMapper.updatePwdById(map);
    }

    public List<Vacate> findPassVacate(String edu_id) {
        return eduMapper.findPassVacate(edu_id);
    }

    public List<Vacate> findCheckingVacate(String edu_id) {
        return eduMapper.findCheckingVacate(edu_id);
    }

    public List<Vacate> findFailVacate(String edu_id) {
        return eduMapper.findFailVacate(edu_id);
    }

    public Integer updateVacate(String vacate_id) {
        return eduMapper.updateVacate(vacate_id);
    }

    public Integer updateAcceptEduVacate(String vacate_id) {
        return eduMapper.updateAcceptEduVacate(vacate_id);
    }

    public Integer updateAcceptStudentVacate(String vacate_id) {
        return eduMapper.updateAcceptStudentVacate(vacate_id);
    }

    public String findCourseListByVacateId(String vacate_id) {
        return eduMapper.findCourseListByVacateId(vacate_id);
    }

    public List<String> findTeacherIdByCourseList(List<String> courseList) {
        return eduMapper.findTeacherIdByCourseList(courseList);
    }

    public Integer addTeacherVacate(TeacherVacate teacherVacate) {
        return eduMapper.addTeacherVacate(teacherVacate);
    }

    public Integer updateRefuseStudentVacate(String vacate_id) {
        return eduMapper.updateRefuseStudentVacate(vacate_id);
    }

    public Integer updateRefuseEduVacate(String vacate_id) {
        return eduMapper.updateRefuseEduVacate(vacate_id);
    }

    public List<Vacate> findByTime(HashMap<String, Object> map) {
        return eduMapper.findByTime(map);
    }

    public List<Vacate> findByTerm(HashMap<String, Object> map) {
        return eduMapper.findByTerm(map);
    }

    public List<Vacate> findByType(HashMap<String, Object> map) {
        return eduMapper.findByType(map);
    }

    public List<Vacate> findVacate(HashMap<String, Object> map) {
        return eduMapper.findVacate(map);
    }

    public Integer findCount(HashMap<String, Object> map) {
        return eduMapper.findCount(map);
    }

    public Integer findIll() {
        return eduMapper.findIll();
    }

    public Integer findThing() {
        return eduMapper.findThing();
    }

    public Integer findWork() {
        return eduMapper.findWork();
    }

    public Integer findOthers() {
        return eduMapper.findOthers();
    }

    public void addTutor(List<Tutor> tutorList) {
        for (Tutor tutor : tutorList) {
            eduMapper.addTutor(tutor);
        }
    }
}
