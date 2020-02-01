package com.hziee.service;

import com.hziee.mapper.TutorMapper;
import com.hziee.po.EduVacate;
import com.hziee.po.Tutor;
import com.hziee.po.Vacate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class TutorService {
    @Autowired
    private TutorMapper tutorMapper;

    public Tutor findTutorById(String tutor_id) {
        return tutorMapper.findTutorById(tutor_id);
    }

    public Integer updatePwdById(HashMap<String, Object> map) {
        return tutorMapper.updatePwdById(map);
    }

    public Integer updateVacate(String vacate_id) {
        return tutorMapper.updateVacate(vacate_id);
    }

    public Integer updateAcceptTutorVacate(String vacate_id) {
        return tutorMapper.updateAcceptTutorVacate(vacate_id);
    }

    public Integer updateRefuseStudentVacate(String vacate_id) {
        return tutorMapper.updateRefuseStudentVacate(vacate_id);
    }

    public Integer updateRefuseTutorVacate(String vacate_id) {
        return tutorMapper.updateRefuseTutorVacate(vacate_id);
    }

    public Integer addEduVacate(EduVacate eduVacate) {
        return tutorMapper.addEduVacate(eduVacate);
    }

    public List<Vacate> findPassVacate(String tutor_id) {
        return tutorMapper.findPassVacate(tutor_id);
    }

    public List<Vacate> findCheckingVacate(String tutor_id) {
        return tutorMapper.findCheckingVacate(tutor_id);
    }

    public List<Vacate> findFailVacate(String tutor_id) {
        return tutorMapper.findFailVacate(tutor_id);
    }

    public List<Vacate> findByTime(HashMap<String, Object> map) {
        return tutorMapper.findByTime(map);
    }

    public List<Vacate> findByTerm(HashMap<String, Object> map) {
        return tutorMapper.findByTerm(map);
    }

    public List<Vacate> findByType(HashMap<String, Object> map) {
        return tutorMapper.findByType(map);
    }

    public List<Vacate> findVacate(HashMap<String, Object> map) {
        return tutorMapper.findVacate(map);
    }

    public Integer findCount(HashMap<String, Object> map) {
        return tutorMapper.findCount(map);
    }
}
