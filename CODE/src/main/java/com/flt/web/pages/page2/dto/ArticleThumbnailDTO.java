package com.flt.web.pages.page2.dto;

import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;

public class ArticleThumbnailDTO {

	private Article article;
	private ArticleImg img;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public ArticleImg getImg() {
		return img;
	}
	public void setImg(ArticleImg img) {
		this.img = img;
	}
	
	
}
