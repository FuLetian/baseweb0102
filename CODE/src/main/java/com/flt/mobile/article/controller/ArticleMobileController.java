package com.flt.mobile.article.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.constant.FieldConstant;
import com.flt.common.constant.KeyConstant;
import com.flt.dao.model.Order;
import com.flt.service.article.IArticleCommonService;
import com.flt.service.comment.ICommentCommonService;
import com.flt.service.order.IOrderCommonService;

@Controller
@RequestMapping("mobile-article")
public class ArticleMobileController {
	
	@Autowired
	private IArticleCommonService articleCommonService;
	@Autowired
	private ICommentCommonService commentCommonService;
	@Autowired
	private IOrderCommonService orderCommonService;

	/**
	 * listView for article
	 * @param userId
	 * @param menuId
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("view")
	public String view(Integer userId,Integer menuId,Model model,HttpServletRequest req){
		
		model.addAttribute("articles", articleCommonService.listArticleByMenuId(menuId));
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/article/view.ftl";
	}
	
	@RequestMapping("details")
	public String details(Integer userId,Integer articleId,Model model,HttpServletRequest req){
		
		model.addAttribute("imgs", articleCommonService.listArticleImgByArticleId(articleId));
		model.addAttribute("props", articleCommonService.listArticlePropertyByArticleId(articleId));
		model.addAttribute("article", articleCommonService.loadArticleById(articleId));
		
		Integer commentSize=commentCommonService.listConsumerCommentsByArticleId(articleId, userId).size();
		model.addAttribute("commentSize", commentSize);
		
		model.addAttribute("collections", orderCommonService.listOrderByRunStatus(FieldConstant.order.runStatus.collections, articleId).size());
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/article/details.ftl";
	}
	
	@RequestMapping("details-info")
	public String detailsInfo(Integer userId,Integer articleId,Model model,HttpServletRequest req){

		model.addAttribute("imgs", articleCommonService.listArticleImgByArticleId(articleId));
		model.addAttribute("props", articleCommonService.listArticlePropertyByArticleId(articleId));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/article/details-info.ftl";
	}
	
	@RequestMapping("comments-list")
	public String commentsList(Integer userId,Integer articleId,Model model,HttpServletRequest req){

		model.addAttribute("comments", commentCommonService.listConsumerCommentsByArticleId(articleId,userId));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/article/comments.ftl";
	}
	
	@RequestMapping("clip")
	@ResponseBody
	public String clip(Integer articleId,HttpServletRequest req){
		JSONObject o=new JSONObject();
		
		Boolean cliped=(Boolean) req.getSession().getAttribute(KeyConstant.SESSION_CLIP_KEY+articleId);
		if(cliped==null){
			articleCommonService.addClip(articleId);
			req.getSession().setAttribute(KeyConstant.SESSION_CLIP_KEY+articleId, true);
			o.put("result", true);
		}else{
			o.put("result", false);
		}
		
		return o.toString();
	}
	
	@RequestMapping("collect")
	@ResponseBody
	public String collect(Order order){
		
		Assert.notNull(order.getArticleId(),"null parameter articleId");
		Assert.notNull(order.getConsumerId(),"null parameter consumerId");
		Assert.notNull(order.getRunStatus(),"null parameter runStatus");
		
		JSONObject o=new JSONObject();
		
		Boolean result=orderCommonService.saveOrUpdateOrder(order);
		
		o.put("result", result);
		
		return o.toString();
	}
}
