package com.flt.web.sample.views;

import org.springframework.ui.Model;

import com.flt.web.base.BaseView;
import com.flt.web.sample.views.model.Menu;

public class WorkspaceView extends BaseView {
	
	private String mainMenuId;

	public WorkspaceView(Model model) {
		super(model, WorkspaceView.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rander() {
		// TODO Auto-generated method stub
		Menu parentMenu=MenuView.menuMap.get(mainMenuId);
		
		model.addAttribute("workspaceView_parentMenu", parentMenu);
	}

	public String getMainMenuId() {
		return mainMenuId;
	}

	public void setMainMenuId(String mainMenuId) {
		this.mainMenuId = mainMenuId;
	}

}
