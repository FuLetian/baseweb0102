package com.flt.web.manage.order.dto;

import com.flt.dao.model.Article;
import com.flt.dao.model.Consumer;
import com.flt.dao.model.Order;

public class OrderConsumerDTO {

	private Order order;
	private Consumer consumer;
	private Article article;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
	
}
