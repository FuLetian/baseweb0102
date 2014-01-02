package com.flt.web.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.service.admin.AdminService;
import com.flt.web.sample.views.FooterView;
import com.flt.web.sample.views.FrameView;
import com.flt.web.sample.views.MenuView;
import com.flt.web.sample.views.TopView;
import com.flt.web.sample.views.WorkspaceView;

@Controller
@RequestMapping(value="sample")
public class SampleController {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping(value="page")
	public String page(Model model){
		
		FrameView frameView=new FrameView(model);
		
		TopView topView=new TopView(model);
		topView.rander();
		frameView.setTopView(topView);
		
		
		FooterView footerView=new FooterView(model);
		footerView.rander();
		frameView.setFooterView(footerView);
		
		MenuView menuView=new MenuView(model);
		menuView.rander();
		frameView.setMenuView(menuView);
		
		return frameView.getTemplate();
	}
	
	@RequestMapping(value="loadWorkspace/{id}")
	public String loadWorkspace(@PathVariable("id")String id,Model model){
		
		WorkspaceView workspaceView=new WorkspaceView(model);
		workspaceView.setMainMenuId(id);
		workspaceView.rander();
		
		return workspaceView.getTemplate();
	}
}
