package com.flt.common.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	protected String getBasePath(HttpServletRequest req){
		String basePath=req.getContextPath()+"/";
		return basePath;
	}
}
