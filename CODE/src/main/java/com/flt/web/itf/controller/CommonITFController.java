package com.flt.web.itf.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.constant.KeyConstant;
import com.flt.dao.model.Comment;
import com.flt.web.itf.dto.ConsumerCommentDTO;
import com.flt.web.itf.service.ICommentITFService;

/**
 *<p>功能:对外通信controller</p>
 *<p>comment获取与新建</p>
 *<p>Copyright:Copyright(c)2013</p>
 *<p>Company:sky</p>
 *@author 付乐天
 *@version 1.0 */

@Controller
@RequestMapping("commentITF")
public class CommonITFController {
	
	@Autowired
	private ICommentITFService service;

	@RequestMapping("getComments")
	@ResponseBody
	public String getComments(Integer articleId,Integer userId,Model model,HttpServletRequest req){
		
		Assert.notNull(userId);
		Assert.notNull(articleId);
		
		List<ConsumerCommentDTO> list=service.listConsumerCommentsByArticleId(articleId, userId);
		
		return JSONArray.fromObject(list).toString();
	}
	
	@RequestMapping("pushSessionBuyCarItem")
	@ResponseBody
	public String pushSessionBuyCar(Integer articleId,Integer userId,Model model,HttpServletRequest req){
		Set<Integer> articleIds=(Set<Integer>) req.getSession().getAttribute(KeyConstant.SESSION_BUY_CAR_KEY);
		if(articleIds==null){
			articleIds=new HashSet<>();
		}
		
		articleIds.add(articleId);
		
		req.getSession().setAttribute(KeyConstant.SESSION_BUY_CAR_KEY, articleIds);
		
		
		return "SUCCESS";
	}
}
