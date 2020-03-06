package com.seed.service;

import com.seed.model.CourseEvaluation;
import com.seed.model.Curriculum;

import java.util.List;

/**
 * 查询全部全部/未开始/进行中/已结束课程
 *
 * 查询指定父级别下的全部/未开始/进行中/结束课程
 * 查询指定父级别下综合/热门/最新的全部/未开始/进行中/已结束课程
 * 查询指定父级别及子级别下的全部/未开始/进行中/已结束课程
 * 查询指定父级别及子级别下综合/热门/最新的全部/未开始/进行中/已结束课程
 *
 * 全部or父级名称----全部or子级名称---综合（默认）/热门/最新----全部/未开始/进行中/已结束
 */
public interface CurriculumService {
    /*查询全部课程*/
    List<Curriculum> listAllCurriculum(int pageNum);

    /**
     * 全部---全部---综合（默认）/热门/最新---全部/未开始/进行中/已结束
     * 全部or父级名称----全部or子级名称---综合（默认）/热门/最新----全部/未开始/进行中/已结束
     *  parentName 全部or父级名称
     *  childName 全部or子级名称
     *  statusOne 综合（默认）/热门/最新
     *  statusTwo 全部/未开始/进行中/已结束
     *  pageNum
     *  pageSize
     * @return
     */
    /*查询指定范围下的课程*/
    List<Curriculum> listCurriculum(Integer parentId, Integer childId, String statusOne, String statusTwo, int pageNum);

    /*查询指定courseId的课程详情*/
    Curriculum findByCourseId(String courseId);

    /*查询指定courseId的全部用户评论*/
    List<CourseEvaluation> findEvaluationByCourseId(String courseId);




}
