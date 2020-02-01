package com.hziee.po;

public class TeacherVacate {
    private String teacher_id;
    private String vacate_id;
    private Integer status;

    public TeacherVacate() {}

    public TeacherVacate(String teacher_id, String vacate_id, Integer status) {
        this.teacher_id = teacher_id;
        this.vacate_id = vacate_id;
        this.status = status;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
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
