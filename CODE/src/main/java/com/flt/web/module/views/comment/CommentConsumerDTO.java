package com.flt.web.module.views.comment;

import com.flt.dao.model.Article;
import com.flt.dao.model.Comment;
import com.flt.dao.model.Consumer;

public class CommentConsumerDTO {

	private Consumer consumer;
	private Comment comment;
	private Article article;
	
	public CommentConsumerDTO(Article article,Comment comment,Consumer consumer) {
		// TODO Auto-generated constructor stub
		this.article=article;
		this.consumer=consumer;
		this.comment=comment;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}
