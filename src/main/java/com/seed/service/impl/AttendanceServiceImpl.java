package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.AttendanceMapper;
import com.seed.enums.PageConstant;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.Attendance;
import com.seed.model.AttendanceExample;
import com.seed.service.AttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/12 0:15
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    private static Logger logger= LoggerFactory.getLogger(AttendanceServiceImpl.class);
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public List<Attendance> listAttendance(String openId, int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());

        AttendanceExample attendanceExample=new AttendanceExample();
        attendanceExample.or().andOpenIdEqualTo(openId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        attendanceExample.setOrderByClause("create_time desc");
        List<Attendance> attendanceList=
                attendanceMapper.selectByExample(attendanceExample);
        return attendanceList;
    }

    @Override
    @Transactional
    public int createOne(Attendance attendance) {
        AttendanceExample attendanceExample=new AttendanceExample();
       int result=attendanceMapper.insertSelective(attendance);

        return result;
    }

    @Override
    public Attendance findLastAttendance(String openId, String courseId) {
        AttendanceExample attendanceExample=new AttendanceExample();
        attendanceExample.or().andOpenIdEqualTo(openId)
                .andCourseIdEqualTo(courseId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        attendanceExample.setOrderByClause("create_time desc");
        List<Attendance> attendanceList=
                attendanceMapper.selectByExample(attendanceExample);
        try{
            Attendance attendance=attendanceList.get(0);
            return attendance;
        }catch (Exception e){
            logger.info("【查询最近一次打卡记录】没有打卡记录，openId={}，courseId={}",openId,courseId);
            return null;
        }
    }
}
