package com.hziee.mapper;

import com.hziee.po.Edu;
import com.hziee.po.TeacherVacate;
import com.hziee.po.Tutor;
import com.hziee.po.Vacate;

import java.util.HashMap;
import java.util.List;

public interface EduMapper {
    public Edu findEduById(String edu_id);
    public Integer updatePwdById(HashMap<String, Object> map);

    public Integer updateVacate(String vacate_id);
    public Integer updateAcceptEduVacate(String vacate_id);
    public Integer updateAcceptStudentVacate(String vacate_id);
    public String findCourseListByVacateId(String vacate_id);
    public List<String> findTeacherIdByCourseList(List<String> courseList);
    public Integer addTeacherVacate(TeacherVacate teacherVacate);

    public Integer updateRefuseStudentVacate(String vacate_id);
    public Integer updateRefuseEduVacate(String vacate_id);

    public List<Vacate> findPassVacate(String edu_id);
    public List<Vacate> findCheckingVacate(String edu_id);
    public List<Vacate> findFailVacate(String edu_id);
    public List<Vacate> findByTime(HashMap<String, Object> map);
    public List<Vacate> findByTerm(HashMap<String, Object> map);
    public List<Vacate> findByType(HashMap<String, Object> map);

    public List<Vacate> findVacate(HashMap<String, Object> map);
    public Integer findCount(HashMap<String, Object> map);

    public Integer findIll(); // 病假总数
    public Integer findThing(); // 事假总数
    public Integer findWork(); // 辅助工作总数
    public Integer findOthers(); // 其他总数

    public Integer addTutor(Tutor tutor); // 插入Excel中的辅导员信息
}
