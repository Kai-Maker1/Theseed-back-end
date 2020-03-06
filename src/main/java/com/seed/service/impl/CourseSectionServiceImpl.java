package com.seed.service.impl;

import com.seed.dao.CourseSectionMapper;
import com.seed.dao.UserCourseSectionMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.enums.ResultEnum;
import com.seed.enums.UserCourseSectionStatusEnum;
import com.seed.exception.SchoolException;
import com.seed.model.CourseSection;
import com.seed.model.CourseSectionExample;
import com.seed.model.UserCourseSection;
import com.seed.model.UserCourseSectionExample;
import com.seed.service.CourseSectionService;
import com.seed.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/6 16:49
 */
@Service
public class CourseSectionServiceImpl implements CourseSectionService {

    @Autowired
    private CourseSectionMapper courseSectionMapper;
    @Autowired
    private UserCourseSectionMapper userCourseSectionMapper;

    @Override
    public int count(String courseId) {
        CourseSectionExample courseSectionExample=new CourseSectionExample();
        courseSectionExample.or().andCourseIdEqualTo(courseId)
                .andParentIdNotEqualTo(0)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        int result = courseSectionMapper.countByExample(courseSectionExample);
        return result;
    }

    @Override
    public List<CourseSection> findChapterByCourseId(String courseId) {
        CourseSectionExample courseSectionExample=new CourseSectionExample();
        courseSectionExample.or().andParentIdEqualTo(0)
                .andCourseIdEqualTo(courseId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<CourseSection> courseSectionList=
                courseSectionMapper.selectByExample(courseSectionExample);
        return courseSectionList;
    }

    @Override
    public List<CourseSection> findSectionByParentId(Integer parentId) {
        CourseSectionExample courseSectionExample=new CourseSectionExample();
        courseSectionExample.or().andParentIdEqualTo(parentId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        courseSectionExample.setOrderByClause("sort ASC");
        List<CourseSection> courseSectionList=
                courseSectionMapper.selectByExample(courseSectionExample);
        return courseSectionList;
    }

    @Override
    public List<UserCourseSection> listStudyTimeToday(String stuId) {
        UserCourseSectionExample userCourseSectionExample = new UserCourseSectionExample();
        userCourseSectionExample.or().andStuIdEqualTo(stuId)
                .andStatusEqualTo(UserCourseSectionStatusEnum.END_LEARN.getValue())
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue())
               .andUpdateTimeBetween(DateUtil.todayStart(),DateUtil.todayEnd());
        List<UserCourseSection> userCourseSectionList
                =userCourseSectionMapper.selectByExample(userCourseSectionExample);
        return userCourseSectionList;
    }

    @Override
    public CourseSection findByCourseScetionId(Integer courseScetionId) {
        CourseSectionExample courseSectionExample = new CourseSectionExample();
        courseSectionExample.or().andCourseSectionIdEqualTo(courseScetionId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<CourseSection> courseSectionList =
                courseSectionMapper.selectByExample(courseSectionExample);
        if(CollectionUtils.isEmpty(courseSectionList)){
            throw new SchoolException(ResultEnum.COURSE_SECTION_NOT_EXIST);
        }
        return courseSectionList.get(0);
    }

    @Override
    public List<UserCourseSection> findByCourseId(String courseId) {
        UserCourseSectionExample userCourseSectionExample = new UserCourseSectionExample();
        userCourseSectionExample.or().andCourseIdEqualTo(courseId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<UserCourseSection> userCourseSectionList =
                userCourseSectionMapper.selectByExample(userCourseSectionExample);
        /*if(CollectionUtils.isEmpty(userCourseSectionList)){
            throw new SchoolException(70,"未找到该课程所对应章节");
        }*/
        return userCourseSectionList;
    }

}
