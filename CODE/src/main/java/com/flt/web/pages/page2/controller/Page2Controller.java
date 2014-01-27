package com.flt.web.pages.page2.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.controller.BaseController;
import com.flt.common.view.PageWrapper;
import com.flt.dao.model.User;
import com.flt.web.module.views.article.ArticleInPage2View;
import com.flt.web.module.views.footer.FooterView;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.module.views.staticstate.LocationView;
import com.flt.web.pages.page2.view.Page2View;

/**
 * @description Grid show article
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="page2")
public class Page2Controller extends BaseController{

	@Autowired private MenuView menuView;
	@Autowired private FooterView footerView;
	@Autowired private ArticleInPage2View articleInPage2View;
	@Autowired private LocationView locationView;
	@Autowired private Page2View page2View;
	public PageWrapper buildPage(User user){
		
		PageWrapper p=new PageWrapper(page2View, new HashMap<String,Object>(),user);
		
		p.addView(locationView);
		
		return p;
	}
	
	@RequestMapping("view")
	public String view(Integer brandId,Integer channelId,Integer menuId,String priceRange,String discountRange,Model model,HttpServletRequest req){
		
		articleInPage2View.setBrandId(brandId);
		articleInPage2View.setChannelId(channelId);
		articleInPage2View.setDiscountRange(discountRange);
		articleInPage2View.setMenuId(menuId);
		articleInPage2View.setPriceRange(priceRange);
		
		PageWrapper p=this.buildPage(this.getUser(req));
		
		p.addView(menuView);
		p.addView(footerView);
		p.addView(articleInPage2View);
		
		model.addAllAttributes(p.getRoot());
		return p.getPageTemplate();
	}
}
