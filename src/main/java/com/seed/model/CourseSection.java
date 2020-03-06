package com.seed.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seed.util.serializer.Date2StringSerializer;

import java.util.Date;

public class CourseSection {
    private Integer courseSectionId;

    private String courseId;

    private Integer parentId;

    private String sectionName;

    private Integer sort;

    private String time;

    private Boolean onsale;

    private String videoUrl;

    private String pptUrl;

    private String homeworkUrl;

    private String testUrl;

    private String discussionUrl;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date endtime;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date updateTime;

    private Boolean del;

    public CourseSection(Integer courseSectionId, String courseId, Integer parentId, String sectionName, Integer sort, String time, Boolean onsale, String videoUrl, String pptUrl, String homeworkUrl, String testUrl, String discussionUrl, Date endtime, Date createTime, Date updateTime, Boolean del) {
        this.courseSectionId = courseSectionId;
        this.courseId = courseId;
        this.parentId = parentId;
        this.sectionName = sectionName;
        this.sort = sort;
        this.time = time;
        this.onsale = onsale;
        this.videoUrl = videoUrl;
        this.pptUrl = pptUrl;
        this.homeworkUrl = homeworkUrl;
        this.testUrl = testUrl;
        this.discussionUrl = discussionUrl;
        this.endtime = endtime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public CourseSection() {
        super();
    }

    public Integer getCourseSectionId() {
        return courseSectionId;
    }

    public void setCourseSectionId(Integer courseSectionId) {
        this.courseSectionId = courseSectionId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Boolean getOnsale() {
        return onsale;
    }

    public void setOnsale(Boolean onsale) {
        this.onsale = onsale;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getPptUrl() {
        return pptUrl;
    }

    public void setPptUrl(String pptUrl) {
        this.pptUrl = pptUrl == null ? null : pptUrl.trim();
    }

    public String getHomeworkUrl() {
        return homeworkUrl;
    }

    public void setHomeworkUrl(String homeworkUrl) {
        this.homeworkUrl = homeworkUrl == null ? null : homeworkUrl.trim();
    }

    public String getTestUrl() {
        return testUrl;
    }

    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl == null ? null : testUrl.trim();
    }

    public String getDiscussionUrl() {
        return discussionUrl;
    }

    public void setDiscussionUrl(String discussionUrl) {
        this.discussionUrl = discussionUrl == null ? null : discussionUrl.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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