package com.seed.model;

import java.util.Date;

public class CourseStatusOne {
    private Integer courseStatusoneId;

    private String status;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public CourseStatusOne(Integer courseStatusoneId, String status, Date createTime, Date updateTime, Boolean del) {
        this.courseStatusoneId = courseStatusoneId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public CourseStatusOne() {
        super();
    }

    public Integer getCourseStatusoneId() {
        return courseStatusoneId;
    }

    public void setCourseStatusoneId(Integer courseStatusoneId) {
        this.courseStatusoneId = courseStatusoneId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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