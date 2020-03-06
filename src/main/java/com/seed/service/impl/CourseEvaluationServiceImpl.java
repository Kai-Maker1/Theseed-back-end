package com.seed.service.impl;

import com.seed.dao.CourseEvaluationMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.CourseEvaluation;
import com.seed.model.CourseEvaluationExample;
import com.seed.service.CourseEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/6 8:14
 */
@Service
public class CourseEvaluationServiceImpl implements CourseEvaluationService {

    @Autowired
    private CourseEvaluationMapper courseEvaluationMapper;
    @Override
    public Integer countCommentByCourseId(String courseId) {
        CourseEvaluationExample courseEvaluationExample=new CourseEvaluationExample();
        courseEvaluationExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue())
                                    .andCourseIdEqualTo(courseId);
        Integer result=courseEvaluationMapper.countByExample(courseEvaluationExample);
        return result;
    }

    @Override
    public List<CourseEvaluation> findEvaluationByCourseId(String courseId) {
        CourseEvaluationExample courseEvaluationExample=new CourseEvaluationExample();
        courseEvaluationExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue())
                                    .andCourseIdEqualTo(courseId);
        List<CourseEvaluation> courseEvaluationList=
                courseEvaluationMapper.selectByExample(courseEvaluationExample);
        return courseEvaluationList;
    }

}
