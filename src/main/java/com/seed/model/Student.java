package com.seed.model;

import java.util.Date;

public class Student {
    private String stuId;

    private String stuName;

    private String password;

    private String openId;

    private String nickname;

    private Boolean gender;

    private String header;

    private Boolean status;

    private String majorId;

    private String classId;

    private String collegeId;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public Student(String stuId, String stuName, String password, String openId, String nickname, Boolean gender, String header, Boolean status, String majorId, String classId, String collegeId, Date createTime, Date updateTime, Boolean del) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.password = password;
        this.openId = openId;
        this.nickname = nickname;
        this.gender = gender;
        this.header = header;
        this.status = status;
        this.majorId = majorId;
        this.classId = classId;
        this.collegeId = collegeId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public Student() {
        super();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }
}