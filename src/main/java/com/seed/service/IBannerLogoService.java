package com.seed.service;

import com.seed.model.BannerLogo;

import java.util.List;

/**
 * banner 服务层
 */
public interface IBannerLogoService
{
    /**
     * 查询banner信息
     *
     * @param id bannerID
     * @return banner信息
     */
    public BannerLogo selectBannerLogoById(String id);

    /**
     * 查询banner列表
     *
     * @param bannerLogo banner信息
     * @return banner集合
     */
    public List<BannerLogo> selectBannerLogoList(BannerLogo bannerLogo);
    /**
     * 新增banner
     *
     * @param bannerLogo banner信息
     * @return 结果
     */
    public int insertBannerLogo(BannerLogo bannerLogo);

    /**
     * 修改banner
     *
     * @param bannerLogo banner信息
     * @return 结果
     */
    public int updateBannerLogo(BannerLogo bannerLogo);



}
