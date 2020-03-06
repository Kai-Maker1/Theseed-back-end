package com.seed.model;

import java.util.Date;

public class Major {
    private String majorId;

    private String majorName;

    private String majorCode;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public Major(String majorId, String majorName, String majorCode, Date createTime, Date updateTime, Boolean del) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.majorCode = majorCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public Major() {
        super();
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
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