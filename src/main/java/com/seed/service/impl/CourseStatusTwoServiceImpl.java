package com.seed.service.impl;

import com.seed.dao.CourseStatusTwoMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.CourseStatusTwo;
import com.seed.model.CourseStatusTwoExample;
import com.seed.service.CourseStatusTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 21:38
 */
@Service
public class CourseStatusTwoServiceImpl implements CourseStatusTwoService {

    @Autowired
    private CourseStatusTwoMapper courseStatusTwoMapper;
    @Override
    public List<CourseStatusTwo> listAllCourseStatusTwo() {
        CourseStatusTwoExample courseStatusTwoExample=new CourseStatusTwoExample();
        courseStatusTwoExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<CourseStatusTwo> courseStatusTwoList=
                courseStatusTwoMapper.selectByExample(courseStatusTwoExample);
        return courseStatusTwoList;
    }
}
