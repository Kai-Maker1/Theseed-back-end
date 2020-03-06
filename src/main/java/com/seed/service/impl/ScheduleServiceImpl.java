package com.seed.service.impl;

import com.seed.dao.ScheduleMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.Schedule;
import com.seed.model.ScheduleExample;
import com.seed.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/14 15:24
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public List<Schedule> listSchedules(String openId, String term, String week) {
        ScheduleExample scheduleExample=new ScheduleExample();
        scheduleExample.or().andOpenIdEqualTo(openId)
                .andTermEqualTo(term).andWeekEqualTo(week)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        scheduleExample.setOrderByClause("number asc");
        List<Schedule> scheduleList=
                scheduleMapper.selectByExample(scheduleExample);
        return scheduleList;
    }
}
