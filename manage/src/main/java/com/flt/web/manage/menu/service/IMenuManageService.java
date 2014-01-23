package com.flt.web.manage.menu.service;

import java.util.List;

import com.flt.dao.model.Menu;

public interface IMenuManageService {

	List<Menu> listAllMenus();
	
	void onSaveOrUpdateMenu(Menu menu);
	
	void deleteMenuById(Integer id);
	
	Menu findMenuById(Integer id);
}
