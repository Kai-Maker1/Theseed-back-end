package com.seed.service;

import com.seed.model.Student;
import com.seed.model.UserCourseCommend;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 10:30
 */
public interface StudentService {
    /**/
    List<Student> findAll(int pageNum,int pageSize);
    /*通过openId查询stuId*/
    String findStuIdByOpenId(String openId);

    Student findStudentByOpenId(String openId);

    Student findStudentByStuId(String stuId);

    /*查询该学生的课程推荐列表*/
    List<UserCourseCommend> findCommend(String stuId);

    /*创建一个用户*/
    int createOne(Student student);

    /*更新学生信息*/
    int updateOne(Student student, String openId);

    int update(Student student);
    /*删除一个学生*/
    int deleteOne(String studentId);
}
