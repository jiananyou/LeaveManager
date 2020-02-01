package com.hziee.po;

public class TutorVacate {
    private String tutor_id;
    private String vacate_id;
    private Integer status;

    public TutorVacate() {
    }

    public TutorVacate(String tutor_id, String vacate_id) {
        this.tutor_id = tutor_id;
        this.vacate_id = vacate_id;
    }

    public String getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(String tutor_id) {
        this.tutor_id = tutor_id;
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
