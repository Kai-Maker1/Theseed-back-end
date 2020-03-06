package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.StudentMapper;
import com.seed.dao.UserCourseCommendMapper;
import com.seed.enums.CommendStatusEnum;
import com.seed.enums.RecordStatusEnum;
import com.seed.enums.ResultEnum;
import com.seed.exception.SchoolException;
import com.seed.model.Student;
import com.seed.model.StudentExample;
import com.seed.model.UserCourseCommend;
import com.seed.model.UserCourseCommendExample;
import com.seed.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/2 9:53
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserCourseCommendMapper userCourseCommendMapper;

    @Override
    public List<Student> findAll(int pageNum,int pageSize) {
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        StudentExample studentExample = new StudentExample();
        studentExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<Student> studentList =
                studentMapper.selectByExample(studentExample);
        return studentList;
    }

    @Override
    public String findStuIdByOpenId(String openId) {
        StudentExample studentExample=new StudentExample();
        studentExample.or().andOpenIdEqualTo(openId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<Student> studentList=studentMapper.selectByExample(studentExample);
        if(CollectionUtils.isEmpty(studentList)){

                throw new SchoolException(ResultEnum.USER_NOT_EXIST);
        }
        return studentList.get(0).getStuId();
    }

    @Override
    public Student findStudentByOpenId(String openId) {
        Student student = studentMapper.selectStudentByOpenId(openId);
        return student;
    }

    @Override
    public Student findStudentByStuId(String stuId) {
        StudentExample studentExample=new StudentExample();
        studentExample.or().andStuIdEqualTo(stuId)
                            .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<Student> studentList=studentMapper.selectByExample(studentExample);
        if(CollectionUtils.isEmpty(studentList)){

            throw new SchoolException(ResultEnum.USER_NOT_EXIST);
        }
        return studentList.get(0);
    }

    @Override
    public List<UserCourseCommend> findCommend(String stuId) {
        /*查询需要推荐的课程ID*/
        UserCourseCommendExample userCourseCommendExample=new UserCourseCommendExample();

        userCourseCommendExample.or().andStuIdEqualTo(stuId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue()).
                andRecommendEqualTo(CommendStatusEnum.NOTCOMMENDED.getValue());
        List<UserCourseCommend> courseCommendList=
                userCourseCommendMapper.selectByExample(userCourseCommendExample);
        return courseCommendList;
    }

    @Override
    public int createOne(Student student) {
        int result=studentMapper.insertSelective(student);
        return result;
    }

    @Override
    public int updateOne(Student student , String openId) {
        StudentExample studentExample=new StudentExample();
        studentExample.or().andOpenIdEqualTo(openId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        int result = studentMapper.updateByExampleSelective(student,studentExample);
        return result;
    }

    @Override
    public int update(Student student) {
        StudentExample studentExample=new StudentExample();
        studentExample.or().andStuIdEqualTo(student.getStuId())
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        int result = studentMapper.updateByExampleSelective(student,studentExample);
        return result;
    }

    @Override
    public int deleteOne(String studentId) {
        Student student = findStudentByStuId(studentId);
        student.setDel(RecordStatusEnum.DELETE.getValue());
        int result = update(student);
        return result;
    }
}
