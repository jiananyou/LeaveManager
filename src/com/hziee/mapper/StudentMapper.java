package com.hziee.mapper;

import com.hziee.po.Student;
import com.hziee.po.StudentVacate;
import com.hziee.po.TutorVacate;
import com.hziee.po.Vacate;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
    public Student findStudentById(String stu_id);
    public Integer updatePwdById(HashMap<String, Object> map);

    public Integer addVacate(Vacate vacate);
    public Integer addStudentVacate(StudentVacate studentVacate);
    public Integer addTutorVacate(TutorVacate tutorVacate);
    public String findTutorByGrade(String grade_id);
    public List<String> findCourse(HashMap<String, Object> map);
    public List<Vacate> findPassVacate(String stu_id);
    public List<Vacate> findCheckingVacate(String stu_id);
    public List<Vacate> findFailVacate(String stu_id);
    public List<Vacate> findByTime(HashMap<String, Object> map);
    public List<Vacate> findByTerm(HashMap<String, Object> map);
    public List<Vacate> findByType(HashMap<String, Object> map);

    public List<Vacate> findVacate(HashMap<String, Object> map);
    public Integer findCount(HashMap<String, Object> map);
}
