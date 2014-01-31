package com.flt.web.pages.page6;

import com.flt.dao.model.Article;
import com.flt.dao.model.Comment;
import com.flt.dao.model.Order;

public class OrderArticleDTO {

	private Order order;
	private Article article;
	private Comment comment;//对应article,对应指定consumer,一个consumer对一个article只能发表一个评论
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
