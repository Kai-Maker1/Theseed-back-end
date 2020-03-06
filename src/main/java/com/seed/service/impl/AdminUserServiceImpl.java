package com.seed.service.impl;

import com.seed.dao.AdminUserMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.enums.ResultEnum;
import com.seed.exception.SchoolException;
import com.seed.model.AdminUser;
import com.seed.model.AdminUserExample;
import com.seed.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/18 0:49
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    private Logger logger= LoggerFactory.getLogger(AdminUserServiceImpl.class);
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser userToLogin(String adminName, String password) {
        AdminUserExample adminUserExample=new AdminUserExample();
        adminUserExample.or().andAdminNameEqualTo(adminName)
                .andPasswordEqualTo(password)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<AdminUser> adminUserList=new ArrayList<>();
        try {
            adminUserList = adminUserMapper.selectByExample(adminUserExample);
        }catch (Exception e){
            /*throw new SchoolException(ResultEnum.NO_AUTHORITY);*/
            logger.error("该用户没有权限，name={}",adminName);
            return null;
        }
        return adminUserList.get(0);
    }
}
