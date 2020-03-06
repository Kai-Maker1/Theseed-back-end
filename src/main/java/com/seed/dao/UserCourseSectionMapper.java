package com.seed.dao;

import com.seed.model.UserCourseSection;
import com.seed.model.UserCourseSectionExample;
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
public interface UserCourseSectionMapper {
    int countByExample(UserCourseSectionExample example);

    int deleteByExample(UserCourseSectionExample example);

    int insert(UserCourseSection record);

    int insertSelective(UserCourseSection record);

    List<UserCourseSection> selectByExample(UserCourseSectionExample example);

    int updateByExampleSelective(@Param("record") UserCourseSection record, @Param("example") UserCourseSectionExample example);

    int updateByExample(@Param("record") UserCourseSection record, @Param("example") UserCourseSectionExample example);
}