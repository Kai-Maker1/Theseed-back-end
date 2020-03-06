package com.seed.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.dto.UserCourseStatusDTO;
import com.seed.enums.PageConstant;
import com.seed.model.*;
import com.seed.service.*;
import com.seed.util.PojoUtil;
import com.seed.util.ResultVOUtil;
import com.seed.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

    private static Logger logger =  LoggerFactory.getLogger(CurriculumController.class);

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserCourseStatusService userCourseStatusService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseEvaluationService courseEvaluationService;

    @Autowired
    private CourseSectionService courseSectionService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private CourseNoticeService courseNoticeService;

    @Autowired
    private CourseTestService courseTestService;

    @Autowired
    private CourseCommentService courseCommentService;

    @GetMapping(value = "/findAll")
    public List<Curriculum> findAllCurriculum(){
        logger.info("查询全部课程！");
        // 假如前端传来的参数
        int pageNum = PageConstant.PAGE_NUM.getValue(); // 第几页
        int pageSize = PageConstant.PAGE_SIZE.getValue(); // 每页记录数
        List<Curriculum> curriculums = curriculumService.listAllCurriculum(pageNum);
        System.out.println(curriculums);
        return curriculums;
    }

    @PostMapping(value = "/findSome")
    public ResultVO<List<CourseVo>> findCurriculum(@RequestBody String request) throws Exception {
        /*@RequestParam(value = "openId",required = false,defaultValue = "openid") String openId,
        @RequestParam(value = "parentId",required = false,defaultValue = "1") Integer parentId,
        @RequestParam(value = "childId",required = false,defaultValue = "0") Integer childId,
        @RequestParam(value = "statusOne",required = false,defaultValue = "") String statusOne,
        @RequestParam(value = "statusTwo",required = false,defaultValue = "") String statusTwo,
        @RequestParam(value = "pageNum",required = false,defaultValue = "0") int pageNum,
        @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize*/
       System.out.println(request);
        ResultVO<List<CourseVo>> result=null;
        /*通过openId查询stuId*/
        JSONObject params= JSON.parseObject(request);
        Integer parentId=params.getInteger("parentId");
        Integer childId=params.getInteger("childId");
        String statusOne=params.getString("statusOne");
        String statusTwo=params.getString("statusTwo");
        Integer pageNum=params.getInteger("pageNum");
        Integer pageSize=params.getInteger("pageSize");

        /*查询指定类型课程*/
        logger.info("查询指定类型课程！");
        logger.info("请求数据内容：{}",request);
        System.out.println(parentId+","+childId+","+statusOne+","+statusTwo);
        List<Curriculum> curriculums = curriculumService.listCurriculum(parentId,childId,statusOne,statusTwo,pageNum);

        /*通过openId查询stuId时，若openId不存在*/
        String stuId=new String();
        List<UserCourseStatusDTO> userCourseStatusDTOList = new ArrayList<>();
        try {
                stuId = studentService.findStuIdByOpenId(params.getString("openId"));
            /*通过stuId查询用户所有参与的课程及参与状态*/
            /*若学生未参加任何课程，抛出异常*/
            List<UserCourseStatus> userCourseStatusList = userCourseStatusService.findByStuId(stuId);

            for (UserCourseStatus userCourseStatus : userCourseStatusList) {
                UserCourseStatusDTO dto = new UserCourseStatusDTO();
                dto.setCourseId(userCourseStatus.getCourseId());
                dto.setStatus(userCourseStatus.getStatus());
                userCourseStatusDTOList.add(dto);
            }
        }catch(Exception e){

            /*数据拼接*/
            //TODO 用时太长，需要优化
            List<CourseVo> courseVoListOne=new ArrayList<>();
            for(Curriculum c:curriculums){
                CourseVo courseVo=new CourseVo();//注意！！

                    /*通过老师id查询所在学院*/
                    String tchId=c.getTeacherId();
                    String collegeId=teacherService.findCollegeByTeacherId(tchId);
                    courseVo.setTeacherCollegeId(collegeId);
                    Object curriculum=
                            //TODO
                            PojoUtil.convertToPojoByAddAttr(c,
                                    "courseId,courseName,studyCount,teacherId,teacherName,brief,picture,classifyId,classifyName,begintime,endtime");
                    CurriculumVo curriculumVo=new CurriculumVo();
                    BeanUtils.copyProperties(curriculum,curriculumVo);
                    courseVo.setCurriculumVo(curriculumVo);
                courseVoListOne.add(courseVo);//注意！！
            }
            result= ResultVOUtil.success(courseVoListOne);
            logger.info("成功返回数据！");

        }

        /*数据拼接*/
        //TODO 用时太长，需要优化
        List<CourseVo> courseVoList=new ArrayList<>();
        for(Curriculum c:curriculums){
            CourseVo courseVo=new CourseVo();//注意！！
            for(UserCourseStatusDTO u:userCourseStatusDTOList){

                /*通过老师id查询所在学院*/
                String tchId=c.getTeacherId();
                String collegeId=teacherService.findCollegeByTeacherId(tchId);

                /*if(u.getCourseId()==c.getCourseId()){*/
                if(StringUtils.pathEquals(u.getCourseId(),c.getCourseId())){
                    courseVo.setUserJoinStatus(u.getStatus());
                }
                courseVo.setTeacherCollegeId(collegeId);
                Object curriculum=
                        //TODO
                         PojoUtil.convertToPojoByAddAttr(c,
                                "courseId,courseName,studyCount,teacherId,teacherName,brief,picture,classifyId,classifyName");
                CurriculumVo curriculumVo=new CurriculumVo();
                BeanUtils.copyProperties(curriculum,curriculumVo);
                courseVo.setCurriculumVo(curriculumVo);

            }
            courseVoList.add(courseVo);//注意！！
        }
        if(result==null)
            result= ResultVOUtil.success(courseVoList);
        logger.info("成功返回数据！");
        return result;

    }

    @PostMapping(value="/detail")
    public ResultVO<CurriculumDetailVO> findCurriculumDetail(@RequestBody  String request) throws Exception {

        logger.info("查询课程详情！");
        logger.info("请求数据内容：{}",request);
        JSONObject params=JSON.parseObject(request);
        String courseId=params.getString("courseId");
        /*获取课程的总评论数*/
        Integer evaluationNum=courseEvaluationService.countCommentByCourseId(courseId);

        /*获取课程详细信息*/
        //TODO 强制类型转换抛出ClassCastException! 待优化！！
        Object object=
                PojoUtil.convertToPojoByAddAttr(curriculumService.findByCourseId(courseId),
                "courseId,courseName,classifyId,classifyName,subClassifyId,subClassifyName,teacherId,begintime,endtime,icon,picture,studyCount,brief");
        CurriculumVo curriculumVo=new CurriculumVo();
        BeanUtils.copyProperties(object,curriculumVo);
        /*获取教师详细信息*/
        String teacherId=curriculumVo.getTeacherId();
        Object obj=
                PojoUtil.convertToPojoByAddAttr(teacherService.findTeacherByTeacherId(teacherId),
                        "teacherId,teacherName,nickname,gender,header");
        Teacher teacher=new Teacher();
        BeanUtils.copyProperties(obj,teacher);

        /*获取教师所在学院名称*/
        String collegeId=teacherService.findCollegeByTeacherId(curriculumVo.getTeacherId());
        String collegeName=collegeService.findCollegeByCollegeId(collegeId).getCollegeName();
        /*获取课程评价列表*/
        List<CourseEvaluation> courseEvaluationList=
                (List<CourseEvaluation>) PojoUtil.convertToPojoByAddAttr(courseEvaluationService.findEvaluationByCourseId(courseId),
                "courseEvaluationId,userNickname,score,content,createTime");
        Double sum=0.0;
        /*计算评论分数平均值*/
        for(CourseEvaluation e:courseEvaluationList){
            sum+=e.getScore();
        }
        Double evaluationScoreAvg = sum/evaluationNum;
        /*获取章节信息*/
        List<CourseSectionVo> courseSectionVoList=new ArrayList<>();
        List<CourseSection> courseChapterList=courseSectionService.findChapterByCourseId(courseId);
        for(CourseSection c:courseChapterList){
           CourseSectionVo courseSectionVo=new CourseSectionVo();
           courseSectionVo.setChapterName(c.getSectionName());

           List<CourseSection> courseSectionList=courseSectionService.findSectionByParentId(c.getCourseSectionId());
            List<CourseSection> sectionList = new ArrayList<>();
           for(CourseSection cs:courseSectionList) {
               CourseSection courseSection=new CourseSection();
               courseSection.setSectionName(cs.getSectionName());
               sectionList.add(courseSection);
           }
           courseSectionVo.setSectionList(sectionList);
           courseSectionVoList.add(courseSectionVo);
        }

        /*数据拼装*/
        CurriculumDetailVO curriculumDetailVO=new CurriculumDetailVO();
        curriculumDetailVO.setUrl("https://school-1258358792.cos.ap-beijing.myqcloud.com/introduce.mp4");
        curriculumDetailVO.setEvaluationCount(evaluationNum);
        curriculumDetailVO.setEvaluationScoreAvg(evaluationScoreAvg);
        curriculumDetailVO.setCourseInfo(curriculumVo);
        curriculumDetailVO.setTeacherInfo(teacher);
        curriculumDetailVO.setCollegeName(collegeName);
        curriculumDetailVO.setCourseSection(courseSectionVoList);
        curriculumDetailVO.setEvaluation(courseEvaluationList);

        logger.info("成功返回数据！");
        return ResultVOUtil.success(curriculumDetailVO);
    }

    @PostMapping(value = "/join/detail")
    public ResultVO<CurriculumDetailVO> findCurriculumJoinDetail(@RequestBody String request) throws Exception {
        logger.info("用户参加课程，查询课程详情！");
        logger.info("请求数据内容：{}",request);
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        String courseId = params.getString("courseId");
        int pageNum = params.getInteger("pageNum");

        /*获取课程公告列表*/
        List<CourseNotice> courseNoticeList= courseNoticeService.findNoticeByCourseId(courseId,pageNum);
        courseNoticeList=
                //TODO
                    (List<CourseNotice>) PojoUtil.convertToPojoByAddAttr(courseNoticeList,
                            "noticeId,noticeTitle,createTime,content,teacherId,teacherName");

        /*获取课程章节，课件列表*/
        List<CourseSectionVo> courseSectionVoList=new ArrayList<>();
        List<CourseSection> courseChapterList=courseSectionService.findChapterByCourseId(courseId);
        for(CourseSection c:courseChapterList){
            CourseSectionVo courseSectionVo=new CourseSectionVo();
            courseSectionVo.setChapterName(c.getSectionName());

            List<CourseSection> courseSectionList=courseSectionService.findSectionByParentId(c.getCourseSectionId());
            List<CourseSection> sectionList = new ArrayList<>();
            for(CourseSection cs:courseSectionList) {
                CourseSection courseSection=new CourseSection();
                courseSection.setSectionName(cs.getSectionName());
                courseSection.setVideoUrl(cs.getVideoUrl());
                courseSection.setPptUrl(cs.getPptUrl());
                courseSection.setTime(cs.getTime());
                sectionList.add(courseSection);
            }
            courseSectionVo.setSectionList(sectionList);
            courseSectionVoList.add(courseSectionVo);
        }

        /*获取课程考核列表*/
        List<CourseTest> courseTestList=courseTestService.findTestByCourseId(courseId);
        courseTestList=
                //TODO
                (List<CourseTest>) PojoUtil.convertToPojoByAddAttr(courseTestList,
                        "testId,testTitle,endtime,totalPoints,score,stuId,status");

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


        /*数据拼装*/
        CurriculumDetailVO curriculumDetailVO=new CurriculumDetailVO();
        curriculumDetailVO.setCourseSection(courseSectionVoList);
        curriculumDetailVO.setNotices(courseNoticeList);
        curriculumDetailVO.setTests(courseTestList);
        curriculumDetailVO.setComments(comments);

        logger.info("成功返回数据！");
        return ResultVOUtil.success(curriculumDetailVO);
    }
}
