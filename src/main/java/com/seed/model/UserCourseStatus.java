package com.seed.model;

import java.util.Date;

public class UserCourseStatus {
    private Integer userCourseStatusId;

    private String stuId;

    private String courseId;

    private String status;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public UserCourseStatus(Integer userCourseStatusId, String stuId, String courseId, String status, Date createTime, Date updateTime, Boolean del) {
        this.userCourseStatusId = userCourseStatusId;
        this.stuId = stuId;
        this.courseId = courseId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public UserCourseStatus() {
        super();
    }

    public Integer getUserCourseStatusId() {
        return userCourseStatusId;
    }

    public void setUserCourseStatusId(Integer userCourseStatusId) {
        this.userCourseStatusId = userCourseStatusId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
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