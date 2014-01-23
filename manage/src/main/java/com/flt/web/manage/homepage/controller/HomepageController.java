package com.flt.web.manage.homepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.controller.BaseController;
import com.flt.web.manage.config.MenuFactory;
import com.flt.web.manage.config.dto.LeftMenu;

@Controller
@RequestMapping("homepage")
public class HomepageController extends BaseController{

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/homepage/view.ftl";
	}
	
	@RequestMapping("menuView")
	public String menuView(Model model,HttpServletRequest req){
		
		List<LeftMenu> menus=MenuFactory.buildMenus();
		JSONArray j=JSONArray.fromObject(menus);
		
		model.addAttribute("menus", j.toString());
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/homepage/menu.ftl";
	}
	
	@RequestMapping("headerView")
	public String headerView(Model model,HttpServletRequest req){
		return "manage/homepage/header.ftl";
	}
	
	@RequestMapping("workspaceView")
	public String workspaceView(Model model,HttpServletRequest req){
		return "manage/homepage/workspace.ftl";
	}
	
}
