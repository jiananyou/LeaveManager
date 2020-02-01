package com.hziee.mapper;

import com.hziee.po.EduVacate;
import com.hziee.po.Tutor;
import com.hziee.po.Vacate;

import java.util.HashMap;
import java.util.List;

public interface TutorMapper {
    public Tutor findTutorById(String tutor_id);
    public Integer updatePwdById(HashMap<String, Object> map);

    public Integer updateVacate(String vacate_id);
    public Integer updateAcceptTutorVacate(String vacate_id);
    public Integer updateRefuseStudentVacate(String vacate_id);
    public Integer updateRefuseTutorVacate(String vacate_id);
    public Integer addEduVacate(EduVacate eduVacate);

    public List<Vacate> findPassVacate(String tutor_id);
    public List<Vacate> findCheckingVacate(String tutor_id);
    public List<Vacate> findFailVacate(String tutor_id);
    public List<Vacate> findByTime(HashMap<String, Object> map);
    public List<Vacate> findByTerm(HashMap<String, Object> map);
    public List<Vacate> findByType(HashMap<String, Object> map);

    public List<Vacate> findVacate(HashMap<String, Object> map);
    public Integer findCount(HashMap<String, Object> map);
}
