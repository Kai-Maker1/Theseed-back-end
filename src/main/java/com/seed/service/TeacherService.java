package com.seed.service;

import com.seed.model.Teacher;

import java.util.List;

public interface TeacherService {

    /*分页查询所有教师详细信息*/
    List<Teacher> listAllTeachers(int pageNum, int pageSize);

    /*插入一条老师信息*/
    int insertOne(Teacher teacher);

    /*查询指定教师信息*/
    Teacher findTeacherByTeacherId(String teacherId);

    Teacher findTeacherByOpenId(String openId);
    /**/
    String findTeacherIdByOpenId(String openId);
    /**/
    String findCollegeByTeacherId(String tchId);

    /*修改教师信息*/
    int updateOne(Teacher teacher);

    /*删除教师，实际是将del设成true*/
    int deleteOne(String teacherId);


}
