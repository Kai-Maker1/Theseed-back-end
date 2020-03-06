package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.CourseCommentMapper;
import com.seed.enums.PageConstant;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.CourseComment;
import com.seed.model.CourseCommentExample;
import com.seed.service.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 16:03
 */
@Service
public class CourseCommentServiceImpl implements CourseCommentService {

    @Autowired
    private CourseCommentMapper courseCommentMapper;

    @Override
    public List<CourseComment> findCommentByCourseId(String courseId, int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());

        CourseCommentExample courseCommentExample=new CourseCommentExample();
        courseCommentExample.or().andCourseIdEqualTo(courseId)
                .andRefIdIsNull()
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        courseCommentExample.setOrderByClause("create_time desc");
        List<CourseComment> courseCommentList=
                courseCommentMapper.selectByExample(courseCommentExample);
        return courseCommentList;
    }

    @Override
    public List<CourseComment> findCommentByRefId(String refId, int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());

        CourseCommentExample courseCommentExample=new CourseCommentExample();
        courseCommentExample.or().andRefIdEqualTo(refId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        courseCommentExample.setOrderByClause("create_time desc");
        List<CourseComment> courseCommentList=
                courseCommentMapper.selectByExample(courseCommentExample);
        return courseCommentList;
    }
}
