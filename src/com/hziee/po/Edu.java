package com.hziee.po;

public class Edu implements User {
    private Integer id;
    private String edu_id;
    private String pwd;

    public Edu() {}

    public Edu(String edu_id, String pwd) {
        this.edu_id = edu_id;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEdu_id() {
        return edu_id;
    }

    public void setEdu_id(String edu_id) {
        this.edu_id = edu_id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
