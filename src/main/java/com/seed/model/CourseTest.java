package com.seed.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seed.util.serializer.Date2StringSerializer;

import java.util.Date;

public class CourseTest {
    private String testId;

    private String courseId;

    private String testTitle;

    private Byte totalPoints;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date endtime;

    private String stuId;

    private String openId;

    private Byte score;

    private Boolean status;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date updateTime;

    private Boolean del;

    public CourseTest(String testId, String courseId, String testTitle, Byte totalPoints, Date endtime, String stuId, String openId, Byte score, Boolean status, Date createTime, Date updateTime, Boolean del) {
        this.testId = testId;
        this.courseId = courseId;
        this.testTitle = testTitle;
        this.totalPoints = totalPoints;
        this.endtime = endtime;
        this.stuId = stuId;
        this.openId = openId;
        this.score = score;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public CourseTest() {
        super();
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId == null ? null : testId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle == null ? null : testTitle.trim();
    }

    public Byte getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Byte totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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