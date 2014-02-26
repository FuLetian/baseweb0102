package com.flt.service.menu;

import java.util.List;

import com.flt.dao.model.Menu;

public interface IMenuCommonService {

	List<Menu> listRootMenus(Integer userId);
	
	List<Menu> listChildMenuByParentMenuid(Integer menuId);
}
