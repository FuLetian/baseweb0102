package com.flt.controller.wechat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.service.base.BusinessService;

@Controller
@RequestMapping("wechat-business")
public class BusinessController {
	
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping("page-login")
	public String pageLogin(Model model,HttpServletRequest req){
		model.addAttribute("testValue", this.businessService.test());
		return "example.ftl";
	}
}
