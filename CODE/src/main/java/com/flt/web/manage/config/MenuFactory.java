package com.flt.web.manage.config;

import java.util.ArrayList;
import java.util.List;

import com.flt.web.manage.config.dto.LeftMenu;

public class MenuFactory {

	public static List<LeftMenu> buildMenus(){
		
		List<LeftMenu> menus=new ArrayList<>();
		
		menus.add(new LeftMenu("menu1","http://www.cdu.edu.cn",false));
		menus.add(new LeftMenu("channel", "/baseweb/channel/view", false));
		menus.add(new LeftMenu("menu", "/baseweb/menu/list", false));
		menus.add(new LeftMenu("brand", "/baseweb/brand/view", false));
		menus.add(new LeftMenu("passage", "/baseweb/passage/view", false));
		menus.add(new LeftMenu("article", "/baseweb/article/view", false));
		menus.add(new LeftMenu("服务承诺", "/baseweb/serviceAndPromise/view", false));
		menus.add(new LeftMenu("订单", "/baseweb/order/view", false));
		menus.add(new LeftMenu("评论", "/baseweb/comment/view", false));
		
		return menus;
	}
}
