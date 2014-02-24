package com.flt.web.pages.page2.dto;

import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;

public class ArticleThumbnailDTO {

	private Article article;
	private ArticleImg img;
	private Integer collectionStatus=0;//收藏 状态 0-非收藏,1-收藏
	private Integer collectionCount=0;//收藏数量
	private Integer commentCount=0;//评论数量
	
	public Integer getCollectionStatus() {
		return collectionStatus;
	}
	public void setCollectionStatus(Integer collectionStatus) {
		this.collectionStatus = collectionStatus;
	}
	public Integer getCollectionCount() {
		return collectionCount;
	}
	public void setCollectionCount(Integer collectionCount) {
		this.collectionCount = collectionCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
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
