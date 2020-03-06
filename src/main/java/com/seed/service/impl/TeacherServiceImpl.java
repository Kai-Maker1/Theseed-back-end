package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.TeacherMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.enums.ResultEnum;
import com.seed.exception.SchoolException;
import com.seed.model.Teacher;
import com.seed.model.TeacherExample;
import com.seed.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {
    private static Logger logger= LoggerFactory.getLogger(TeacherServiceImpl.class);
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> listAllTeachers(int pageNum, int pageSize) {
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        teacherExample.setDistinct(false);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        return teachers;
    }

    @Override
    @Transactional
    public int insertOne(Teacher teacher) {
        int records=teacherMapper.insertSelective(teacher);
        return records;
    }

    @Override
    public Teacher findTeacherByTeacherId(String teacherId) {
        TeacherExample teacherExample=new TeacherExample();
        teacherExample.or().andTeacherIdEqualTo(teacherId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
        if(CollectionUtils.isEmpty(teacherList)){
            logger.error("教师ID不存在，teacherId={}",teacherId);
            throw new SchoolException(ResultEnum.USER_NOT_EXIST);
        }
        return teacherList.get(0);
    }

    @Override
    public Teacher findTeacherByOpenId(String openId) {
        Teacher teacher=teacherMapper.selectTeacherByOpenId(openId);
        return teacher;
    }

    @Override
    public String findTeacherIdByOpenId(String openId) {
        TeacherExample teacherExample=new TeacherExample();
        teacherExample.or().andOpenIdEqualTo(openId);
        List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
        if(CollectionUtils.isEmpty(teacherList)){
            logger.error("用户openid不存在，openId={}",openId);
            throw new SchoolException(ResultEnum.USER_NOT_EXIST);
        }
        return teacherList.get(0).getTeacherId();
    }

    @Override
    public String findCollegeByTeacherId(String tchId) {
        TeacherExample teacherExample=new TeacherExample();
        teacherExample.or().andTeacherIdEqualTo(tchId)
                            .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
        if(CollectionUtils.isEmpty(teacherList)){
            logger.error("教师ID不存在，tchId={}",tchId);
            throw new SchoolException(ResultEnum.USER_NOT_EXIST);
        }
        return teacherList.get(0).getCollegeId();
    }

    @Override
    public int updateOne(Teacher teacher) {
        TeacherExample teacherExample=new TeacherExample();
        teacherExample.or().andTeacherIdEqualTo(teacher.getTeacherId())
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        int result = teacherMapper.updateByExampleSelective(teacher,teacherExample);
        return result;
    }

    @Override
    public int deleteOne(String teacherId) {
        Teacher t = findTeacherByTeacherId(teacherId);
        t.setDel(RecordStatusEnum.DELETE.getValue());
        int result = updateOne(t);
        return result;
    }
}
