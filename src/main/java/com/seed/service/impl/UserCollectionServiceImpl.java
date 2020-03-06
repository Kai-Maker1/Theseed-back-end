package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.UserCollectionMapper;
import com.seed.enums.PageConstant;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.UserCollection;
import com.seed.model.UserCollectionExample;
import com.seed.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/12 18:46
 */
@Service
public class UserCollectionServiceImpl implements UserCollectionService {
    @Autowired
    private UserCollectionMapper collectionMapper;

    @Override
    public List<UserCollection> listCollectionByStuId(String stuId,int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());
        UserCollectionExample userCollectionExample = new UserCollectionExample();
        userCollectionExample.or().andStuIdEqualTo(stuId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        userCollectionExample.setOrderByClause("update_time desc");
        List<UserCollection> userCollectionList =
                collectionMapper.selectByExample(userCollectionExample);
        return userCollectionList;
    }
}
