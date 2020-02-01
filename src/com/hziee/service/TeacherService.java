package com.hziee.service;

import com.hziee.mapper.TeacherMapper;
import com.hziee.po.Teacher;
import com.hziee.po.Vacate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher findTeacherById(String teacher_id) {
        return teacherMapper.findTeacherById(teacher_id);
    }

    public Integer updatePwdById(HashMap<String, Object> map) {
        return teacherMapper.updatePwdById(map);
    }

    public List<Vacate> findNotReadVacate(String teacher_id) {
        return teacherMapper.findNotReadVacate(teacher_id);
    }

    public List<Vacate> findReadVacate(String teacher_id) {
        return teacherMapper.findReadVacate(teacher_id);
    }

    public Integer updateReadVacate(HashMap<String, Object> map) {
        return teacherMapper.updateReadVacate(map);
    }

    public List<Vacate> findByTime(HashMap<String, Object> map) {
        return teacherMapper.findByTime(map);
    }

    public List<Vacate> findByTerm(HashMap<String, Object> map) {
        return teacherMapper.findByTerm(map);
    }

    public List<Vacate> findByType(HashMap<String, Object> map) {
        return teacherMapper.findByType(map);
    }

    public List<Vacate> findVacate(HashMap<String, Object> map) {
        return teacherMapper.findVacate(map);
    }

    public Integer findCount(HashMap<String, Object> map) {
        return teacherMapper.findCount(map);
    }
}
