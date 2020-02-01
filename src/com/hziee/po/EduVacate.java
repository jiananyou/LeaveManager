package com.hziee.po;

public class EduVacate {
    private String edu_id;
    private String vacate_id;
    private Integer status;

    public EduVacate() {}

    public EduVacate(String edu_id, String vacate_id, Integer status) {
        this.edu_id = edu_id;
        this.vacate_id = vacate_id;
        this.status = status;
    }

    public String getEdu_id() {
        return edu_id;
    }

    public void setEdu_id(String edu_id) {
        this.edu_id = edu_id;
    }

    public String getVacate_id() {
        return vacate_id;
    }

    public void setVacate_id(String vacate_id) {
        this.vacate_id = vacate_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
