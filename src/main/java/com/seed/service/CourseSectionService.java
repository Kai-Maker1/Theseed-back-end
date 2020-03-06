package com.seed.service;

import com.seed.model.CourseSection;
import com.seed.model.UserCourseSection;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/6 16:41
 */
public interface CourseSectionService {
    /*计算课程总章节数*/
    int count(String courseId);

    /*查询指定课程 章信息*/
    List<CourseSection> findChapterByCourseId(String courseId);

    /*查询指定课程 节信息*/
    List<CourseSection> findSectionByParentId(Integer parentId);

    /*计算今日学习结束章节列表*/
    List<UserCourseSection> listStudyTimeToday(String stuId);


    /*courseScetionId查询指定节*/
    CourseSection findByCourseScetionId(Integer courseScetionId);

    /*courseId查询用户已学习的指定节*/
    List<UserCourseSection> findByCourseId(String courseId);

}
