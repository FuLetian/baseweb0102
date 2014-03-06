package com.flt.mobile.consumer.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.constant.KeyConstant;
import com.flt.dao.model.Consumer;
import com.flt.service.article.IArticleCommonService;
import com.flt.web.itf.service.IConsumerITFService;

@Controller
@RequestMapping("mobile-consumer")
public class ConsumerMobileController {
	
	@Autowired
	private IConsumerITFService service;
	@Autowired
	private IArticleCommonService articleCommonService;

	@RequestMapping("login-view")
	public String loginView(Integer userId,Model model,HttpServletRequest req){
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/consumer/login-view.ftl";
	}
	/**
	 * 
	 * @param userId
	 * @param targetUrl 登陆成功后跳转的url
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("login-page")
	public String loginPage(Integer userId,String targetUrl,Model model,HttpServletRequest req){
		
		model.addAttribute("targetUrl", targetUrl);
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/consumer/login-page.ftl";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String login(String account,String pwd,HttpServletRequest req){
		
		
		Consumer o=service.login(account, pwd);
		
		JSONObject jo=new JSONObject();
		
		if(o==null){
			jo.put("result", false);
		}else{
			
			req.getSession().setAttribute(KeyConstant.SESSION_LOGIN_USER, o);
			
			jo.put("result", true);
			jo.put("consumerId", o.getId());
			jo.put("account", o.getAccount());
			jo.put("userId", o.getUserId());
		}
		return jo.toString();
	}
	
}
