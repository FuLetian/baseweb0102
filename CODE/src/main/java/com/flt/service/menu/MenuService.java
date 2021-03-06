package com.flt.service.menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.common.log.Assert;
import com.flt.common.log.LogEnum;
import com.flt.dao.client.ChannelMapper;
import com.flt.dao.client.MenuMapper;
import com.flt.dao.model.Channel;
import com.flt.dao.model.ChannelExample;
import com.flt.dao.model.Menu;
import com.flt.dao.model.MenuExample;
import com.flt.service.base.BaseService;
import com.flt.web.manage.menu.service.IMenuManageService;
import com.flt.web.module.views.menu.IMenuService;
import com.flt.web.module.views.menu.MenuDTO;

@Service
public class MenuService extends BaseService implements IMenuService,IMenuManageService,IMenuCommonService {

	
	@Override
	public List<MenuDTO> listMenus(Integer userId) {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		MenuExample ex=new MenuExample();
		ex.createCriteria().andPIdIsNull()
		.andUserIdEqualTo(userId);
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

	@Override
	public List<Channel> listChannels(Integer userId) {
		// TODO Auto-generated method stub
		
		ChannelMapper m=this.getSqlSession().getMapper(ChannelMapper.class);
		ChannelExample ex=new ChannelExample();
		ex.createCriteria().andUserIdEqualTo(userId);
		ex.setOrderByClause("idx DESC");
		return m.selectByExample(ex);
	}

	@Override
	public List<Menu> listAllMenus(Integer userId) {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		MenuExample ex=new MenuExample();
		ex.createCriteria().andUserIdEqualTo(userId);
		return m.selectByExample(ex);
	}

	@Override
	public void onSaveOrUpdateMenu(Menu menu, Integer userId) {
		// TODO Auto-generated method stub
		
		menu.setUserId(userId);
		
		if(menu.getcDt()==null){
			menu.setcDt(new Date());
		}
		
		if(menu.getuDt()==null){
			menu.setuDt(new Date());
		}
		
		if(menu.getpId().intValue()==0){
			menu.setpId(null);
		}
		
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		m.insert(menu);
	}

	@Override
	public void deleteMenuById(Integer id) {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		
		MenuExample ex=new MenuExample();
		ex.createCriteria().andPIdEqualTo(id);
		List<Menu> childMenus=m.selectByExample(ex);
		if(childMenus!=null&&!childMenus.isEmpty()){
			for(Menu item:childMenus){
				this.deleteMenuById(item.getId());
			}
		}
		
		m.deleteByPrimaryKey(id);
	}

	@Override
	public Menu findMenuById(Integer id) {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		return m.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> listRootMenus(Integer userId) {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		MenuExample ex=new MenuExample();
		ex.createCriteria().andPIdIsNull()
		.andUserIdEqualTo(userId);
		List<Menu> rootMenus=m.selectByExample(ex);
		return rootMenus;
	}

	@Override
	public List<Menu> listChildMenuByParentMenuid(Integer menuId) {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		MenuExample ex=new MenuExample();
		ex.createCriteria().andPIdEqualTo(menuId);
		List<Menu> menus=m.selectByExample(ex);
		return menus;
	}

}
