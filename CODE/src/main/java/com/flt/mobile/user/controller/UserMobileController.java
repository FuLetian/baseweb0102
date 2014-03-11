package com.flt.mobile.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.service.user.IUserCommonService;

@Controller
@RequestMapping("mobile-user")
public class UserMobileController {
	
	@Autowired
	private IUserCommonService userCommonService;

	@RequestMapping("view")
	public String view(Integer userId,Model model,HttpServletRequest req){
		
		if(userId==null){
			userId=1;
		}
		
		model.addAttribute("user", userCommonService.loadUserById(userId));
		model.addAttribute("userId", userId);
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "mobile/user/view.ftl";
	}
	
}
