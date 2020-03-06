package com.seed.service.impl;

import com.seed.dao.CourseTestMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.CourseTest;
import com.seed.model.CourseTestExample;
import com.seed.service.CourseTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 15:50
 */
@Service
public class CourseTestServiceImpl implements CourseTestService {
    @Autowired
    private CourseTestMapper courseTestMapper;

    @Override
    public List<CourseTest> findTestByCourseId(String courseId) {
        CourseTestExample courseTestExample=new CourseTestExample();
        courseTestExample.or().andCourseIdEqualTo(courseId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<CourseTest> courseTestList=
                courseTestMapper.selectByExample(courseTestExample);
        return courseTestList;
    }
}
