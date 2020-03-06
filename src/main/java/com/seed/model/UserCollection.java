package com.seed.model;

import java.util.Date;

public class UserCollection {
    private String userCollectionsId;

    private String stuId;

    private Integer classifyId;

    private String objectId;

    private String tips;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public UserCollection(String userCollectionsId, String stuId, Integer classifyId, String objectId, String tips, Date createTime, Date updateTime, Boolean del) {
        this.userCollectionsId = userCollectionsId;
        this.stuId = stuId;
        this.classifyId = classifyId;
        this.objectId = objectId;
        this.tips = tips;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public UserCollection() {
        super();
    }

    public String getUserCollectionsId() {
        return userCollectionsId;
    }

    public void setUserCollectionsId(String userCollectionsId) {
        this.userCollectionsId = userCollectionsId == null ? null : userCollectionsId.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
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