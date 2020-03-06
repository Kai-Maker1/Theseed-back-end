package com.seed.service.impl;

import com.seed.dao.CollegeMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.enums.ResultEnum;
import com.seed.exception.SchoolException;
import com.seed.model.College;
import com.seed.model.CollegeExample;
import com.seed.service.CollegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/6 18:52
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    private static Logger logger= LoggerFactory.getLogger(CollegeServiceImpl.class);
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public College findCollegeByCollegeId(String collegeId) {
        CollegeExample collegeExample=new CollegeExample();
        collegeExample.or().andCollegeIdEqualTo(collegeId)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<College> collegeList=
                collegeMapper.selectByExample(collegeExample);
        if(CollectionUtils.isEmpty(collegeList)){
            logger.error("学院不存在，collegeId={}",collegeId);
            throw  new SchoolException(ResultEnum.COLLEGE_NOT_EXIST);
        }
        return collegeList.get(0);
    }

    @Override
    public College findCollegeByCollegeName(String collegeName) {
       College college=
                collegeMapper.selectByCollegeName(collegeName);
        return college;
    }
}
