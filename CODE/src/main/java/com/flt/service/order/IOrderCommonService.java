package com.flt.service.order;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.flt.dao.model.Order;
import com.flt.dto.OrderArticleComment;

public interface IOrderCommonService {

	void saveOrder(Order o);
	
	List<Order> listOrderByRunStatus(Integer runstatus,Integer articleId);
	
	List<OrderArticleComment> listCOnsumerOrderByRunStatus(Integer runstatus,Integer consumerId);
	
	OrderArticleComment loadOrderArticleByOrderId(Integer orderId);
	
	OrderArticleComment loadOrderArticleByOrderId(Integer orderId,Integer consumerId);
	
	Boolean saveOrUpdateOrder(Order order);
	
	int countOrderByRunStatus(Integer runStatus,Integer consumerId);
	
	Order loadOrderById(Integer orderId);
	
	void updateOrder(Order order);
	
	List<Integer> listCountBetweenDateByRunstatus(Calendar startDate,Calendar endDate,List<Integer> runStatusList,Integer userId);
}
