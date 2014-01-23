package com.flt.web.module.views.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Article;

@View(template="component/article/{theme}/articleInPage2View.ftl")
public class ArticleInPage2View extends BaseView {

	private Integer channelId;
	private Integer brandId;
	private Integer menuId;
	private String priceRange;
	private String discountRange;
	
	@Autowired
	private IArticleService service;
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		List<Article> list=service.findArticlesIfConditionExist(channelId, brandId, menuId, priceRange, discountRange);
		
		root.put("articles", list);
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
	
	
}
