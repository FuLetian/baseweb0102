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
	
	protected Integer getUserId(HttpServletRequest req){
		
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		
		Integer userId=(Integer) req.getSession().getAttribute(KeyConstant.SESSION_BELOANG_USER_ID_KEY);
		if(userId==null){
			User user=userService.loadUserByDomain(basePath);
			
			if(user!=null){
				userId=user.getId();
			}else{
				System.err.println("没有找到user,basePath="+basePath);
				userId=Configuration.TMP_SESSION_USER_ID;
			}
		}
		
		return userId;
		
	}
}
