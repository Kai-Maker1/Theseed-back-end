package com.seed.service.impl;

import com.seed.dao.GradeMapper;
import com.seed.model.Grade;
import com.seed.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/14 17:37
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public Grade findGradeByGradeName(String gradeName) {
        Grade grade = gradeMapper.selectByGradeName(gradeName);
        return grade;
    }

    @Override
    public Grade findGradeByGradeId(String gradeId) {
        Grade grade = gradeMapper.selectByGradeId(gradeId);
        return grade;
    }
}
