package com.flt.controller.wechat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.controller.BaseController;
import com.flt.dao.model.Business;
import com.flt.service.base.BusinessService;

@Controller
@RequestMapping("wechat-business")
public class BusinessController extends BaseController{
	
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping("page-login")
	public String pageLogin(Model model,HttpServletRequest req){
		
		return this.sendFTL("wechat/business/login.ftl", model, req);
	}
	
	@RequestMapping("page-regist")
	public String pageRegist(Model model,HttpServletRequest req){
		
		return this.sendFTL("wechat/business/regist.ftl", model, req);
	}
	
	@ResponseBody
	@RequestMapping("action-business-regist")
	public String actionBusinessRegist(Business business, Model model,HttpServletRequest req){
		
		String str = this.businessService.registBusinisess(business);
		if(str == null){
			return this.sendJSON(true, null);
		}else{
			return this.sendJSON(false, str);
		}
	}
	
}
