package com.seed.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seed.util.serializer.Date2StringSerializer;

import java.util.Date;

public class CourseNotice {
    private String noticeId;

    private String courseId;

    private String teacherId;

    private String teacherName;

    private String noticeTitle;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date updateTime;

    private Boolean del;

    private String content;

    public CourseNotice(String noticeId, String courseId, String teacherId, String teacherName, String noticeTitle, Date createTime, Date updateTime, Boolean del, String content) {
        this.noticeId = noticeId;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.noticeTitle = noticeTitle;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
        this.content = content;
    }

    public CourseNotice() {
        super();
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
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

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}