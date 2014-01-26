package com.flt.web.itf.dto;

import com.flt.dao.model.Article;


public class AritcleCountDTO {


	private Article article;
	private Integer count;
	private String thumbnail;
	
	
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
	
	
}
