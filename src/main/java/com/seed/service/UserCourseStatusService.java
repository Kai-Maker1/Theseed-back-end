package com.seed.service;


import com.seed.model.UserCourseStatus;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 10:32
 */

public interface UserCourseStatusService {
    /*通过stuId查询用户所有对应课程*/
    List<UserCourseStatus> findByStuId(String stuId,int pageNum);

    List<UserCourseStatus> findByStuId(String stuId);

}
