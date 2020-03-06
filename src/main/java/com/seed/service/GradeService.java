package com.seed.service;

import com.seed.model.Grade;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/14 17:34
 */
public interface GradeService {
    Grade findGradeByGradeName(String gradeName);
    Grade findGradeByGradeId(String gradeId);
}
