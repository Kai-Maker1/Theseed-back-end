package com.seed.model;

import java.util.Date;

public class UserCourseCommend {
    private Integer userCourseCommendId;

    private String stuId;

    private String courseId;

    private Boolean recommend;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public UserCourseCommend(Integer userCourseCommendId, String stuId, String courseId, Boolean recommend, Date createTime, Date updateTime, Boolean del) {
        this.userCourseCommendId = userCourseCommendId;
        this.stuId = stuId;
        this.courseId = courseId;
        this.recommend = recommend;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public UserCourseCommend() {
        super();
    }

    public Integer getUserCourseCommendId() {
        return userCourseCommendId;
    }

    public void setUserCourseCommendId(Integer userCourseCommendId) {
        this.userCourseCommendId = userCourseCommendId;
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

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
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