package com.flt.web.manage.menu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.dao.model.Menu;
import com.flt.web.manage.menu.service.IMenuManageService;

@Controller
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private IMenuManageService iMenuManageService;

	@RequestMapping("list")
	public String list(Model model,HttpServletRequest req){
		
		List<Menu> menus=iMenuManageService.listAllMenus();
		JSONArray ja=JSONArray.fromObject(menus);
		
		model.addAttribute("menus", ja.toString());
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/menu/list.ftl";
	}
	
	@RequestMapping("getMenuEditorView")
	public String getMenuEditorView(Integer menuId,Model model,HttpServletRequest req){
		
		List<Menu> menus=iMenuManageService.listAllMenus();
		
		if(menuId!=null){
			Menu menu=iMenuManageService.findMenuById(menuId);
			model.addAttribute("menu", menu);
		}
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("menus", menus);
		return "manage/menu/editorView.ftl";
	}
	
	@RequestMapping("onSaveOrUpdateMenu")
	@ResponseBody
	public String onSaveOrUpdateMenu(Menu menu,Model model,HttpServletRequest req){
		
		iMenuManageService.onSaveOrUpdateMenu(menu);
		
		return "SUCCESS";
	}
	@RequestMapping("removeItem")
	@ResponseBody
	public String deleteMenuById(Integer id,Model model,HttpServletRequest req){
		
		iMenuManageService.deleteMenuById(id);
		
		return "SUCCESS";
	}
}
