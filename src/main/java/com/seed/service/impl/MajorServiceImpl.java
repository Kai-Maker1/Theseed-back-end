package com.seed.service.impl;

import com.seed.dao.MajorMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.Major;
import com.seed.model.MajorExample;
import com.seed.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/14 17:36
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    @Override
    public Major findMajorByMajorName(String majorName) {
        Major major = majorMapper.selectByMajorName(majorName);
        return major;
        /*MajorExample majorExample = new MajorExample();
        majorExample.or().andMajorNameEqualTo(majorName)
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        return majorMapper.selectByExample(majorExample);*/
    }

    @Override
    public List<Major> listAll() {
        MajorExample majorExample = new MajorExample();
        majorExample.or()
                .andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        return majorMapper.selectByExample(majorExample);
    }

    @Override
    public Major findMajorByMajorId(String majorId) {
        Major major = majorMapper.selectByMajorId(majorId);
        return major;
    }
}
