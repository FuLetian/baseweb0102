package com.flt.web.pages.page5.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.controller.BaseController;
import com.flt.common.view.PageWrapper;
import com.flt.web.module.views.buycar.BuycarListInPage5View;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.pages.page5.view.Page5View;

/**
 * <p>购物车列表page</p>
 * @author Administrator
 *
 */
@Controller
@RequestMapping("page5")
public class Page5Controller extends BaseController{

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		PageWrapper p=this.buildPage(this.getUserId(req));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAllAttributes(p.getRoot());
		return p.getPageTemplate();
	}
	
	@Autowired
	private Page5View page5View;
	@Autowired
	private MenuView menuView;
	@Autowired
	private BuycarListInPage5View buycarListInPage5View;
	
	private PageWrapper buildPage(Integer userId){
		
		PageWrapper p=new PageWrapper(page5View, new HashMap<String, Object>(),userId);
		p.addView(menuView);
		p.addView(buycarListInPage5View);
		
		return p;
	}
}
