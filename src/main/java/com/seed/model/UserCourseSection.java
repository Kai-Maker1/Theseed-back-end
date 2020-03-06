package com.seed.model;

import java.util.Date;

public class UserCourseSection {
    private String userCourseSectionId;

    private String stuId;

    private String courseId;

    private String sectionId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public UserCourseSection(String userCourseSectionId, String stuId, String courseId, String sectionId, Integer status, Date createTime, Date updateTime, Boolean del) {
        this.userCourseSectionId = userCourseSectionId;
        this.stuId = stuId;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public UserCourseSection() {
        super();
    }

    public String getUserCourseSectionId() {
        return userCourseSectionId;
    }

    public void setUserCourseSectionId(String userCourseSectionId) {
        this.userCourseSectionId = userCourseSectionId == null ? null : userCourseSectionId.trim();
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

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId == null ? null : sectionId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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