package com.flt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.ui.Model;

import com.google.gson.JsonObject;
import com.qiniu.util.Auth;

public class BaseController {

	static private Auth auth = null;
	
	public BaseController(){
		if(auth == null){
			auth = Auth.create("W1OJ4v_OACIWMsVTShLwcdKlAMKZFs95B6xzuUr8", "4ERQoUxOrlmgPUVpqXrhqPmDIZz0KfpaFGnRWdK1");
		}
	}
	
	protected String sendFTL(String ftlName,Model model,HttpServletRequest req){
		
		String basePath=req.getContextPath()+"/";
		model.addAttribute("basePath", basePath);
		model.addAttribute("qnToken", auth.uploadToken("tchm"));
		return ftlName;
	}
	
	protected String sendJSON(Boolean success,String errMsg){
		Map<String, String> map = new HashMap<>();
		map.put("success", success?"1":"0");
		map.put("errMsg", errMsg);
		JSONObject jo = new JSONObject(map);
		
		return jo.toString();
	}
}
