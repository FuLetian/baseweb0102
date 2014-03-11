package com.flt.web.manage.order.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.utils.JSONDateValueProcessor;
import com.flt.dao.model.Order;
import com.flt.web.manage.order.dto.OrderConsumerDTO;
import com.flt.web.manage.order.service.IOrderManageService;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private IOrderManageService service;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/order/view.ftl";
	}
	
	@RequestMapping("query")
	@ResponseBody
	public String query(Order order){
		
		List<OrderConsumerDTO> list=service.listOrderConsumerDTOs(order);
		
		JsonConfig config=new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JSONDateValueProcessor());
		
		return JSONArray.fromObject(list).toString();
	}
	
	@RequestMapping("setRunStatus")
	@ResponseBody
	public String setRunStatus(Integer orderId,Integer runStatus){
		
		service.updateRunStatus(orderId, runStatus);
		
		return "SUCCESS";
	}
}
