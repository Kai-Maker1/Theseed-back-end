package com.seed.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseSectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseSectionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCourseSectionIdIsNull() {
            addCriterion("course_section_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdIsNotNull() {
            addCriterion("course_section_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdEqualTo(Integer value) {
            addCriterion("course_section_id =", value, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdNotEqualTo(Integer value) {
            addCriterion("course_section_id <>", value, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdGreaterThan(Integer value) {
            addCriterion("course_section_id >", value, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_section_id >=", value, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdLessThan(Integer value) {
            addCriterion("course_section_id <", value, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_section_id <=", value, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdIn(List<Integer> values) {
            addCriterion("course_section_id in", values, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdNotIn(List<Integer> values) {
            addCriterion("course_section_id not in", values, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdBetween(Integer value1, Integer value2) {
            addCriterion("course_section_id between", value1, value2, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseSectionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_section_id not between", value1, value2, "courseSectionId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andSectionNameIsNull() {
            addCriterion("section_name is null");
            return (Criteria) this;
        }

        public Criteria andSectionNameIsNotNull() {
            addCriterion("section_name is not null");
            return (Criteria) this;
        }

        public Criteria andSectionNameEqualTo(String value) {
            addCriterion("section_name =", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotEqualTo(String value) {
            addCriterion("section_name <>", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThan(String value) {
            addCriterion("section_name >", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("section_name >=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThan(String value) {
            addCriterion("section_name <", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThanOrEqualTo(String value) {
            addCriterion("section_name <=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLike(String value) {
            addCriterion("section_name like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotLike(String value) {
            addCriterion("section_name not like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameIn(List<String> values) {
            addCriterion("section_name in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotIn(List<String> values) {
            addCriterion("section_name not in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameBetween(String value1, String value2) {
            addCriterion("section_name between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotBetween(String value1, String value2) {
            addCriterion("section_name not between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andOnsaleIsNull() {
            addCriterion("onsale is null");
            return (Criteria) this;
        }

        public Criteria andOnsaleIsNotNull() {
            addCriterion("onsale is not null");
            return (Criteria) this;
        }

        public Criteria andOnsaleEqualTo(Boolean value) {
            addCriterion("onsale =", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleNotEqualTo(Boolean value) {
            addCriterion("onsale <>", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleGreaterThan(Boolean value) {
            addCriterion("onsale >", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("onsale >=", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleLessThan(Boolean value) {
            addCriterion("onsale <", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleLessThanOrEqualTo(Boolean value) {
            addCriterion("onsale <=", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleIn(List<Boolean> values) {
            addCriterion("onsale in", values, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleNotIn(List<Boolean> values) {
            addCriterion("onsale not in", values, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleBetween(Boolean value1, Boolean value2) {
            addCriterion("onsale between", value1, value2, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("onsale not between", value1, value2, "onsale");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlIsNull() {
            addCriterion("ppt_url is null");
            return (Criteria) this;
        }

        public Criteria andPptUrlIsNotNull() {
            addCriterion("ppt_url is not null");
            return (Criteria) this;
        }

        public Criteria andPptUrlEqualTo(String value) {
            addCriterion("ppt_url =", value, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlNotEqualTo(String value) {
            addCriterion("ppt_url <>", value, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlGreaterThan(String value) {
            addCriterion("ppt_url >", value, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ppt_url >=", value, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlLessThan(String value) {
            addCriterion("ppt_url <", value, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlLessThanOrEqualTo(String value) {
            addCriterion("ppt_url <=", value, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlLike(String value) {
            addCriterion("ppt_url like", value, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlNotLike(String value) {
            addCriterion("ppt_url not like", value, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlIn(List<String> values) {
            addCriterion("ppt_url in", values, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlNotIn(List<String> values) {
            addCriterion("ppt_url not in", values, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlBetween(String value1, String value2) {
            addCriterion("ppt_url between", value1, value2, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andPptUrlNotBetween(String value1, String value2) {
            addCriterion("ppt_url not between", value1, value2, "pptUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlIsNull() {
            addCriterion("homework_url is null");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlIsNotNull() {
            addCriterion("homework_url is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlEqualTo(String value) {
            addCriterion("homework_url =", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlNotEqualTo(String value) {
            addCriterion("homework_url <>", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlGreaterThan(String value) {
            addCriterion("homework_url >", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("homework_url >=", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlLessThan(String value) {
            addCriterion("homework_url <", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlLessThanOrEqualTo(String value) {
            addCriterion("homework_url <=", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlLike(String value) {
            addCriterion("homework_url like", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlNotLike(String value) {
            addCriterion("homework_url not like", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlIn(List<String> values) {
            addCriterion("homework_url in", values, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlNotIn(List<String> values) {
            addCriterion("homework_url not in", values, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlBetween(String value1, String value2) {
            addCriterion("homework_url between", value1, value2, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlNotBetween(String value1, String value2) {
            addCriterion("homework_url not between", value1, value2, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlIsNull() {
            addCriterion("test_url is null");
            return (Criteria) this;
        }

        public Criteria andTestUrlIsNotNull() {
            addCriterion("test_url is not null");
            return (Criteria) this;
        }

        public Criteria andTestUrlEqualTo(String value) {
            addCriterion("test_url =", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlNotEqualTo(String value) {
            addCriterion("test_url <>", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlGreaterThan(String value) {
            addCriterion("test_url >", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("test_url >=", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlLessThan(String value) {
            addCriterion("test_url <", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlLessThanOrEqualTo(String value) {
            addCriterion("test_url <=", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlLike(String value) {
            addCriterion("test_url like", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlNotLike(String value) {
            addCriterion("test_url not like", value, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlIn(List<String> values) {
            addCriterion("test_url in", values, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlNotIn(List<String> values) {
            addCriterion("test_url not in", values, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlBetween(String value1, String value2) {
            addCriterion("test_url between", value1, value2, "testUrl");
            return (Criteria) this;
        }

        public Criteria andTestUrlNotBetween(String value1, String value2) {
            addCriterion("test_url not between", value1, value2, "testUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlIsNull() {
            addCriterion("discussion_url is null");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlIsNotNull() {
            addCriterion("discussion_url is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlEqualTo(String value) {
            addCriterion("discussion_url =", value, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlNotEqualTo(String value) {
            addCriterion("discussion_url <>", value, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlGreaterThan(String value) {
            addCriterion("discussion_url >", value, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("discussion_url >=", value, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlLessThan(String value) {
            addCriterion("discussion_url <", value, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlLessThanOrEqualTo(String value) {
            addCriterion("discussion_url <=", value, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlLike(String value) {
            addCriterion("discussion_url like", value, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlNotLike(String value) {
            addCriterion("discussion_url not like", value, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlIn(List<String> values) {
            addCriterion("discussion_url in", values, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlNotIn(List<String> values) {
            addCriterion("discussion_url not in", values, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlBetween(String value1, String value2) {
            addCriterion("discussion_url between", value1, value2, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andDiscussionUrlNotBetween(String value1, String value2) {
            addCriterion("discussion_url not between", value1, value2, "discussionUrl");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Boolean value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Boolean value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Boolean value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Boolean value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Boolean value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Boolean> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Boolean> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Boolean value1, Boolean value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}