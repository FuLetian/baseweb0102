package com.flt.web.manage.brand.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("brand")
public class BrandController {

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/brand/view.ftl";
	}
}
