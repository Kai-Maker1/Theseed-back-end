package com.seed.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.enums.ResultEnum;
import com.seed.exception.SchoolException;
import com.seed.model.*;
import com.seed.service.*;
import com.seed.util.DateUtil;
import com.seed.util.PojoUtil;
import com.seed.util.ResultVOUtil;
import com.seed.vo.CommendVo;
import com.seed.vo.CurriculumVo;
import com.seed.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/2 9:25
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    private static Logger logger =  LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private CourseSectionService courseSectionService;

    @Autowired
    private UserCourseStatusService userCourseStatusService;

    @Autowired
    private UserCollectionService userCollectionService;

    @PostMapping("/index/commend")
    public ResultVO<CommendVo> commendCourse(@RequestBody String request) throws Exception {
        /*@RequestParam(value = "openId",defaultValue = "openid") String openId*/

       /* System.out.println(request);*/
        JSONObject params= JSON.parseObject(request);
        String openId=params.getString("openId");

        logger.info("查询用户openId={}的推荐课程列表！",openId);
        logger.info("请求数据内容：{}",request);

        /*通过openId查询stuId*/
        String stuId=studentService.findStuIdByOpenId(openId);

        /*查询用户推荐课程Id*/
        List<UserCourseCommend> courseCommendList=studentService.findCommend(stuId);

        /*查询推荐课程的详细信息*/
        if(CollectionUtils.isEmpty(courseCommendList)){
            logger.info("【推荐课程】该用户当前推荐列表为空，stuId={}",stuId);
            return ResultVOUtil.error(ResultEnum.COMMENDLIST_IS_NULL.getCode(), ResultEnum.COMMENDLIST_IS_NULL.getMessage());

        }else {
            List<Curriculum> curriculumList=new ArrayList<>();
            for (UserCourseCommend userCourseCommend : courseCommendList) {
                Curriculum curriculum=new Curriculum();
                curriculum=curriculumService.findByCourseId(userCourseCommend.getCourseId());
                curriculumList.add(curriculum);
            }

            List<CurriculumVo> curriculumVoList=
                    //TODO
                    /*异常的处理方式有待优化：直接抛出还是try-catch?*/
                    (List<CurriculumVo>) PojoUtil.convertToPojoByAddAttr(curriculumList,
                            "courseId,courseName,studyCount,teacherId,teacherName,brief,picture,classifyId,classifyName,begintime");

            CommendVo commendVo=new CommendVo();
            commendVo.setCurriculumVoList(curriculumVoList);

            logger.info("返回数据成功！");
            return ResultVOUtil.success(commendVo);
        }
    }

    @PostMapping("/whetherIdentity")
    public ResultVO whetherIdentityAuthentication(@RequestBody String request){

        /*System.out.println(request);*/
        JSONObject params= JSON.parseObject(request);
        String openId=params.getString("openId");
        Student student = studentService.findStudentByOpenId(openId);
        logger.info("判断用户是否已认证身份！openId={}",openId);
        logger.info("请求数据内容：{}",request);

        Map<String , Object> map = new HashMap<>();
         if(student.getStatus() == true){

             String collegeName =
                     collegeService.findCollegeByCollegeId(student.getCollegeId()).getCollegeName();
             String majorName =
                     majorService.findMajorByMajorId(student.getMajorId()).getMajorName();
             String gradeName =
                     gradeService.findGradeByGradeId(student.getClassId()).getGradeName();

             map.put("gradeName",gradeName);
             map.put("majorName",majorName);
             map.put("collegeName",collegeName);
             map.put("gender",student.getGender());
             map.put("name",student.getStuName());
             map.put("stuId",student.getStuId());



        }

        logger.info("返回数据成功！");
        return  ResultVOUtil.success(map);
    }

    @PostMapping("/identity")
    /*@Transactional*/
    public ResultVO identityAuthentication(@RequestBody String request) {
       /* System.out.println(request);*/
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        String stuName = params.getString("name");
        Boolean gender = params.getBoolean("gender");
        String collegeName = params.getString("collegeName");
        String majorName = params.getString("majorName");
        String gradeName = params.getString("gradeName");

        logger.info("用户身份认证！openId={}",openId);
        logger.info("请求数据内容：{}",request);

        /*通过collegeName查询学院id*/
        College college = collegeService.findCollegeByCollegeName(collegeName);
        if (ObjectUtils.isEmpty(college)) {
            logger.info("返回数据失败！{}",ResultEnum.COLLEGE_NOT_EXIST.getMessage());
            return ResultVOUtil.error(ResultEnum.COLLEGE_NOT_EXIST);
        }

        /*通过专业名称查询专业id*/

        Major major = majorService.findMajorByMajorName(majorName);
        if (ObjectUtils.isEmpty(major)) {
            logger.info("返回数据失败！{}",ResultEnum.MAJOR_NOT_EXIST.getMessage());
            return ResultVOUtil.error(ResultEnum.MAJOR_NOT_EXIST);
        }
            /*通过年级名称查询年级id*/
            Grade grade = gradeService.findGradeByGradeName(gradeName);
            if (ObjectUtils.isEmpty(grade)) {

                logger.info("返回数据失败！{}",ResultEnum.GRADE_NOT_EXIST.getMessage());
                return ResultVOUtil.error(ResultEnum.GRADE_NOT_EXIST);
            }

            String collegeId = college.getCollegeId();
            String majorId = major.getMajorId();
            String gradeId = grade.getGradeId();

            Student student = new Student();
            student.setStuName(stuName);
            student.setGender(gender);
            student.setCollegeId(collegeId);
            student.setMajorId(majorId);
            student.setClassId(gradeId);
            /*更新学生信息*/
            int result = studentService.updateOne(student, openId);

            if (result == 1) {
                /*如果更新信息成功，将状态修改为 已认证*/
                studentService.findStudentByOpenId(openId).setStatus(true);
            }
            /*通过openId查询stuId*/
            String stuId = studentService.findStuIdByOpenId(openId);
            Map<String, String> map = new HashMap<>();
            map.put("stuId", stuId);

        logger.info("返回数据成功！");
            return ResultVOUtil.success(map);
        }

    @PostMapping("/studyResult")
    public ResultVO countStudyResult(@RequestBody String request) throws ParseException {
        /*System.out.println(request);*/
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");

        logger.info("查询用户学习时长！openId={}",openId);
        logger.info("请求数据内容：{}",request);

        String stuId = new String();
        try {
            stuId = studentService.findStuIdByOpenId(openId);
        } catch (SchoolException e) {
            logger.info("返回数据失败！{}",e.getMessage());
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        //通过课程章节的状态计算今日学习时间
        List<UserCourseSection> userCourseSectionList = courseSectionService.listStudyTimeToday(stuId);
        double timeSum = 0.0;
        try {
            for (UserCourseSection ucs : userCourseSectionList) {
                CourseSection cs = courseSectionService.findByCourseScetionId(Integer.parseInt(ucs.getSectionId()));
                timeSum += DateUtil.countMinutes(cs.getTime());
                System.out.println(DateUtil.countMinutes(cs.getTime()));
           }
         }catch (SchoolException | ParseException e){
            logger.info("返回数据失败！{}",e.getMessage());
            return ResultVOUtil.error(e.hashCode(),e.getMessage());
        }
        Map<String , Object> map = new HashMap<>();
        map.put("studyTimeOnTody",timeSum);
        map.put("scoreOnToday",56);
        map.put("rankOnToday",23);

        logger.info("返回数据成功！");
        return ResultVOUtil.success(map);
    }

    @PostMapping("/myCourses")
    public ResultVO listMyCourse(@RequestBody String request) throws Exception {
        /*System.out.println(request);*/
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        Integer pageNum = params.getInteger("pageNum");

        logger.info("查询我的课程！openId={}",openId);
        logger.info("请求数据内容：{}",request);

        //通过openId查询stuId
        String stuId = new String();
        try {
            stuId = studentService.findStuIdByOpenId(openId);
        } catch (SchoolException e) {
            logger.info("返回数据失败！{}",e.getMessage());
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        //
        List<UserCourseStatus> userCourseStatuseList = userCourseStatusService.findByStuId(stuId,pageNum);
        List<Curriculum> curriculumList = new ArrayList<>();
        for(UserCourseStatus ucs:userCourseStatuseList){
            Curriculum curriculum = curriculumService.findByCourseId(ucs.getCourseId());
            Curriculum c = (Curriculum)PojoUtil.convertToPojoByAddAttr(curriculum,
                    "courseId,courseName,studyCount,picture,classifyId,classifyName,begintime,endtime");
            curriculumList.add(c);
        }

        logger.info("返回数据成功！");
        return ResultVOUtil.success(curriculumList);
    }
    @PostMapping("/recentStudy")
    public ResultVO listRecentStudy(@RequestBody String request) throws Exception {
        /*System.out.println(request);*/
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        Integer pageNum = params.getInteger("pageNum");

        logger.info("查询用户最近学习课程！");
        logger.info("请求数据内容：{}",request);

        //通过openId查询stuId
        String stuId = new String();
        try {
            stuId = studentService.findStuIdByOpenId(openId);
        } catch (SchoolException e) {
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        //获得用户参与的课程列表
        List<UserCourseStatus> userCourseStatuseList = userCourseStatusService.findByStuId(stuId,pageNum);
        //封装用户课程信息和课程学习进度
        List<Map<String,Object>> list = new ArrayList<>();
        for(UserCourseStatus ucs:userCourseStatuseList){
            List<UserCourseSection> userCourseSectionList
                    = courseSectionService.findByCourseId(ucs.getCourseId());
            int sum = courseSectionService.count(ucs.getCourseId());
            double progress = 0.0;
            try {
                 progress = (double)userCourseSectionList.size() / (double)sum;
            }catch (Exception e){
                e.printStackTrace();
            }
            Map<String , Object> map = new HashMap<>();
            map.put("studyProcess",progress);

            Curriculum curriculum = curriculumService.findByCourseId(ucs.getCourseId());
            Curriculum c = (Curriculum)PojoUtil.convertToPojoByAddAttr(curriculum,
                    "courseId,courseName,studyCount,picture,classifyId,classifyName,begintime,endtime");
            map.put("courseInfo",c);
            list.add(map);
        }

        logger.info("返回数据成功！");
        return ResultVOUtil.success(list);
    }

    @PostMapping("/myCollections")
    public ResultVO listMyCollections(@RequestBody String request) throws Exception {
        System.out.println(request);
        JSONObject params = JSON.parseObject(request);
        String openId = params.getString("openId");
        Integer pageNum = params.getInteger("pageNum");
        logger.info("查询用户收藏的课程！");
        logger.info("请求数据内容：{}",request);

        //通过openId查询stuId
        String stuId = new String();
        try {
            stuId = studentService.findStuIdByOpenId(openId);
        } catch (SchoolException e) {
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        List<UserCollection> collectionList = userCollectionService.listCollectionByStuId(stuId,pageNum);
        //封装用户课程信息和课程学习进度
        List<Map<String,Object>> list = new ArrayList<>();
        for(UserCollection uc:collectionList){
            List<UserCourseSection> userCourseSectionList
                    = courseSectionService.findByCourseId(uc.getObjectId());
            Map<String , Object> map = new HashMap<>();
            map.put("tips",uc.getTips());

            Curriculum curriculum = curriculumService.findByCourseId(uc.getObjectId());
            Curriculum c = (Curriculum)PojoUtil.convertToPojoByAddAttr(curriculum,
                    "courseId,courseName,studyCount,picture,classifyId,classifyName,begintime,endtime");
            map.put("courseInfo",c);
            list.add(map);
        }

        logger.info("返回数据成功！");
        return ResultVOUtil.success(list);
    }
}
