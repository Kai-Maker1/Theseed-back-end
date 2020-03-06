package com.seed.vo;

import com.seed.model.CourseEvaluation;
import com.seed.model.CourseNotice;
import com.seed.model.CourseTest;
import com.seed.model.Teacher;
import lombok.Data;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/6 9:58
 */
@Data
public class CurriculumDetailVO {
    /*课程介绍视频*/
    private String url;

    /*指定课程总评价条数*/
    private Integer evaluationCount;

    /*指定课程评价平均分数*/
    private Double evaluationScoreAvg;

    /*课程详细信息*/
    private CurriculumVo courseInfo;

    /*教师详细信息*/
    private Teacher teacherInfo;

    /*教师所在学院*/
    private String collegeName;

    /*课程章节信息*/
    private List<CourseSectionVo> courseSection;

    /*用户评价列表*/
    private List<CourseEvaluation> evaluation;

    /*=================================================*/
    /*课程公告列表*/
    private List<CourseNotice> notices;

    /*课程考核列表*/
    private List<CourseTest> tests;

    /*课程讨论列表*/
    private List<CourseCommentVO> comments;

}
