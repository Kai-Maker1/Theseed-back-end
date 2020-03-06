package com.seed.model;

import java.util.Date;

public class Teacher {
    private String teacherId;

    private String teacherName;

    private String password;

    private String openId;

    private String nickname;

    private Boolean gender;

    private String header;

    private Boolean status;

    private String collegeId;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public Teacher(String teacherId, String teacherName, String password, String openId, String nickname, Boolean gender, String header, Boolean status, String collegeId, Date createTime, Date updateTime, Boolean del) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.password = password;
        this.openId = openId;
        this.nickname = nickname;
        this.gender = gender;
        this.header = header;
        this.status = status;
        this.collegeId = collegeId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public Teacher() {
        super();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
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