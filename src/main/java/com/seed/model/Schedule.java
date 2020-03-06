package com.seed.model;

import java.util.Date;

public class Schedule {
    private String scheduleId;

    private String openId;

    private Byte number;

    private String lessonName;

    private String teacherId;

    private String teacherName;

    private String time;

    private String place;

    private String week;

    private String term;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public Schedule(String scheduleId, String openId, Byte number, String lessonName, String teacherId, String teacherName, String time, String place, String week, String term, Date createTime, Date updateTime, Boolean del) {
        this.scheduleId = scheduleId;
        this.openId = openId;
        this.number = number;
        this.lessonName = lessonName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.time = time;
        this.place = place;
        this.week = week;
        this.term = term;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public Schedule() {
        super();
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId == null ? null : scheduleId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Byte getNumber() {
        return number;
    }

    public void setNumber(Byte number) {
        this.number = number;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName == null ? null : lessonName.trim();
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
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