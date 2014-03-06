package com.flt.mobile.homepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MobileEntranceController {

	@RequestMapping("{siteAddress}")
	public String entrance(@PathVariable String siteAddress,HttpServletRequest req){
		System.err.println(siteAddress);
		return "redirect:/mobile-homepage/view";
	}
	
}
