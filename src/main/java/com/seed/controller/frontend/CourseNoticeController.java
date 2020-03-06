package com.seed.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.model.CourseNotice;
import com.seed.service.CourseNoticeService;
import com.seed.util.PojoUtil;
import com.seed.util.ResultVOUtil;
import com.seed.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 22:53
 */
@RestController
@RequestMapping("/curriculum")
public class CourseNoticeController {
    private Logger logger = LoggerFactory.getLogger(CourseNoticeController.class);

    @Autowired
    private CourseNoticeService courseNoticeService;

    @PostMapping(value = "/notices")
    public ResultVO<List<CourseNotice>> findNotices(@RequestBody String request) throws Exception {
        logger.info("查询课程通知列表！");
        logger.info("请求数据内容：{}",request);

        System.out.println(request);
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        String courseId = params.getString("courseId");
        int pageNum = params.getInteger("pageNum");

        /*获取课程公告列表*/
        List<CourseNotice> courseNoticeList = courseNoticeService.findNoticeByCourseId(courseId, pageNum);
        courseNoticeList =
                //TODO
                (List<CourseNotice>) PojoUtil.convertToPojoByAddAttr(courseNoticeList,
                        "noticeId,noticeTitle,createTime,content,teacherId,teacherName");

        logger.info("返回数据成功！");
        return ResultVOUtil.success(courseNoticeList);
    }
}
