package com.seed.service.impl;

import com.seed.dao.BannerLogoMapper;
import com.seed.model.BannerLogo;
import com.seed.service.IBannerLogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * banner 服务层实现
 *
 * @author ruoyi
 * @date 2018-12-23
 */
@Service
public class BannerLogoServiceImpl implements IBannerLogoService
{
    @Autowired
    private BannerLogoMapper bannerLogoMapper;

    /**
     * 查询banner信息
     *
     * @param id bannerID
     * @return banner信息
     */
    @Override
    public BannerLogo selectBannerLogoById(String id)
    {
        return bannerLogoMapper.selectBannerLogoById(id);
    }

    /**
     * 查询banner列表
     *
     * @return banner集合
     */
    @Override
    public List<BannerLogo> selectBannerLogoList(BannerLogo bannerLogo)
    {

        return bannerLogoMapper.selectBannerLogoList(bannerLogo);
    }

    /**
     * 新增banner
     *
     * @param bannerLogo banner信息
     * @return 结果
     */
    @Override
    public int insertBannerLogo(BannerLogo bannerLogo)
    {
        return bannerLogoMapper.insertBannerLogo(bannerLogo);
    }

    /**
     * 修改banner
     *
     * @param bannerLogo banner信息
     * @return 结果
     */
    @Override
    public int updateBannerLogo(BannerLogo bannerLogo)
    {

        return bannerLogoMapper.updateBannerLogo(bannerLogo);
    }



}
