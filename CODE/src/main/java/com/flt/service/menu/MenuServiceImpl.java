package com.flt.service.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.PMenuMapper;
import com.flt.dao.model.PMenu;
import com.flt.dao.model.PMenuExample;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.menu.MenuDTO;
import com.flt.web.pages.controller.IPage1MenuService;

@Service
public class MenuServiceImpl extends BaseService implements IPage1MenuService {

	@Override
	public List<MenuDTO> listMenuDTO() {
		// TODO Auto-generated method stub
		PMenuMapper mapper=this.getSqlSession().getMapper(PMenuMapper.class);
		List<MenuDTO> dtos=new ArrayList<>();
		
		PMenuExample ex=new PMenuExample();
		ex.createCriteria().andPMenuIdIsNull();
		List<PMenu> parentMenus=mapper.selectByExample(ex);
		
		if(!parentMenus.isEmpty()){
			for(PMenu menu:parentMenus){
				MenuDTO dto=coverToMenuDTO(menu);
				dtos.add(dto);
			}
		}
		return dtos;
	}

	private MenuDTO coverToMenuDTO(PMenu menu) {
		// TODO Auto-generated method stub
		List<MenuDTO> childDtos=new ArrayList<>();
		MenuDTO dto=new MenuDTO();
		dto.setMenu(menu);
		
		PMenuMapper mapper=this.getSqlSession().getMapper(PMenuMapper.class);
		PMenuExample ex=new PMenuExample();
		ex.createCriteria().andPMenuIdEqualTo(menu.getMenu_id());
		List<PMenu> childMenuList=mapper.selectByExample(ex);
		
		if(!childMenuList.isEmpty()){
			for(PMenu item:childMenuList){
				MenuDTO childDto=coverToMenuDTO(item);
				childDtos.add(childDto);
			}
		}
		
		dto.setChildMenuList(childDtos);
		
		return dto;
	}

}
