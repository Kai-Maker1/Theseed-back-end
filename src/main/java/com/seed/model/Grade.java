package com.seed.model;

import java.util.Date;

public class Grade {
    private String gradeId;

    private String gradeName;

    private String gradeCode;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public Grade(String gradeId, String gradeName, String gradeCode, Date createTime, Date updateTime, Boolean del) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.gradeCode = gradeCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public Grade() {
        super();
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId == null ? null : gradeId.trim();
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode == null ? null : gradeCode.trim();
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