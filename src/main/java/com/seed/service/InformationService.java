package com.seed.service;

import com.seed.model.Information;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/12 0:12
 */
public interface InformationService {
    List<Information> listInfomation(int pageNum);
}
