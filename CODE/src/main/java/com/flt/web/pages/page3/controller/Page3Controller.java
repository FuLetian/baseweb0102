package com.flt.web.pages.page3.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.config.Configuration;
import com.flt.common.controller.BaseController;
import com.flt.common.view.PageWrapper;
import com.flt.web.module.views.footer.FooterView;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.module.views.passage.LeftNavigationView;
import com.flt.web.module.views.passage.MainPassageView;
import com.flt.web.module.views.staticstate.LocationView;
import com.flt.web.pages.page3.view.Page3View;

/**
 * @description text page
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("page3")
public class Page3Controller extends BaseController{

	@Autowired private Page3View page3View;
	@Autowired private MenuView menuView;
	@Autowired private FooterView footerView;
	@Autowired private LeftNavigationView leftNavigationView;
	@Autowired private LocationView locationView;
	@Autowired private MainPassageView mainPassageView;
	private PageWrapper buildPage(Integer num,Integer userId){
		Assert.notNull(num);
		
		page3View.setUserId(userId);
		
		mainPassageView.setNum(num);
		
		PageWrapper p=new PageWrapper(page3View, new HashMap<String,Object>(),userId);
		
		p.addView(footerView);
		p.addView(menuView);
		p.addView(leftNavigationView);
		p.addView(locationView);
		p.addView(mainPassageView);
		
		return p;
	}
	
	@RequestMapping("view")
	private String view(Integer passageNum,Model model,HttpServletRequest req){
		PageWrapper p=this.buildPage(passageNum,this.getUserId(req));
		
		model.addAllAttributes(p.getRoot());
		
		return p.getPageTemplate();
	}
}
