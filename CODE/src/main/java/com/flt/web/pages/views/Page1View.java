package com.flt.web.pages.views;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.flt.web.base.BaseView;
import com.flt.web.module.views.category.HotSaleCategoryView;
import com.flt.web.module.views.channel.ChannelView;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.module.views.passage.PassageView;
import com.flt.web.module.views.product.HomepageProductView;

public class Page1View extends BaseView {
	
	private MenuView menuView;
	
	private ChannelView channelView;
	
	private HotSaleCategoryView categoryView;
	
	private PassageView passageView;
	
	private HomepageProductView homepageProductView;

	public Page1View(Model model) {
		super(model, Page1View.class);
		// TODO Auto-generated constructor stub
		model.addAttribute("page1View", this);
	}
	
	public Page1View(HttpServletRequest req,Model model) {
		this(model);
		
		model.addAttribute("basePath", req.getContextPath()+"/");
	}

	@Override
	public void rander() {
		// TODO Auto-generated method stub

	}

	public HotSaleCategoryView getCategoryView() {
		return categoryView;
	}

	public void setCategoryView(HotSaleCategoryView categoryView) {
		this.categoryView = categoryView;
	}

	public PassageView getPassageView() {
		return passageView;
	}

	public void setPassageView(PassageView passageView) {
		this.passageView = passageView;
	}

	public ChannelView getChannelView() {
		return channelView;
	}

	public void setChannelView(ChannelView channelView) {
		this.channelView = channelView;
	}

	public HomepageProductView getHomepageProductView() {
		return homepageProductView;
	}

	public void setHomepageProductView(HomepageProductView homepageProductView) {
		this.homepageProductView = homepageProductView;
	}

	public MenuView getMenuView() {
		return menuView;
	}

	public void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}

}
