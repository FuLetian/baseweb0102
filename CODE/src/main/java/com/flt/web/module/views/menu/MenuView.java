package com.flt.web.module.views.menu;

import java.util.List;

import org.springframework.ui.Model;

import com.flt.web.base.BaseView;

public class MenuView extends BaseView{
	
	private List<MenuDTO> menuDTOs;

	public MenuView(Model model) {
		super(model, MenuView.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rander() {
		// TODO Auto-generated method stub
		model.addAttribute("menuList", menuDTOs);
	}

	public List<MenuDTO> getMenuDTOs() {
		return menuDTOs;
	}

	public void setMenuDTOs(List<MenuDTO> menuDTOs) {
		this.menuDTOs = menuDTOs;
	}

}
