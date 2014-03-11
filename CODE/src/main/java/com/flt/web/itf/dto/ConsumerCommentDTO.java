package com.flt.web.itf.dto;

import com.flt.dao.model.Article;
import com.flt.dao.model.Comment;
import com.flt.dao.model.Consumer;

/**
 *<p>功能:</p>
 *<p></p>
 *<p>Copyright:Copyright(c)2013</p>
 *<p>Company:sky</p>
 *@author 付乐天
 *@version 1.0 */

public class ConsumerCommentDTO {

	private Consumer consumer;
	private Comment comment;
	private Article article;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
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
	
	
}
