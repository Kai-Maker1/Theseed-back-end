package com.seed.service;

import com.seed.model.Major;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/14 17:35
 */
public interface MajorService {
    Major findMajorByMajorName(String majorName);
    /*List<Major> findMajorByMajorName(String majorName);*/
    List<Major> listAll();
    Major findMajorByMajorId(String majorId);
}
