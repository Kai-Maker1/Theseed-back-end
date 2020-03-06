package com.seed.service.impl;

import com.seed.dao.CourseStatusOneMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.CourseStatusOne;
import com.seed.model.CourseStatusOneExample;
import com.seed.service.CourseStatusOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 10:37
 */
@Service
public class CourseStatusOneServiceImpl implements CourseStatusOneService {
    @Autowired
    private CourseStatusOneMapper courseStatusOneMapper;

    @Override
    public List<CourseStatusOne> listAllCourseStatusOne() {
        CourseStatusOneExample courseStatusOneExample=new CourseStatusOneExample();
        courseStatusOneExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        return courseStatusOneMapper.selectByExample(courseStatusOneExample);

    }
}
