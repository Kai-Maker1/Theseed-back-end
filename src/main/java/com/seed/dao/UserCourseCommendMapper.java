package com.seed.dao;

import com.seed.model.UserCourseCommend;
import com.seed.model.UserCourseCommendExample;
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
public interface UserCourseCommendMapper {
    int countByExample(UserCourseCommendExample example);

    int deleteByExample(UserCourseCommendExample example);

    int insert(UserCourseCommend record);

    int insertSelective(UserCourseCommend record);

    List<UserCourseCommend> selectByExample(UserCourseCommendExample example);

    int updateByExampleSelective(@Param("record") UserCourseCommend record, @Param("example") UserCourseCommendExample example);

    int updateByExample(@Param("record") UserCourseCommend record, @Param("example") UserCourseCommendExample example);
}