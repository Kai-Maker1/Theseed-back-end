package com.seed.service;

import com.seed.model.CourseClassify;
import com.seed.vo.CourseClassifyVo;

import java.util.List;

public interface CourseClassifyService {
    /*查询所有分类*/
    List<CourseClassify> listAllClassify();

    /*查询所有一级分类*/
    List<CourseClassifyVo> listTheFirstClassify();

    /*查询所有二级分类*/
    List<CourseClassifyVo> listTheSecondClassify();

    /*查询一条记录*/
    CourseClassify fineOneById(Integer id);

    /*更新一条记录*/
    int updateOneById(CourseClassify courseClassify, Integer id);

    /*插入一条记录*/
    int insertOne(CourseClassify courseClassify);


}
