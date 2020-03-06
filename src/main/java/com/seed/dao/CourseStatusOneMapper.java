package com.seed.dao;

import com.seed.model.CourseStatusOne;
import com.seed.model.CourseStatusOneExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口代理开发
 */
@Mapper
// springboot整合mybatis mapper注入时显示could not autowire的解决
@Component
public interface CourseStatusOneMapper {
    int countByExample(CourseStatusOneExample example);

    int deleteByExample(CourseStatusOneExample example);

    int insert(CourseStatusOne record);

    int insertSelective(CourseStatusOne record);

    List<CourseStatusOne> selectByExample(CourseStatusOneExample example);

    int updateByExampleSelective(@Param("record") CourseStatusOne record, @Param("example") CourseStatusOneExample example);

    int updateByExample(@Param("record") CourseStatusOne record, @Param("example") CourseStatusOneExample example);
}