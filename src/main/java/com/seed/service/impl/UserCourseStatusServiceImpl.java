package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.UserCourseStatusMapper;
import com.seed.enums.PageConstant;
import com.seed.enums.RecordStatusEnum;
import com.seed.enums.ResultEnum;
import com.seed.exception.SchoolException;
import com.seed.model.UserCourseStatus;
import com.seed.model.UserCourseStatusExample;
import com.seed.service.UserCourseStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/2 18:28
 */
@Service
public class UserCourseStatusServiceImpl implements UserCourseStatusService {

    private static Logger logger =  LoggerFactory.getLogger(UserCourseStatusServiceImpl.class);
    @Autowired
    private UserCourseStatusMapper userCourseStatusMapper;

    @Override
    public List<UserCourseStatus> findByStuId(String stuId,int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());
        UserCourseStatusExample userCourseStatusExample=new UserCourseStatusExample();
        userCourseStatusExample.or().andStuIdEqualTo(stuId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        userCourseStatusExample.setOrderByClause("update_time desc");
        List<UserCourseStatus> userCourseStatusList=
                userCourseStatusMapper.selectByExample(userCourseStatusExample);
        if(CollectionUtils.isEmpty(userCourseStatusList)){
            logger.error("【用户课程学习状态】用户未参与任何课程，stuId={}",stuId);

                throw new SchoolException(ResultEnum.USER_NOT_JOIN);
        }
        return userCourseStatusList;
    }
    @Override
    public List<UserCourseStatus> findByStuId(String stuId) {

        UserCourseStatusExample userCourseStatusExample=new UserCourseStatusExample();
        userCourseStatusExample.or().andStuIdEqualTo(stuId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        userCourseStatusExample.setOrderByClause("update_time desc");
        List<UserCourseStatus> userCourseStatusList=
                userCourseStatusMapper.selectByExample(userCourseStatusExample);
        if(CollectionUtils.isEmpty(userCourseStatusList)){
            logger.error("【用户课程学习状态】用户未参与任何课程，stuId={}",stuId);

            throw new SchoolException(ResultEnum.USER_NOT_JOIN);
        }
        return userCourseStatusList;
    }
}
