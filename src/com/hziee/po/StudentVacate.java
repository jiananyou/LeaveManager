package com.hziee.po;

public class StudentVacate {
    private String stu_id;
    private String vacate_id;
    private Integer status;

    public StudentVacate() {
    }

    public StudentVacate(String stu_id, String vacate_id) {
        this.stu_id = stu_id;
        this.vacate_id = vacate_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
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
