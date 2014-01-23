package com.flt.service.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.common.log.Assert;
import com.flt.common.log.LogEnum;
import com.flt.dao.client.MenuMapper;
import com.flt.dao.model.Menu;
import com.flt.dao.model.MenuExample;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.menu.IMenuService;
import com.flt.web.module.views.menu.MenuDTO;

@Service
public class MenuService extends BaseService implements IMenuService {

	
	@Override
	public List<MenuDTO> listMenus() {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		MenuExample ex=new MenuExample();
		ex.createCriteria().andPIdIsNull();
		List<Menu> rootMenus=m.selectByExample(ex);
		
		LogEnum logEnum=Assert.notNull(rootMenus, "not found any menu", this.getClass());
		List<MenuDTO> menuDTOs=null;
		if(LogEnum.SUCCESS.equals(logEnum)){
			menuDTOs=loadAllMenus(rootMenus);
		}
		return menuDTOs;
	}

	private List<MenuDTO> loadAllMenus(List<Menu> rootMenus) {
		// TODO Auto-generated method stub
		List<MenuDTO> dtos=new ArrayList<>();
		for(Menu m:rootMenus){
			MenuDTO dto=new MenuDTO();
			List<Menu> childMenus=this.loadChildMenus(m);
			List<MenuDTO> childDtos=this.loadAllMenus(childMenus);
			dto.setChildMenus(childDtos);
			dto.setMenu(m);
			dtos.add(dto);
		}
		
		return dtos;
	}

	private List<Menu> loadChildMenus(Menu root) {
		// TODO Auto-generated method stub
		List<Menu> childMenus=null;
		
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		MenuExample ex=new MenuExample();
		ex.createCriteria().andPIdEqualTo(root.getId());
		childMenus=m.selectByExample(ex);
		
		return childMenus;
	}

}
