package com.flt.web.pages.page3.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.controller.BaseController;
import com.flt.common.freemarker.HTMLAbled;
import com.flt.common.view.PageWrapper;
import com.flt.dao.model.User;
import com.flt.service.freemarker.FreemarkerService;
import com.flt.web.common.service.ICommonUserService;
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
public class Page3Controller extends BaseController implements HTMLAbled{

	@Autowired private Page3View page3View;
	@Autowired private MenuView menuView;
	@Autowired private FooterView footerView;
	@Autowired private LeftNavigationView leftNavigationView;
	@Autowired private LocationView locationView;
	@Autowired private MainPassageView mainPassageView;
	private PageWrapper buildPage(Integer num,User user){
		Assert.notNull(num);
		
		page3View.setUserId(user.getId());
		
		mainPassageView.setNum(num);
		
		PageWrapper p=new PageWrapper(page3View, new HashMap<String,Object>(),user);
		
		p.addView(footerView);
		p.addView(menuView);
		p.addView(leftNavigationView);
		p.addView(locationView);
		p.addView(mainPassageView);
		
		return p;
	}
	
	@RequestMapping("view")
	private String view(Integer passageNum,Model model,HttpServletRequest req){
		PageWrapper p=this.buildPage(passageNum,this.getUser(req));
		
		model.addAllAttributes(p.getRoot());
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		return p.getPageTemplate();
	}

	@Autowired private FreemarkerService freemarkerService;
	@Autowired private ICommonUserService userService;
	
	@Override
	public String createHtml(HttpServletRequest req, Integer userId) {
		// TODO Auto-generated method stub
		
		User user=userService.loadUserById(userId);
		
		for(int i=1;i<18;i++){
			PageWrapper p=this.buildPage(i,user);
			Map<String, Object> root=p.getRoot();
			root.put("basePath","../");
			freemarkerService.flush(req,userId,"page3-passageNum-"+i+".html", p.getPageTemplate(),root);
		}
		return null;
	}
}
