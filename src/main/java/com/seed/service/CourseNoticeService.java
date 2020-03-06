package com.seed.service;

import com.seed.model.CourseNotice;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 15:17
 */
public interface CourseNoticeService {
    /*通过课程id查询公告列表*/
    List<CourseNotice> findNoticeByCourseId(String courseId, int pageNum);
}
