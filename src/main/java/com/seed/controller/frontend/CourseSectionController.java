package com.seed.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.model.CourseSection;
import com.seed.service.CourseSectionService;
import com.seed.util.ResultVOUtil;
import com.seed.vo.CourseSectionVo;
import com.seed.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 23:09
 */
@RestController
@RequestMapping("/curriculum")
public class CourseSectionController {
    private Logger logger = LoggerFactory.getLogger(CourseSectionController.class);
    @Autowired
    private CourseSectionService courseSectionService;

    @PostMapping("/sections")
    public ResultVO<List<CourseSectionVo>> findSections(@RequestBody String request) throws Exception {
        /*System.out.println(request);*/
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        String courseId = params.getString("courseId");
        int pageNum = params.getInteger("pageNum");

        logger.info("查询章节信息！");
        logger.info("请求数据内容：{}",request);

        /*获取课程章节，课件列表*/
        List<CourseSectionVo> courseSectionVoList = new ArrayList<>();
        List<CourseSection> courseChapterList = courseSectionService.findChapterByCourseId(courseId);
        for (CourseSection c : courseChapterList) {
            CourseSectionVo courseSectionVo = new CourseSectionVo();
            courseSectionVo.setChapterName(c.getSectionName());

            List<CourseSection> courseSectionList = courseSectionService.findSectionByParentId(c.getCourseSectionId());
            List<CourseSection> sectionList = new ArrayList<>();
            for (CourseSection cs : courseSectionList) {
                CourseSection courseSection = new CourseSection();
                courseSection.setSectionName(cs.getSectionName());
                courseSection.setVideoUrl(cs.getVideoUrl());
                courseSection.setPptUrl(cs.getPptUrl());
                courseSection.setTime(cs.getTime());
                sectionList.add(courseSection);
            }
            courseSectionVo.setSectionList(sectionList);
            courseSectionVoList.add(courseSectionVo);
        }

        logger.info("返回数据成功！");
        return ResultVOUtil.success(courseSectionVoList);
    }
}
