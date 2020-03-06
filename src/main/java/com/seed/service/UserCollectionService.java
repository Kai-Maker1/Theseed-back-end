package com.seed.service;

import com.seed.model.UserCollection;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/13 18:44
 */
public interface UserCollectionService {
    List<UserCollection> listCollectionByStuId(String stuId ,int pageNum);
}
