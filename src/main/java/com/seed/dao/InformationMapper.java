package com.seed.dao;

import com.seed.model.Information;
import com.seed.model.InformationExample;
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
public interface InformationMapper {
    int countByExample(InformationExample example);

    int deleteByExample(InformationExample example);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByExampleWithBLOBs(InformationExample example);

    List<Information> selectByExample(InformationExample example);

    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExampleWithBLOBs(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);
}