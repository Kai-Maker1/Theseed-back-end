package com.seed.service;

import com.seed.model.Schedule;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/14 15:22
 */
public interface ScheduleService {
    /*课表查询*/
    List<Schedule> listSchedules(String openId, String term, String week);
}
