package com.flt.web.pages.page6.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.controller.BaseController;
import com.flt.common.freemarker.HTMLAbled;
import com.flt.common.utils.JSONDateValueProcessor;
import com.flt.common.view.PageWrapper;
import com.flt.dao.model.User;
import com.flt.service.freemarker.FreemarkerService;
import com.flt.web.common.service.ICommonUserService;
import com.flt.web.module.views.footer.FooterView;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.pages.page6.OrderArticleDTO;
import com.flt.web.pages.page6.service.IPage6OrderService;
import com.flt.web.pages.page6.view.Page6View;

/**
 * <p>[已买到的商品]</p>
 * @author Administrator
 *
 */
@Controller
@RequestMapping("page6")
public class Page6Controller extends BaseController implements HTMLAbled {
	
	@Autowired
	private IPage6OrderService service;

	@Autowired
	private Page6View page6View;
	
	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		PageWrapper p=this.buildPage(this.getUser(req));
		
		model.addAllAttributes(p.getRoot());
		model.addAttribute("basePath", this.getBasePath(req));
		return p.getPageTemplate();
		
	}
	
	@Autowired
	private MenuView menuView;
	@Autowired
	private FooterView footerView;

	private PageWrapper buildPage(User user) {
		// TODO Auto-generated method stub
		
		PageWrapper p=new PageWrapper(page6View, new HashMap<String,Object>(), user);
		
		p.addView(menuView);
		p.addView(footerView);
		return p;
	}
	
	@RequestMapping("getOrderByRunStatus")
	@ResponseBody
	public String getOrderByRunStatus(Integer runStatus,Integer consumerId,Model model,HttpServletRequest req){
		
		List<OrderArticleDTO> list=service.listOrderArticleDTOsByRunStatus(runStatus,consumerId);
		
		JsonConfig config=new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JSONDateValueProcessor());
		return JSONArray.fromObject(list,config).toString();
	}
	@RequestMapping("setComment")
	@ResponseBody
	public String setComment(String content,Integer grade,Integer consumerId,Integer articleId,HttpServletRequest req){
		
		service.addCommentForArticle(content, grade, consumerId, articleId, this.getUser(req).getId());
		
		return "SUCCESS";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer orderId){
		
		service.deleteOrder(orderId);
		
		return "SUCCESS";
	}
	
	@RequestMapping("setRunStatus")
	@ResponseBody
	public String setRunStatus(Integer orderId,Integer runStatus){
		
		service.setRunStatus(orderId, runStatus);
		
		return "SUCCESS";
	}

	@Autowired private ICommonUserService userService;
	@Autowired private FreemarkerService freemarkerService;
	@Override
	public String createHtml(HttpServletRequest req, Integer userId) {
		// TODO Auto-generated method stub
		User user=userService.loadUserById(userId);
		PageWrapper p=this.buildPage(user);
		Map<String, Object> root=p.getRoot();
		root.put("basePath",user.getDomain());
		freemarkerService.flush(req,userId,"page6.html", p.getPageTemplate(),root);
		return null;
	}
}
