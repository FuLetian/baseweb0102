package com.flt.mobile.homepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.constant.KeyConstant;
import com.flt.service.access.IAccessLogService;
import com.flt.service.article.IArticleCommonService;
import com.flt.service.context.BasewebApplicationContext;
import com.flt.service.user.IUserCommonService;
import com.flt.web.module.views.menu.IMenuService;
import com.flt.web.module.views.menu.MenuDTO;

@Controller
@RequestMapping("mobile-homepage")
public class MobileHomepageController {
	
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IArticleCommonService articleCommonService;
	@Autowired
	private IUserCommonService userCommonService;
	@Autowired
	private IAccessLogService logService;

	@RequestMapping("view")
	public String view(Model model,Integer cId,Integer userId,Integer type,HttpServletRequest req){
		
		Assert.notNull(userId,"userId");
		
		if(req.getSession().getAttribute(KeyConstant.SESSION_ACCESS_LOG_KEY)==null){
			
			String ip=req.getRemoteAddr();
			
			logService.addLog(ip,cId==null?null:Integer.valueOf(cId),userId==null?null:Integer.valueOf(userId));
			
			req.getSession().setAttribute(KeyConstant.SESSION_ACCESS_LOG_KEY, "");
		}
		
		
		if(type==null){
			type=0;
		}
		
		model.addAttribute("articles", articleCommonService.listArticleByTypeFlag(type));
		model.addAttribute("user", userCommonService.loadUserById(userId));
		return processModel(1,model,req);
	}
	/**
	 *  商品list
	 * @param userId
	 * @param type 0-人气,1-最新,
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("list-view")
	public String listHomepageArticleView(Integer userId,Integer type,Model model,HttpServletRequest req){
		
		model.addAttribute("articles", articleCommonService.listArticleByTypeFlag(type));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/homepage/article-list-view.ftl";
	}

	private String processModel(Integer userId,Model model, HttpServletRequest req) {
		// TODO Auto-generated method stub
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/homepage/view.ftl";
	}
	
	@RequestMapping("menus")
	@ResponseBody
	public String menus(Integer userId){
		List<MenuDTO> list=menuService.listMenus(userId);
		
		JSONObject o=new JSONObject();
		
		o.put("menus", list);
		
		return o.toString();
	}
}
