package com.seed.dao;

import com.seed.model.BannerLogo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 接口代理开发
 */
@Mapper
// springboot整合mybatis mapper注入时显示could not autowire的解决
@Component
public interface BannerLogoMapper 
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
	
	/**
     * 删除banner
     * 
     * @param id bannerID
     * @return 结果
     */
	public int deleteBannerLogoById(String id);
	
	/**
     * 批量删除banner
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBannerLogoByIds(String[] ids);
	
}