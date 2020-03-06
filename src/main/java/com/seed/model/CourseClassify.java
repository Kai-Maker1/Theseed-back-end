package com.seed.model;

import java.util.Date;

public class CourseClassify {
    private Integer courseClassifyId;

    private String name;

    private String code;

    private String parentName;

    private String parentCode;

    private Integer sort;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public CourseClassify(Integer courseClassifyId, String name, String code, String parentName, String parentCode, Integer sort, Date createTime, Date updateTime, Boolean del) {
        this.courseClassifyId = courseClassifyId;
        this.name = name;
        this.code = code;
        this.parentName = parentName;
        this.parentCode = parentCode;
        this.sort = sort;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public CourseClassify() {
        super();
    }

    public Integer getCourseClassifyId() {
        return courseClassifyId;
    }

    public void setCourseClassifyId(Integer courseClassifyId) {
        this.courseClassifyId = courseClassifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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