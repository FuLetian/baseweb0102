package com.flt.web.module.views.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Channel;
import com.flt.dao.model.User;
import com.flt.web.common.service.ICommonUserService;

@View(template="component/menu/{theme}/menuView.ftl")
public class MenuView extends BaseView {
	
	@Autowired
	private IMenuService service;
	
	@Autowired
	private ICommonUserService userServivce;

	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		User user=userServivce.loadUserById(userId);
		
		List<Channel> list=service.listChannels(this.userId);
		
		List<MenuDTO> menus=service.listMenus(this.userId);
		
		root.put("menus", menus);
		root.put("user_domain", user.getDomain());
		root.put("header_menu_channels", list);
	}
}
