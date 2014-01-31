package com.flt.web.pages.page6.service;

import java.util.List;

import com.flt.web.pages.page6.OrderArticleDTO;

public interface IPage6OrderService {

	List<OrderArticleDTO> listOrderArticleDTOsByRunStatus(Integer runStatus,Integer consumerId);
	
	void addCommentForArticle(String content,Integer grade,Integer consumerId,Integer articleId,Integer userId);
	
	void deleteOrder(Integer orderId);
	
	void setRunStatus(Integer orderId,Integer runStatus);
}
