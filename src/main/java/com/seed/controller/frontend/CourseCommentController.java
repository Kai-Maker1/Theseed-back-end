package com.seed.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.model.CourseComment;
import com.seed.service.CourseCommentService;
import com.seed.util.PojoUtil;
import com.seed.util.ResultVOUtil;
import com.seed.vo.CourseCommentVO;
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
 * @Date: 2019/3/11 22:57
 */
@RestController
@RequestMapping("/curriculum")
public class CourseCommentController {
    private Logger logger = LoggerFactory.getLogger(CourseCommentController.class);
    @Autowired
    private CourseCommentService courseCommentService;

    @PostMapping(value = "/comments")
    public ResultVO<List<CourseCommentVO>> findComments(@RequestBody String request) throws Exception {
        logger.info("查询课程评论列表！");
        logger.info("请求数据内容：{}",request);

        System.out.println(request);
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        String courseId = params.getString("courseId");
        int pageNum = params.getInteger("pageNum");

        /*获取课程评论列表*/
        List<CourseComment> courseCommentList=courseCommentService.findCommentByCourseId(courseId,pageNum);
        List<CourseCommentVO> comments = new ArrayList<>();
        /*List<CourseCommentVO> comments =
                (List<CourseCommentVO>)PojoUtil.convertToPojoByAddAttr(courseCommentList,
                        "commentId,commentTitle,answerstatus,content,userNickname,createTime,likeNum,readNum");*/
        for(CourseComment cc:courseCommentList){

            List<CourseComment> commentList=courseCommentService.findCommentByRefId(cc.getCommentId(),pageNum);
            commentList=(List<CourseComment>) PojoUtil.convertToPojoByAddAttr(commentList,
                    "commentId,commentTitle,content,userNickname,createTime,likeNum,readNum");
            CourseCommentVO ccv=new CourseCommentVO();
            ccv.setAnswers(commentList);
            CourseComment c=(CourseComment) PojoUtil.convertToPojoByAddAttr(cc,
                    "commentId,commentTitle,answerstatus,content,userNickname,createTime,likeNum,readNum");
            ccv.setCourseComment(c);
            comments.add(ccv);

        }

        logger.info("返回数据成功！");
        return ResultVOUtil.success(comments);
    }
}