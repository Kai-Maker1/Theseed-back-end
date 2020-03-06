package com.seed.dao;

import com.seed.model.CourseNotice;
import com.seed.model.CourseNoticeExample;
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
public interface CourseNoticeMapper {
    int countByExample(CourseNoticeExample example);

    int deleteByExample(CourseNoticeExample example);

    int insert(CourseNotice record);

    int insertSelective(CourseNotice record);

    List<CourseNotice> selectByExampleWithBLOBs(CourseNoticeExample example);

    List<CourseNotice> selectByExample(CourseNoticeExample example);

    int updateByExampleSelective(@Param("record") CourseNotice record, @Param("example") CourseNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseNotice record, @Param("example") CourseNoticeExample example);

    int updateByExample(@Param("record") CourseNotice record, @Param("example") CourseNoticeExample example);
}