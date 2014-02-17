package com.flt.web.manage.homepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.controller.BaseController;
import com.flt.web.manage.config.MenuFactory;
import com.flt.web.manage.config.dto.LeftMenu;
import com.flt.web.manage.homepage.service.IHomepageService;

@Controller
@RequestMapping("homepage")
public class HomepageController extends BaseController{
	
	@Autowired
	private IHomepageService service;

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
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/homepage/header.ftl";
	}
	
	@RequestMapping("workspaceView")
	public String workspaceView(Model model,HttpServletRequest req){
		return "manage/homepage/workspace.ftl";
	}
	
	@RequestMapping("staticweb")
	@ResponseBody
	public String staticweb(){
		JSONObject j=new JSONObject();
		
		j.put("result", true);
		
		return j.toString();
	}
	
}
