package com.flt.web.manage.config;

import java.util.ArrayList;
import java.util.List;

import com.flt.common.config.Configuration;
import com.flt.web.manage.config.dto.LeftMenu;

public class MenuFactory {

	public static List<LeftMenu> buildMenus(){
		
		List<LeftMenu> menus=new ArrayList<>();
		
		menus.add(new LeftMenu("menu1","http://www.cdu.edu.cn",false));
		menus.add(new LeftMenu("channel", Configuration.getProp("db.server.domain")+"channel/view", false));
		menus.add(new LeftMenu("menu", Configuration.getProp("db.server.domain")+"menu/list", false));
		menus.add(new LeftMenu("brand", Configuration.getProp("db.server.domain")+"brand/view", false));
		menus.add(new LeftMenu("passage", Configuration.getProp("db.server.domain")+"passage/view", false));
		menus.add(new LeftMenu("article", Configuration.getProp("db.server.domain")+"article/view", false));
		menus.add(new LeftMenu("服务承诺", Configuration.getProp("db.server.domain")+"serviceAndPromise/view", false));
		menus.add(new LeftMenu("订单", Configuration.getProp("db.server.domain")+"order/view", false));
		menus.add(new LeftMenu("评论", Configuration.getProp("db.server.domain")+"comment/view", false));
		menus.add(new LeftMenu("关于我们", Configuration.getProp("db.server.domain")+"user-manage/view", false));
		menus.add(new LeftMenu("统计", Configuration.getProp("db.server.domain")+"charts/view", false));
		
		return menus;
	}
}
