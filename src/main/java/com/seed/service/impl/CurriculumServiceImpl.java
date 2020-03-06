package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.CourseEvaluationMapper;
import com.seed.dao.CurriculumMapper;
import com.seed.enums.PageConstant;
import com.seed.enums.RecordStatusEnum;
import com.seed.enums.ResultEnum;
import com.seed.exception.SchoolException;
import com.seed.model.CourseEvaluation;
import com.seed.model.CourseEvaluationExample;
import com.seed.model.Curriculum;
import com.seed.model.CurriculumExample;
import com.seed.service.CurriculumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    private static Logger logger =  LoggerFactory.getLogger(CurriculumServiceImpl.class);

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private CourseEvaluationMapper courseEvaluationMapper;

    @Override
    public List<Curriculum> listAllCurriculum(int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());
        CurriculumExample curriculumExample = new CurriculumExample();
        curriculumExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        curriculumExample.setDistinct(false);
        List<Curriculum> curriculums = curriculumMapper.selectByExampleWithBLOBs(curriculumExample);
        return curriculums;
    }

    /**
     * 全部or父级名称----全部or子级名称---综合（默认）/热门/最新----全部/未开始/进行中/已结束
     *  parentName 全部or父级名称 classify_name
     *  childName 全部or子级名称 sub_classify_name
     *  statusOne 综合（默认）/热门/最新 study_count/begintime
     *  statusTwo 全部/未开始/进行中/已结束 status
     *  pageNum
     *  pageSize
     * @return
     */

    @Override
    public List<Curriculum> listCurriculum(Integer parentId, Integer childId, String statusOne, String statusTwo, int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());
        CurriculumExample curriculumExample=new CurriculumExample();
        CurriculumExample.Criteria criteria=curriculumExample.createCriteria();
        criteria.andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());

        if(parentId>0 && parentId!=null){
            criteria.andClassifyIdEqualTo(parentId);
        }
        if(childId>0 && childId!=null){
            criteria.andSubClassifyIdEqualTo(childId);
        }
        if(statusTwo!="" && statusTwo!=null){
            if("未开始".equals(statusTwo)){
                criteria.andStatusEqualTo(statusTwo);
            }
            if("进行中".equals(statusTwo)){
                criteria.andStatusEqualTo(statusTwo);
            }
            if("已结束".equals(statusTwo)){
                criteria.andStatusEqualTo(statusTwo);
            }
        }
        if(statusOne!="" && statusOne!=null){
            if("热门".equals(statusOne)){
                curriculumExample.setOrderByClause("study_count desc");
            }
            if("最新".equals(statusOne)){
                curriculumExample.setOrderByClause("begintime desc");
            }
        }
        curriculumExample.setDistinct(false);
        List<Curriculum> curriculumList = curriculumMapper.selectByExampleWithBLOBs(curriculumExample);

        return curriculumList;
    }

    @Override
    public Curriculum findByCourseId(String courseId) {
        CurriculumExample curriculumExample = new CurriculumExample();
        curriculumExample.or().andCourseIdEqualTo(courseId)
                              .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<Curriculum> curriculumList = curriculumMapper.selectByExampleWithBLOBs(curriculumExample);
        if(CollectionUtils.isEmpty(curriculumList)){
            logger.error("【课程详情】当前课程不存在，courseId={}",courseId);
            throw new SchoolException(ResultEnum.COURSE_NOT_EXIST);
        }
        return curriculumList.get(0);
    }

    @Override
    public List<CourseEvaluation> findEvaluationByCourseId(String courseId) {
        CourseEvaluationExample courseEvaluationExample=new CourseEvaluationExample();
        courseEvaluationExample.or().andCourseIdEqualTo(courseId)
                                    .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<CourseEvaluation> courseEvaluationList=
                courseEvaluationMapper.selectByExample(courseEvaluationExample);
        return courseEvaluationList;
    }

}
