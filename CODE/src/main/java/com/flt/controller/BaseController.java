package com.flt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class BaseController {

	protected String sendFTL(String ftlName,Model model,HttpServletRequest req){
		
		String basePath=req.getContextPath()+"/";
		model.addAttribute("basePath", basePath);
		
		return ftlName;
	}
}
