package com.seed.service;

import com.seed.model.CourseEvaluation;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 10:32
 */
public interface CourseEvaluationService {

    /*查询指定课程的总评论数*/
    Integer countCommentByCourseId(String courseId);

    /*查询指定课程的评论详细信息列表*/
    List<CourseEvaluation> findEvaluationByCourseId(String courseId);
}
