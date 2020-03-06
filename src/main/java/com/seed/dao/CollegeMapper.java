package com.seed.dao;

import com.seed.model.College;
import com.seed.model.CollegeExample;
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
public interface CollegeMapper {
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    College selectByCollegeName(String collegeName);
    College selectByCollegeId(String collegeId);
}