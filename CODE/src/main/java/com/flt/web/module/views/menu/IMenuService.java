package com.flt.web.module.views.menu;

import java.util.List;

public interface IMenuService {

	List<MenuDTO> listMenus(Integer userId);
}
