package com.seed.dao;

import com.seed.model.CourseClassify;
import com.seed.model.CourseClassifyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 接口代理开发
 */
@Mapper
// springboot整合mybatis mapper注入时显示could not autowire的解决
@Component
public interface CourseClassifyMapper {
    int countByExample(CourseClassifyExample example);

    int deleteByExample(CourseClassifyExample example);

    int insert(CourseClassify record);

    int insertSelective(CourseClassify record);

    List<CourseClassify> selectByExample(CourseClassifyExample example);

    int updateByExampleSelective(@Param("record") CourseClassify record, @Param("example") CourseClassifyExample example);

    int updateByExample(@Param("record") CourseClassify record, @Param("example") CourseClassifyExample example);
}