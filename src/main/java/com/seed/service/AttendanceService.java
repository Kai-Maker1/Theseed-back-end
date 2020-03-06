package com.seed.service;

import com.seed.model.Attendance;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/12 0:14
 */
public interface AttendanceService {
    /*查询指定openId的打卡记录*/
    List<Attendance> listAttendance(String openId, int pageNum);

    /*创建一条打卡记录*/
    int createOne(Attendance attendance);

    /*通过openId查询指定coourseId的最近一条打卡记录*/
    Attendance findLastAttendance(String openId, String courseId);


}
