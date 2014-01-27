package com.flt.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.config.Configuration;
import com.flt.common.constant.KeyConstant;
import com.flt.dao.model.User;
import com.flt.web.common.service.ICommonUserService;

public class BaseController {
	
	@Autowired
	private ICommonUserService userService;
	
	protected String getBasePath(HttpServletRequest req){
		String basePath=req.getContextPath()+"/";
		return basePath;
	}
	
	protected User getUser(HttpServletRequest req){
		
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		
		User user=(User) req.getSession().getAttribute(KeyConstant.SESSION_BELOANG_USER_ID_KEY);
		if(user==null){
			user=userService.loadUserByDomain(basePath);
		}
		
		if(user==null){
			System.err.println("didn`t find the user of base path values :"+basePath);
		}
		
		return user;
		
	}
}
