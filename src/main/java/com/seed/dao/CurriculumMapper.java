package com.seed.dao;

import com.seed.model.Curriculum;
import com.seed.model.CurriculumExample;
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
public interface CurriculumMapper {
    int countByExample(CurriculumExample example);

    int deleteByExample(CurriculumExample example);

    int insert(Curriculum record);

    int insertSelective(Curriculum record);

    List<Curriculum> selectByExampleWithBLOBs(CurriculumExample example);

    List<Curriculum> selectByExample(CurriculumExample example);

    int updateByExampleSelective(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByExampleWithBLOBs(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByExample(@Param("record") Curriculum record, @Param("example") CurriculumExample example);
}