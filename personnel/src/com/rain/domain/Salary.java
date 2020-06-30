package com.rain.domain;

public class Salary implements java.io.Serializable{
    public Integer getId() {
        return s_id;
    }

    public void setId(Integer s_id) {
        this.s_id = s_id;
    }

    private Integer s_id;
    private Integer job_id;
    private Integer dept_id;
    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    private Dept dept;
    private Job job;
    private String name;
    private String card_id;
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

//
//    public String getEwork() {
//        return ework;
//    }
//
//    public void setEwork(String ework) {
//        this.ework = ework;
//    }
//
//    private String ework;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    private String education;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String  phone;


    public Salary(){
        super();
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
