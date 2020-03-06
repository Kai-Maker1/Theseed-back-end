package com.seed.dao;

import com.seed.model.UserCollection;
import com.seed.model.UserCollectionExample;
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
public interface UserCollectionMapper {
    int countByExample(UserCollectionExample example);

    int deleteByExample(UserCollectionExample example);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    List<UserCollection> selectByExample(UserCollectionExample example);

    int updateByExampleSelective(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    int updateByExample(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);
}