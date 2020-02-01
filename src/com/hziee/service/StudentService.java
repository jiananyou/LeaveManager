package com.hziee.service;

import com.hziee.mapper.StudentMapper;
import com.hziee.po.Student;
import com.hziee.po.StudentVacate;
import com.hziee.po.TutorVacate;
import com.hziee.po.Vacate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student findStudentById(String stu_id) {
        return studentMapper.findStudentById(stu_id);
    }

    public Integer updatePwdById(HashMap<String, Object> map) {
        return studentMapper.updatePwdById(map);
    }

    public Integer addVacate(Vacate vacate) {
        return studentMapper.addVacate(vacate);
    }

    public Integer addStudentVacate(StudentVacate studentVacate) {
        return studentMapper.addStudentVacate(studentVacate);
    }

    public Integer addTutorVacate(TutorVacate tutorVacate) {
        return studentMapper.addTutorVacate(tutorVacate);
    }

    public String findTutorByGrade(String grade_id) {
        return studentMapper.findTutorByGrade(grade_id);
    }

    public List findCourse(HashMap<String, Object> map) {
        return studentMapper.findCourse(map);
    }

    public List<Vacate> findPassVacate(String stu_id) {
        return studentMapper.findPassVacate(stu_id);
    }

    public List<Vacate> findCheckingVacate(String stu_id) {
        return studentMapper.findCheckingVacate(stu_id);
    }

    public List<Vacate> findFailVacate(String stu_id) {
        return studentMapper.findFailVacate(stu_id);
    }

    public List<Vacate> findByTime(HashMap<String, Object> map) {
        return studentMapper.findByTime(map);
    }

    public List<Vacate> findByTerm(HashMap<String, Object> map) {
        return studentMapper.findByTerm(map);
    }

    public List<Vacate> findByType(HashMap<String, Object> map) {
        return studentMapper.findByType(map);
    }

    public List<Vacate> findVacate(HashMap<String, Object> map) {
        return studentMapper.findVacate(map);
    }

    public Integer findCount(HashMap<String, Object> map) {
        return studentMapper.findCount(map);
    }
}
