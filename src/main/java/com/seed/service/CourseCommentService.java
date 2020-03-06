package com.seed.service;

import com.seed.model.CourseComment;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 15:16
 */
public interface CourseCommentService {

    /*通过课程id查询评论列表*/
    List<CourseComment> findCommentByCourseId(String courseId, int pageNum);

    /*通过引用id查询回复列表*/
    List<CourseComment> findCommentByRefId(String refId, int pageNum);

    /**/
}
