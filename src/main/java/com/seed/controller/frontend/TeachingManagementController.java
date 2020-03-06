package com.seed.controller.frontend;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.enums.ResultEnum;
import com.seed.model.Attendance;
import com.seed.model.Information;
import com.seed.model.Schedule;
import com.seed.service.AttendanceService;
import com.seed.service.InformationService;
import com.seed.service.ScheduleService;
import com.seed.util.DateUtil;
import com.seed.util.KeyUtil;
import com.seed.util.PojoUtil;
import com.seed.util.ResultVOUtil;
import com.seed.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/12 0:35
 */

@RestController
@RequestMapping(value ="/tm")
public class TeachingManagementController {
    private Logger logger = LoggerFactory.getLogger(TeachingManagementController.class);
    @Autowired
    private InformationService informationService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/lastInfo")
    public ResultVO<List<Information>> findInfomation(@RequestBody String request) throws Exception {

        logger.info("查询最新通知！");
        logger.info("请求数据内容："+request);
        /*System.out.println(request);*/
        JSONObject params = JSON.parseObject(request);
        int pageNum = params.getInteger("pageNum");
        List<Information> informationList=
                informationService.listInfomation(pageNum);
        List<Information> informations=
                (List<Information>) PojoUtil.convertToPojoByAddAttr(informationList,
                        "infoId,infoTitle,infoBrief,pictureUrl,createTime,content");
        logger.info("返回数据成功！");
        return ResultVOUtil.success(informations);
    }

    @PostMapping("/listAttend")
    public ResultVO<List<Attendance>> findAttendance(@RequestBody String request) throws Exception {
        System.out.println(request);
        JSONObject params=JSON.parseObject(request);
        String openId=params.getString("openId");
        int pageNum=params.getInteger("pageNum");

        List<Attendance> attendanceList=attendanceService.listAttendance(openId,pageNum);
        List<Attendance> attendances=
                (List<Attendance>) PojoUtil.convertToPojoByAddAttr(attendanceList,
                        "attendId,place,createTime");

        return ResultVOUtil.success(attendances);
    }
    @PostMapping("/whetherAttend")
    public ResultVO<Boolean> whetherAttendance(@RequestBody String request){
        System.out.println(request);
        JSONObject params=JSON.parseObject(request);
        String openId=params.getString("openId");
        String courseId=params.getString("courseId");

        Attendance attendance=attendanceService.findLastAttendance(openId,courseId);
        if(attendance == null){
            return ResultVOUtil.success(false);
        }
        System.out.println(attendance.getCreateTime());
        Boolean istoday= DateUtil.isToday(attendance.getCreateTime());

        return ResultVOUtil.success(istoday);

    }
    @PostMapping("/createAttend")
    public ResultVO<String> createAttendance(@RequestBody String request) throws ParseException {
        System.out.println(request);
        JSONObject params=JSON.parseObject(request);
        String openId=params.getString("openId");
        String time=params.getString("createTime");
        String place=params.getString("place");
        String courseId=params.getString("courseId");

        Attendance attendance=new Attendance();
        attendance.setAttendId(KeyUtil.getUniqueKey("att"));
        attendance.setOpenId(openId);
        attendance.setPlace(place);
        Date createTime= DateUtil.getTextDate(time,"yyyy-MM-dd HH:mm:ss");
        attendance.setCreateTime(createTime);
        attendance.setCourseId(courseId);
        int result=attendanceService.createOne(attendance);

        return ResultVOUtil.success("打卡成功！");

    }
    @PostMapping("/schedule")
    public ResultVO findSchedules(@RequestBody String request) throws Exception {

        //System.out.println(request);
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        String term = params.getString("term");
        String week = params.getString("week");

        logger.info("查询用户openId={}的课表！",openId);
        logger.info("请求数据内容：{}",request);

        List<Schedule> scheduleList=scheduleService.listSchedules(openId,term,week);
        if(CollectionUtils.isEmpty(scheduleList)){
            return ResultVOUtil.error(ResultEnum.NO_LESSON);
        }
        List<Schedule> schedules =
                (List<Schedule>) PojoUtil.convertToPojoByAddAttr(scheduleList,
                        "scheduleId,number,lessonName,teacherName,time,place");

        logger.info("返回数据成功！");
        return ResultVOUtil.success(schedules);
    }

}
