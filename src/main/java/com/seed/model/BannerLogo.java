package com.seed.model;
import java.io.Serializable;
import java.util.Date;

/**
 * banner表 t_banner_logo
 * 
 * @author Li Yawei
 * @date 2018-12-23
 */
public class BannerLogo implements Serializable
{
	private static final long serialVersionUID = -3218477979301705066L;
	
	/**  */
	private String id;
	/**  */
	private String name;
	/**  */
	private String description;
	/**  */
	private String type;
	/**  */
	private String pic;
	/**  */
	private String text;
	/**  */
	private String link;
	/**  */
	private String htmlContent;
	/**  */
	private Date createTime;
	/**  */
	private String aDSort;
	/**  */
	private Date beginTime;
	/**  */
	private Date endTime;
	/**  */
	private String adPlaceId;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setPic(String pic) 
	{
		this.pic = pic;
	}

	public String getPic() 
	{
		return pic;
	}
	public void setText(String text) 
	{
		this.text = text;
	}

	public String getText() 
	{
		return text;
	}
	public void setLink(String link) 
	{
		this.link = link;
	}

	public String getLink() 
	{
		return link;
	}
	public void setHtmlContent(String htmlContent) 
	{
		this.htmlContent = htmlContent;
	}

	public String getHtmlContent() 
	{
		return htmlContent;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setADSort(String aDSort) 
	{
		this.aDSort = aDSort;
	}

	public String getADSort() 
	{
		return aDSort;
	}
	public void setBeginTime(Date beginTime) 
	{
		this.beginTime = beginTime;
	}

	public Date getBeginTime() 
	{
		return beginTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}

	public String getaDSort() {
		return aDSort;
	}

	public void setaDSort(String aDSort) {
		this.aDSort = aDSort;
	}

	public String getAdPlaceId() {
		return adPlaceId;
	}

	public void setAdPlaceId(String adPlaceId) {
		this.adPlaceId = adPlaceId;
	}

}
