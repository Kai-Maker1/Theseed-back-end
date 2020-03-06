package com.seed.service;

import com.seed.model.College;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/6 18:52
 */
public interface CollegeService {
    /*通过collegeId查询学院信息*/
    College findCollegeByCollegeId(String collegeId);


    /*通过collegeName查询学院信息*/
    College findCollegeByCollegeName(String collegeName);
}
