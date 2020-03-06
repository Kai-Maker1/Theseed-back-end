package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.CourseNoticeMapper;
import com.seed.enums.PageConstant;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.CourseNotice;
import com.seed.model.CourseNoticeExample;
import com.seed.service.CourseNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 15:19
 */
@Service
public class CourseNoticeServiceImpl implements CourseNoticeService {

    @Autowired
    private CourseNoticeMapper courseNoticeMapper;

    @Override
    public List<CourseNotice> findNoticeByCourseId(String courseId, int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());

        CourseNoticeExample courseNoticeExample=new CourseNoticeExample();
        courseNoticeExample.or().andCourseIdEqualTo(courseId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<CourseNotice> courseNoticeList=
                courseNoticeMapper.selectByExampleWithBLOBs(courseNoticeExample);
        return courseNoticeList;
    }
}
