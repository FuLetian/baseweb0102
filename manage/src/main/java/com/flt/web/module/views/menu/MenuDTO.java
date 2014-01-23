package com.flt.web.module.views.menu;

import java.util.List;

import com.flt.dao.model.Menu;

public class MenuDTO {

	private Menu menu;
	private List<MenuDTO> childMenus;
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public List<MenuDTO> getChildMenus() {
		return childMenus;
	}
	public void setChildMenus(List<MenuDTO> childMenus) {
		this.childMenus = childMenus;
	}
}
