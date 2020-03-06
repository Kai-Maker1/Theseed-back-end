package com.seed.model;

import java.util.Date;

public class Information {
    private String infoId;

    private String infoTitle;

    private String infoBrief;

    private String pictureUrl;

    private String teacherId;

    private String teacherName;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    private String content;

    public Information(String infoId, String infoTitle, String infoBrief, String pictureUrl, String teacherId, String teacherName, Date createTime, Date updateTime, Boolean del, String content) {
        this.infoId = infoId;
        this.infoTitle = infoTitle;
        this.infoBrief = infoBrief;
        this.pictureUrl = pictureUrl;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
        this.content = content;
    }

    public Information() {
        super();
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle == null ? null : infoTitle.trim();
    }

    public String getInfoBrief() {
        return infoBrief;
    }

    public void setInfoBrief(String infoBrief) {
        this.infoBrief = infoBrief == null ? null : infoBrief.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}