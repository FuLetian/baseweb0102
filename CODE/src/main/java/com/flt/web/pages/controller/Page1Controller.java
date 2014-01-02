package com.flt.web.pages.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.FieldConstant;
import com.flt.web.module.views.category.HotSaleCategoryView;
import com.flt.web.module.views.channel.ChannelView;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.module.views.passage.PassageView;
import com.flt.web.module.views.product.HomepageProductView;
import com.flt.web.pages.views.Page1View;

@Controller
@RequestMapping(value="page1")
public class Page1Controller{
	
	@Autowired
	private IPage1CategoryService categoryService;
	
	@Autowired
	private IPage1PassageService passageService;
	
	@Autowired
	private IPage1ChannelService channelService;
	
	@Autowired
	private IPage1ProductService productService;
	
	@Autowired
	private IPage1MenuService menuService;

	@RequestMapping(value="page")
	public String page(Integer channelType,Model model,HttpServletRequest req){
		
		if(channelType==null){
			channelType=0;
		}
		
		Page1View page1=new Page1View(req,model);
		
		MenuView menuView=new MenuView(model);
		menuView.setMenuDTOs(menuService.listMenuDTO());
		menuView.rander();
		page1.setMenuView(menuView);
		
		ChannelView channelView=new ChannelView(model);
		channelView.setChannelList(channelService.listChannels());
		channelView.rander();
		page1.setChannelView(channelView);
		
		HotSaleCategoryView categoryView=new HotSaleCategoryView(model);
		categoryView.setCategories(categoryService.listCategoriesByType(channelType));
		page1.setCategoryView(categoryView);
		
		PassageView passageView=new PassageView(model);
		passageView.setPassages(passageService.listPassageByType(channelType));
		page1.setPassageView(passageView);
		
		HomepageProductView homepageProductView=new HomepageProductView(model);
		homepageProductView.setProductList(productService.listProductByChannelType(channelType));
		homepageProductView.rander();
		page1.setHomepageProductView(homepageProductView);
		
		
		return page1.getTemplate();
	}
}
