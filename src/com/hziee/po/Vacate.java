package com.hziee.po;

public class Vacate {
    private String vacate_id;
    private String stu_id;
    private String stu_name;
    private String term;
    private String submit_time;
    private String start_time;
    private String end_time;
    private Integer period;
    private String type;
    private String result;
    private String course_list;
    private Integer step;
    private Integer status;

    public Vacate() {
    }

    public Vacate(String vacate_id, String stu_id, String stu_name, String term, String submit_time, String start_time, String end_time, Integer period, String type, String result, String course_list, Integer step, Integer status) {
        this.vacate_id = vacate_id;
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.term = term;
        this.submit_time = submit_time;
        this.start_time = start_time;
        this.end_time = end_time;
        this.period = period;
        this.type = type;
        this.result = result;
        this.course_list = course_list;
        this.step = step;
        this.status = status;
    }

    public String getVacate_id() {
        return vacate_id;
    }

    public void setVacate_id(String vacate_id) {
        this.vacate_id = vacate_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(String submit_time) {
        this.submit_time = submit_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCourse_list() {
        return course_list;
    }

    public void setCourse_list(String course_list) {
        this.course_list = course_list;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vacate{" +
                "vacate_id='" + vacate_id + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", term='" + term + '\'' +
                ", submit_time='" + submit_time + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", period=" + period +
                ", type='" + type + '\'' +
                ", result='" + result + '\'' +
                ", course_list='" + course_list + '\'' +
                ", step=" + step +
                ", status=" + status +
                '}';
    }
}
