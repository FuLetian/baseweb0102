package com.flt.web.module.views.menu;

import java.util.List;

import com.flt.dao.model.PMenu;

public class MenuDTO {

	private PMenu menu;
	
	private List<MenuDTO> childMenuList;

	public List<MenuDTO> getChildMenuList() {
		return childMenuList;
	}

	public void setChildMenuList(List<MenuDTO> childMenuList) {
		this.childMenuList = childMenuList;
	}

	public PMenu getMenu() {
		return menu;
	}

	public void setMenu(PMenu menu) {
		this.menu = menu;
	}
	
}
