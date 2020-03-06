package com.seed.dao;

import com.seed.model.CourseEvaluation;
import com.seed.model.CourseEvaluationExample;
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
public interface CourseEvaluationMapper {
    int countByExample(CourseEvaluationExample example);

    int deleteByExample(CourseEvaluationExample example);

    int insert(CourseEvaluation record);

    int insertSelective(CourseEvaluation record);

    List<CourseEvaluation> selectByExample(CourseEvaluationExample example);

    int updateByExampleSelective(@Param("record") CourseEvaluation record, @Param("example") CourseEvaluationExample example);

    int updateByExample(@Param("record") CourseEvaluation record, @Param("example") CourseEvaluationExample example);
}