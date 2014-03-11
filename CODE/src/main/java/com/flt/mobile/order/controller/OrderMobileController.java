package com.flt.mobile.order.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.constant.FieldConstant;
import com.flt.dao.model.Comment;
import com.flt.dao.model.Order;
import com.flt.service.comment.ICommentCommonService;
import com.flt.service.order.IOrderCommonService;

@Controller
@RequestMapping("mobile-order")
public class OrderMobileController {
	
	@Autowired
	private IOrderCommonService orderCommonService;
	@Autowired
	private ICommentCommonService commentCommonService;

	@RequestMapping("view")
	public String view(Integer userId,Integer cId,Model model,HttpServletRequest req){
		Assert.notNull(userId, "userId");
		Assert.notNull(cId, "cId");
		
		model.addAttribute("makeOrderJustNow", orderCommonService.countOrderByRunStatus(FieldConstant.order.runStatus.makeOrderJustNow, cId));
		model.addAttribute("dealingOrder", orderCommonService.countOrderByRunStatus(FieldConstant.order.runStatus.dealingOrder, cId));
		model.addAttribute("postingOrder", orderCommonService.countOrderByRunStatus(FieldConstant.order.runStatus.postingOrder, cId));
		model.addAttribute("successedDeal", orderCommonService.countOrderByRunStatus(FieldConstant.order.runStatus.successedDeal, cId));
		model.addAttribute("collections", orderCommonService.countOrderByRunStatus(FieldConstant.order.runStatus.collections, cId));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/order/view.ftl";
	}
	
	@RequestMapping("order-list")
	public String orderList(Integer userId,Integer runStatus,Integer cId,Model model,HttpServletRequest req){
		
		model.addAttribute("list", orderCommonService.listCOnsumerOrderByRunStatus(runStatus, cId));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/order/order-list.ftl";
	}
	@RequestMapping("details")
	public String details(Integer userId,Integer orderId,Integer cId,Model model,HttpServletRequest req){
		
		model.addAttribute("orderArticle", orderCommonService.loadOrderArticleByOrderId(orderId,cId));
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/order/details.ftl";
	}
	
	@RequestMapping(value="set-star",method=RequestMethod.POST)
	@ResponseBody
	public String setStarByOrderId(Integer star,Integer orderId,Integer userId){
		JSONObject o=new JSONObject();
		
		Order order=this.orderCommonService.loadOrderById(orderId);
		
		Comment c=this.commentCommonService.loadCommnetByConsuerIdArticleId(order.getConsumerId(), order.getArticleId());
		if(c==null){
			Date now=new Date();
			c=new Comment();
			c.setArticleId(order.getArticleId());
			c.setcDt(now);
			c.setConsumerId(order.getConsumerId());
			c.setContent("");
			c.setGrade(star);
			c.setReplyContent("");
			c.setuDt(now);
			c.setUserId(userId);
			this.commentCommonService.saveComment(c);
		}else{
			c.setuDt(new Date());
			c.setGrade(star);
			this.commentCommonService.updateComment(c);
		}
		
		
		
		o.put("result", true);
		return o.toString();
	}
	@RequestMapping(value="set-comment",method=RequestMethod.POST)
	@ResponseBody
	public String setComment(Integer articleId,Integer cId,Integer userId,String comment){
		JSONObject o=new JSONObject();
		Date now=new Date();
		
		Comment c=this.commentCommonService.loadCommnetByConsuerIdArticleId(cId,articleId);
		if(c==null){
			c=new Comment();
			c.setArticleId(articleId);
			c.setcDt(now);
			c.setConsumerId(cId);
			c.setContent(comment);
			c.setGrade(0);
			c.setuDt(now);
			c.setUserId(userId);
			this.commentCommonService.saveComment(c);
		}else{
			c.setContent(comment);
			this.commentCommonService.updateComment(c);
		}
		
		o.put("result", true);
		
		return o.toString();
	}
}
