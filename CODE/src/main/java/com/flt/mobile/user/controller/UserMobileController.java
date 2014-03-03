package com.flt.mobile.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mobile-user")
public class UserMobileController {

	@RequestMapping("view")
	public String view(Integer userId,Model model,HttpServletRequest req){
		
		return "mobile/user/view.ftl";
	}
	
}
