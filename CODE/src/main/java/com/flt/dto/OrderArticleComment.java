package com.flt.dto;

import com.flt.dao.model.Article;
import com.flt.dao.model.Comment;
import com.flt.dao.model.Order;

public class OrderArticleComment {

	private Order order;
	private Article article;
	private Comment comment;

	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
