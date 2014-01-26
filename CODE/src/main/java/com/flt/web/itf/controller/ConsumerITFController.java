package com.flt.web.itf.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.dao.model.Consumer;
import com.flt.web.itf.service.IConsumerITFService;

@Controller
@RequestMapping("consumerITF")
public class ConsumerITFController {
	
	@Autowired
	private IConsumerITFService service;

	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public String login(String account,String pwd,Model model,HttpServletRequest req){
		
		Consumer o=service.login(account, pwd);
		
		JSONObject jo=new JSONObject();
		
		if(o==null){
			jo.put("result", false);
		}else{
			jo.put("result", true);
			jo.put("consumerId", o.getId());
			jo.put("account", o.getAccount());
			jo.put("userId", o.getUserId());
		}
		return jo.toString();
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public String register(Integer userId,String realName,String pwd1,String pwd2,String phoneNum,String address,String email,String thumbnailPath){
		
		Assert.notNull(userId);
		Assert.notNull(realName);
		Assert.notNull(pwd2);
		Assert.notNull(pwd1);
		Assert.notNull(phoneNum);
		Assert.notNull(address);
		Assert.notNull(email);
		
		JSONObject jo=new JSONObject();

		if(!pwd1.equals(pwd2)){
			jo.put("result", false);
			jo.put("code", "0");//密码不匹配
			return jo.toString();
		}
		
		Consumer o=service.register(userId,realName,pwd1,phoneNum,address,email,thumbnailPath);
		
		jo.put("result", true);
		jo.put("consumerId", o.getId());
		jo.put("account", o.getAccount());
		jo.put("userId", o.getUserId());
		return jo.toString();
	}
}
