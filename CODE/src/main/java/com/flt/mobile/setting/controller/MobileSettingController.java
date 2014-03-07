package com.flt.mobile.setting.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mobile-setting")
public class MobileSettingController {

	@RequestMapping("view")
	public String view(Integer userId,Integer cId,Model model,HttpServletRequest req){
		
		if(cId==null){
			cId=0;
		}
		
		model.addAttribute("cId", cId);
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/setting/view.ftl";
	}
}
