package com.seed.service.impl;

import com.github.pagehelper.PageHelper;
import com.seed.dao.InformationMapper;
import com.seed.enums.PageConstant;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.Information;
import com.seed.model.InformationExample;
import com.seed.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/12 0:30
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public List<Information> listInfomation(int pageNum) {
        //使用分页插件
        PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE.getValue());

        InformationExample informationExample=new InformationExample();
        informationExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        informationExample.setOrderByClause("create_time desc");
        List<Information> informationList=
                informationMapper.selectByExampleWithBLOBs(informationExample);
        return informationList;
    }
}
