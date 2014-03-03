package com.flt.mobile.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mobile-order")
public class OrderMobileController {

	@RequestMapping("view")
	public String view(Integer userId,Model model,HttpServletRequest req){
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/order/view.ftl";
	}
}
