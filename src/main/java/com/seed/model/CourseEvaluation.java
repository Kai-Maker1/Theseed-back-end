package com.seed.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seed.util.serializer.Date2StringSerializer;

import java.util.Date;

public class CourseEvaluation {
    private Integer courseEvaluationId;

    private String courseId;

    private String stuId;

    private String userNickname;

    private String header;

    private Integer score;

    private String content;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date updateTime;

    private Boolean del;

    public CourseEvaluation(Integer courseEvaluationId, String courseId, String stuId, String userNickname, String header, Integer score, String content, Date createTime, Date updateTime, Boolean del) {
        this.courseEvaluationId = courseEvaluationId;
        this.courseId = courseId;
        this.stuId = stuId;
        this.userNickname = userNickname;
        this.header = header;
        this.score = score;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public CourseEvaluation() {
        super();
    }

    public Integer getCourseEvaluationId() {
        return courseEvaluationId;
    }

    public void setCourseEvaluationId(Integer courseEvaluationId) {
        this.courseEvaluationId = courseEvaluationId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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