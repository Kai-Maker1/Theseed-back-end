package com.seed.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seed.util.serializer.Date2LongSerializer;
import com.seed.util.serializer.Date2StringSerializer;

import java.util.Date;

public class CourseComment {
    private String commentId;

    private String userNickname;

    private String commentedNickname;

    private String courseId;

    private String commentTitle;

    private String content;

    private Integer likeNum;

    private Integer readNum;

    private String refId;

    private String refContent;

    private Boolean answerstatus;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private Boolean del;

    public CourseComment(String commentId, String userNickname, String commentedNickname, String courseId, String commentTitle, String content, Integer likeNum, Integer readNum, String refId, String refContent, Boolean answerstatus, Date createTime, Date updateTime, Boolean del) {
        this.commentId = commentId;
        this.userNickname = userNickname;
        this.commentedNickname = commentedNickname;
        this.courseId = courseId;
        this.commentTitle = commentTitle;
        this.content = content;
        this.likeNum = likeNum;
        this.readNum = readNum;
        this.refId = refId;
        this.refContent = refContent;
        this.answerstatus = answerstatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public CourseComment() {
        super();
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getCommentedNickname() {
        return commentedNickname;
    }

    public void setCommentedNickname(String commentedNickname) {
        this.commentedNickname = commentedNickname == null ? null : commentedNickname.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle == null ? null : commentTitle.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId == null ? null : refId.trim();
    }

    public String getRefContent() {
        return refContent;
    }

    public void setRefContent(String refContent) {
        this.refContent = refContent == null ? null : refContent.trim();
    }

    public Boolean getAnswerstatus() {
        return answerstatus;
    }

    public void setAnswerstatus(Boolean answerstatus) {
        this.answerstatus = answerstatus;
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