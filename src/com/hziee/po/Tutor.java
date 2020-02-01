package com.hziee.po;

public class Tutor implements User{
    private Integer id;
    private String tutor_id;
    private String name;
    private String pwd;
    private String edu_id;

    public Tutor() {}

    public Tutor(String tutor_id, String name, String pwd, String edu_id) {
        this.tutor_id = tutor_id;
        this.name = name;
        this.pwd = pwd;
        this.edu_id = edu_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(String tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEdu_id() {
        return edu_id;
    }

    public void setEdu_id(String edu_id) {
        this.edu_id = edu_id;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", tutor_id='" + tutor_id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", edu_id='" + edu_id + '\'' +
                '}';
    }
}
