package com.flt.mobile.menu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.service.menu.IMenuCommonService;
import com.flt.web.module.views.menu.IMenuService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("mobile-menu")
public class MenuMobileController {
	
	@Autowired
	private IMenuCommonService menuCommonService;
	@Autowired
	private IMenuService menuService;

	@RequestMapping("view")
	public String view(Integer userId,Model model,HttpServletRequest req){
		
		model.addAttribute("menus", menuService.listMenus(userId));
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/menu/view.ftl";
	}
	
	@RequestMapping("secondMenu")
	public String secondMenu(Integer userId,Integer rootMenuId,Model model,HttpServletRequest req){
		
		model.addAttribute("userId", userId);
		model.addAttribute("menus", menuCommonService.listChildMenuByParentMenuid(rootMenuId));
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "mobile/menu/secondMenu.ftl";
	}
}
