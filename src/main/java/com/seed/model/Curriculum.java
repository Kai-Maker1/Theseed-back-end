package com.seed.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seed.util.serializer.Date2StringSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class Curriculum {
    private String courseId;

    private String courseName;

    private Integer classifyId;

    private String classifyName;

    private Integer subClassifyId;

    private String subClassifyName;

    private String teacherId;

    private String teacherName;

    private String level;

    private Boolean free;

    private BigDecimal price;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date begintime;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date endtime;

    private String status;

    private String icon;

    private String picture;

    private Boolean recommend;

    private Integer weight;

    private Integer studyCount;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    private String brief;

    public Curriculum(String courseId, String courseName, Integer classifyId, String classifyName, Integer subClassifyId, String subClassifyName, String teacherId, String teacherName, String level, Boolean free, BigDecimal price, Date begintime, Date endtime, String status, String icon, String picture, Boolean recommend, Integer weight, Integer studyCount, Date createTime, Date updateTime, Boolean del, String brief) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.classifyId = classifyId;
        this.classifyName = classifyName;
        this.subClassifyId = subClassifyId;
        this.subClassifyName = subClassifyName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.level = level;
        this.free = free;
        this.price = price;
        this.begintime = begintime;
        this.endtime = endtime;
        this.status = status;
        this.icon = icon;
        this.picture = picture;
        this.recommend = recommend;
        this.weight = weight;
        this.studyCount = studyCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
        this.brief = brief;
    }

    public Curriculum() {
        super();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public Integer getSubClassifyId() {
        return subClassifyId;
    }

    public void setSubClassifyId(Integer subClassifyId) {
        this.subClassifyId = subClassifyId;
    }

    public String getSubClassifyName() {
        return subClassifyName;
    }

    public void setSubClassifyName(String subClassifyName) {
        this.subClassifyName = subClassifyName == null ? null : subClassifyName.trim();
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStudyCount() {
        return studyCount;
    }

    public void setStudyCount(Integer studyCount) {
        this.studyCount = studyCount;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }
}