package com.hziee.mapper;

import com.hziee.po.Teacher;
import com.hziee.po.Vacate;

import java.util.HashMap;
import java.util.List;

public interface TeacherMapper {
    public Teacher findTeacherById(String teacher_id);
    public Integer updatePwdById(HashMap<String, Object> map);

    public List<Vacate> findNotReadVacate(String teacher_id);
    public List<Vacate> findReadVacate(String teacher_id);
    public Integer updateReadVacate(HashMap<String, Object> map);

    public List<Vacate> findByTime(HashMap<String, Object> map);
    public List<Vacate> findByTerm(HashMap<String, Object> map);
    public List<Vacate> findByType(HashMap<String, Object> map);

    public List<Vacate> findVacate(HashMap<String, Object> map);
    public Integer findCount(HashMap<String, Object> map);
}
