package com.flt.mobile.homepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.web.module.views.menu.IMenuService;
import com.flt.web.module.views.menu.MenuDTO;

@Controller
@RequestMapping("mobile-homepage")
public class MobileHomepageController {
	
	@Autowired
	private IMenuService menuService;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		return processModel(1,model,req);
	}

	private String processModel(Integer userId,Model model, HttpServletRequest req) {
		// TODO Auto-generated method stub
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/homepage/view.ftl";
	}
	
	@RequestMapping("menus")
	@ResponseBody
	public String menus(Integer userId){
		List<MenuDTO> list=menuService.listMenus(userId);
		
		JSONObject o=new JSONObject();
		
		o.put("menus", list);
		
		return o.toString();
	}
}
