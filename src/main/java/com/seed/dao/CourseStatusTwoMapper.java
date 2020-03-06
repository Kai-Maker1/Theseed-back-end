package com.seed.dao;

import com.seed.model.CourseStatusTwo;
import com.seed.model.CourseStatusTwoExample;
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
public interface CourseStatusTwoMapper {
    int countByExample(CourseStatusTwoExample example);

    int deleteByExample(CourseStatusTwoExample example);

    int insert(CourseStatusTwo record);

    int insertSelective(CourseStatusTwo record);

    List<CourseStatusTwo> selectByExample(CourseStatusTwoExample example);

    int updateByExampleSelective(@Param("record") CourseStatusTwo record, @Param("example") CourseStatusTwoExample example);

    int updateByExample(@Param("record") CourseStatusTwo record, @Param("example") CourseStatusTwoExample example);
}