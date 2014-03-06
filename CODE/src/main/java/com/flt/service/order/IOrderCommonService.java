package com.flt.service.order;

import java.util.List;

import com.flt.dao.model.Order;

public interface IOrderCommonService {

	void saveOrder(Order o);
	
	List<Order> listOrderByRunStatus(Integer runstatus,Integer articleId);
	
	Boolean saveOrUpdateOrder(Order order);
}
