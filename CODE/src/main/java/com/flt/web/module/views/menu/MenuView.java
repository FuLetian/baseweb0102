package com.flt.web.module.views.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;

@View(template="component/menu/{theme}/menuView.ftl")
public class MenuView extends BaseView {
	
	@Autowired
	private IMenuService service;

	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		List<MenuDTO> menus=service.listMenus(userId);
		
		root.put("menus", menus);
	}
}
