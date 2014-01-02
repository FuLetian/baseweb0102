package com.flt.web.sample.views;

import org.springframework.ui.Model;

import com.flt.web.base.BaseView;

public class FrameView extends BaseView{
	
	private TopView topView;
	
	private FooterView footerView;
	
	private MenuView menuView;
	
	public FrameView(Model model) {
		// TODO Auto-generated constructor stub
		super(model,FrameView.class);
		model.addAttribute("frameView", this);
	}
	
	@Override
	public void rander() {
		// TODO Auto-generated method stub
		
	}

	public TopView getTopView() {
		return topView;
	}

	public void setTopView(TopView topView) {
		this.topView = topView;
	}

	public FooterView getFooterView() {
		return footerView;
	}

	public void setFooterView(FooterView footerView) {
		this.footerView = footerView;
	}

	public MenuView getMenuView() {
		return menuView;
	}

	public void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}

}
