package com.hziee.po;

public class Student implements User{
    private Integer id;
    private String stu_id;
    private String name;
    private String grade_id;
    private String pwd;
    private String course_list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCourse_list() {
        return course_list;
    }

    public void setCourse_list(String course_list) {
        this.course_list = course_list;
    }
}
