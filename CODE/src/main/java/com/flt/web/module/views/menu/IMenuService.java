package com.flt.web.module.views.menu;

import java.util.List;

import com.flt.dao.model.Channel;

public interface IMenuService {

	List<MenuDTO> listMenus(Integer userId);
	
	List<Channel> listChannels(Integer userId);
}
