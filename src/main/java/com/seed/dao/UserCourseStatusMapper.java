package com.seed.dao;

import com.seed.model.UserCourseStatus;
import com.seed.model.UserCourseStatusExample;
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
public interface UserCourseStatusMapper {
    int countByExample(UserCourseStatusExample example);

    int deleteByExample(UserCourseStatusExample example);

    int insert(UserCourseStatus record);

    int insertSelective(UserCourseStatus record);

    List<UserCourseStatus> selectByExample(UserCourseStatusExample example);

    int updateByExampleSelective(@Param("record") UserCourseStatus record, @Param("example") UserCourseStatusExample example);

    int updateByExample(@Param("record") UserCourseStatus record, @Param("example") UserCourseStatusExample example);
}