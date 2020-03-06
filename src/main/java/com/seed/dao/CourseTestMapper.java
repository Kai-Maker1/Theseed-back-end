package com.seed.dao;

import com.seed.model.CourseTest;
import com.seed.model.CourseTestExample;
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
public interface CourseTestMapper {
    int countByExample(CourseTestExample example);

    int deleteByExample(CourseTestExample example);

    int insert(CourseTest record);

    int insertSelective(CourseTest record);

    List<CourseTest> selectByExample(CourseTestExample example);

    int updateByExampleSelective(@Param("record") CourseTest record, @Param("example") CourseTestExample example);

    int updateByExample(@Param("record") CourseTest record, @Param("example") CourseTestExample example);
}