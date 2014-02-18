package com.flt.web.manage.order.service;

import java.util.List;

import com.flt.dao.model.Order;
import com.flt.web.manage.order.dto.OrderConsumerDTO;

public interface IOrderManageService {

	List<OrderConsumerDTO> listOrderConsumerDTOs(Order orderCondition);
	
	void updateRunStatus(Integer orderId,Integer runStatus);
}
