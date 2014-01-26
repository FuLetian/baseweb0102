package com.flt.common.controller;

import javax.servlet.http.HttpServletRequest;

import com.flt.common.config.Configuration;

public class BaseController {
	
	protected String getBasePath(HttpServletRequest req){
		String basePath=req.getContextPath()+"/";
		return basePath;
	}
	
	protected Integer getUserId(HttpServletRequest req){
		
		return Configuration.TMP_SESSION_USER_ID;
	}
}
