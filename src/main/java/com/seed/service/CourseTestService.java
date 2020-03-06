package com.seed.service;

import com.seed.model.CourseTest;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 15:16
 */
public interface CourseTestService {

    /*通过课程id查询考核列表*/
    List<CourseTest> findTestByCourseId(String courseId);
}
