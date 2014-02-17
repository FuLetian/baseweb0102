package com.flt.web.pages.page5.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.controller.BaseController;
import com.flt.common.freemarker.HTMLAbled;
import com.flt.common.view.PageWrapper;
import com.flt.dao.model.User;
import com.flt.service.freemarker.FreemarkerService;
import com.flt.web.common.service.ICommonUserService;
import com.flt.web.module.views.buycar.BuycarListInPage5View;
import com.flt.web.module.views.footer.FooterView;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.pages.page5.view.Page5View;

/**
 * <p>购物车列表page</p>
 * @author Administrator
 *
 */
@Controller
@RequestMapping("page5")
public class Page5Controller extends BaseController implements HTMLAbled{

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		PageWrapper p=this.buildPage(this.getUser(req));
		
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
	@Autowired
	private FooterView footerView;
	
	private PageWrapper buildPage(User user){
		
		PageWrapper p=new PageWrapper(page5View, new HashMap<String, Object>(),user);
		p.addView(menuView);
		p.addView(buycarListInPage5View);
		p.addView(footerView);
		
		return p;
	}

	@Autowired private ICommonUserService userService;
	@Autowired private FreemarkerService freemarkerService;
	@Override
	public String createHtml(HttpServletRequest req, Integer userId) {
		// TODO Auto-generated method stub
		User user=userService.loadUserById(userId);
		
		PageWrapper p=this.buildPage(user);
		Map<String, Object> root=p.getRoot();
		root.put("basePath","../");
		freemarkerService.flush(req,userId,"page5.html", p.getPageTemplate(),root);
		
		return null;
	}
}
