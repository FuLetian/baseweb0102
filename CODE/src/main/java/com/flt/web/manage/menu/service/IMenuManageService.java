package com.flt.web.manage.menu.service;

import java.util.List;

import com.flt.dao.model.Menu;

public interface IMenuManageService {

	List<Menu> listAllMenus(Integer userId);
	
	void onSaveOrUpdateMenu(Menu menu,Integer userId);
	
	void deleteMenuById(Integer id);
	
	Menu findMenuById(Integer id);
}
