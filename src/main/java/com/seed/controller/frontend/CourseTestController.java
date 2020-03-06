package com.seed.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.model.CourseTest;
import com.seed.service.CourseTestService;
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
 * @Date: 2019/3/11 23:01
 */
@RestController
@RequestMapping("/curriculum")
public class CourseTestController {

    @Autowired
    private CourseTestService courseTestService;

    private Logger logger = LoggerFactory.getLogger(CourseTestController.class);
    @PostMapping(value = "/tests")
    public ResultVO<List<CourseTest> > findTests(@RequestBody String request) throws Exception {
        System.out.println(request);
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        String courseId = params.getString("courseId");
        int pageNum = params.getInteger("pageNum");
        logger.info("查询课程考核列表！");
        logger.info("请求数据内容：{}",request);

        /*获取课程考核列表*/
        List<CourseTest> courseTestList=courseTestService.findTestByCourseId(courseId);
        courseTestList=
                //TODO
                (List<CourseTest>) PojoUtil.convertToPojoByAddAttr(courseTestList,
                        "testId,testTitle,endtime,totalPoints,score,stuId,status");


        logger.info("返回数据成功！");
        return ResultVOUtil.success(courseTestList);
    }
}
