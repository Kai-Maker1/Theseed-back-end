package com.seed.dao;

import com.seed.model.CourseSection;
import com.seed.model.CourseSectionExample;
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
public interface CourseSectionMapper {
    int countByExample(CourseSectionExample example);

    int deleteByExample(CourseSectionExample example);

    int insert(CourseSection record);

    int insertSelective(CourseSection record);

    List<CourseSection> selectByExample(CourseSectionExample example);

    int updateByExampleSelective(@Param("record") CourseSection record, @Param("example") CourseSectionExample example);

    int updateByExample(@Param("record") CourseSection record, @Param("example") CourseSectionExample example);
}