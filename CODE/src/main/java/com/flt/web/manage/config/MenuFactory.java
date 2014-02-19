package com.flt.web.manage.config;

import java.util.ArrayList;
import java.util.List;

import com.flt.common.config.Configuration;
import com.flt.web.manage.config.dto.LeftMenu;

public class MenuFactory {

	public static List<LeftMenu> buildMenus(){
		
		List<LeftMenu> menus=new ArrayList<>();
		
		menus.add(new LeftMenu("menu1","http://www.cdu.edu.cn",false));
		menus.add(new LeftMenu("channel", Configuration.DB_SERVER_DOMAIN+"channel/view", false));
		menus.add(new LeftMenu("menu", Configuration.DB_SERVER_DOMAIN+"menu/list", false));
		menus.add(new LeftMenu("brand", Configuration.DB_SERVER_DOMAIN+"brand/view", false));
		menus.add(new LeftMenu("passage", Configuration.DB_SERVER_DOMAIN+"passage/view", false));
		menus.add(new LeftMenu("article", Configuration.DB_SERVER_DOMAIN+"article/view", false));
		menus.add(new LeftMenu("服务承诺", Configuration.DB_SERVER_DOMAIN+"serviceAndPromise/view", false));
		menus.add(new LeftMenu("订单", Configuration.DB_SERVER_DOMAIN+"order/view", false));
		menus.add(new LeftMenu("评论", Configuration.DB_SERVER_DOMAIN+"comment/view", false));
		
		return menus;
	}
}
