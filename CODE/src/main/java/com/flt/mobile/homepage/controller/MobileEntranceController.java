package com.flt.mobile.homepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.service.user.IUserCommonService;

@Controller
public class MobileEntranceController {
	
	@Autowired
	private IUserCommonService userCommonService;

	@RequestMapping("{siteAddress}")
	public String entrance(@PathVariable String siteAddress,Model model,HttpServletRequest req){
		
		model.addAttribute("user", userCommonService.loadUserBySiteAddress(siteAddress));
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "mobile/homepage/index.ftl";
	}
	
}
