package com.flt.web.module.views.article;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;
import com.flt.web.pages.page2.dto.ArticleThumbnailDTO;

@View(template="component/article/{theme}/articleInPage2View.ftl")
public class ArticleInPage2View extends BaseView {

	private Integer consumerId;
	private Integer channelId;
	private Integer brandId;
	private Integer menuId;
	private String priceRange;
	private String discountRange;
	
	private Integer orderByType; //1-销量降序，2-价格声讯,3-折扣升序;
	
	@Autowired
	private IArticleService service;
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
	}
	public String getJSON(){
		List<Article> list=service.findArticlesIfConditionExist(channelId, brandId, menuId, priceRange, discountRange,userId,orderByType);
		
		List<ArticleThumbnailDTO> dtos=new ArrayList<>();
		for(Article a:list){
			ArticleImg img=service.loadFirstArticleImgByArticleId(a.getId());
			
			ArticleThumbnailDTO dto=new ArticleThumbnailDTO();
			dto.setArticle(a);
			dto.setImg(img);
			dto.setCollectionCount(service.loadArticleCollectionCount(a.getId()));
			dto.setCollectionStatus(consumerId==null?0:service.loadConsumerArticleCollectionStatus(consumerId, a.getId()));
			dto.setCommentCount(service.loadCommentCountByArticleId(a.getId()));
			
			dtos.add(dto);
		}
		return JSONArray.fromObject(dtos).toString();
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	public String getDiscountRange() {
		return discountRange;
	}
	public void setDiscountRange(String discountRange) {
		this.discountRange = discountRange;
	}
	public Integer getOrderByType() {
		return orderByType;
	}
	public void setOrderByType(Integer orderByType) {
		this.orderByType = orderByType;
	}
	public Integer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}
	
	
}
