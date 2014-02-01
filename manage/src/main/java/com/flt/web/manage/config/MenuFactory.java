package com.flt.web.manage.config;

import java.util.ArrayList;
import java.util.List;

import com.flt.web.manage.config.dto.LeftMenu;

public class MenuFactory {

	public static List<LeftMenu> buildMenus(){
		
		List<LeftMenu> menus=new ArrayList<>();
		
		menus.add(new LeftMenu("menu1","http://www.cdu.edu.cn",false));
		menus.add(new LeftMenu("channel", "/basemanage/channel/view", false));
		menus.add(new LeftMenu("menu", "/basemanage/menu/list", false));
		menus.add(new LeftMenu("brand", "/basemanage/brand/view", false));
		menus.add(new LeftMenu("passage", "/basemanage/passage/view", false));
		menus.add(new LeftMenu("article", "/basemanage/article/view", false));
		menus.add(new LeftMenu("服务承诺", "/basemanage/serviceAndPromise/view", false));
		menus.add(new LeftMenu("订单", "/basemanage/order/view", false));
		menus.add(new LeftMenu("评论", "/basemanage/comment/view", false));
		
		return menus;
	}
}
