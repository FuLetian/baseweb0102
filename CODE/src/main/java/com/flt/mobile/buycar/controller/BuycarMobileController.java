package com.flt.mobile.buycar.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.constant.KeyConstant;
import com.flt.dao.model.Consumer;
import com.flt.dao.model.Order;
import com.flt.service.consumer.IConsumerCommonService;
import com.flt.service.order.IOrderCommonService;
import com.flt.web.itf.dto.AritcleCountDTO;
import com.flt.web.itf.service.IBuycarService;

@Controller
@RequestMapping("mobile-buycar")
public class BuycarMobileController {
	
	@Autowired
	private IBuycarService service;
	@Autowired
	private IConsumerCommonService consumerCommonService;
	@Autowired
	private IOrderCommonService orderCommonService;

	@RequestMapping("view")
	public String view(Integer userId,Model model,HttpServletRequest req){
		
		Set<AritcleCountDTO> list=(Set<AritcleCountDTO>) req.getSession().getAttribute(KeyConstant.SESSION_BUY_CAR_KEY);
		if(list==null){
			list=new HashSet<>();
		}
		
		model.addAttribute("list", list);
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/buycar/view.ftl";
	}
	
	@RequestMapping("orderView")
	public String orderView(Integer userId,Integer cId,String moneyTotal,Model model,HttpServletRequest req){
		
		Consumer loginConsumer=consumerCommonService.loadConsumerById(cId);
		if(loginConsumer==null){
			loginConsumer=(Consumer) req.getSession().getAttribute(KeyConstant.SESSION_LOGIN_USER);
		}
		
		if(loginConsumer!=null){
			model.addAttribute("loginConsumer", loginConsumer);
		}
		
		model.addAttribute("moneyTotal", moneyTotal);
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/buycar/order-view.ftl";
	}
	
	@RequestMapping("addOrder")
	@ResponseBody
	public String addOrder(Integer cId,String name,String email,Integer phone,String address,String remark,HttpServletRequest req){
		JSONObject o=new JSONObject();
		
		Date now=new Date();
		Set<AritcleCountDTO> list=(Set<AritcleCountDTO>) req.getSession().getAttribute(KeyConstant.SESSION_BUY_CAR_KEY);
		if(list==null){
			list=new HashSet<>();
		}
		
		for(AritcleCountDTO dto:list){
			Order order=new Order();
			
			order.setArticleId(dto.getArticle().getId());
			order.setcDt(now);
			order.setConsumerId(cId);
			order.setCount(dto.getCount());
			order.setRemark(remark);
			order.setRunStatus(0);
			order.setTourAddress(address);
			order.setTourEmail(email);
			order.setTourName(name);
			order.setTourPhone(phone.toString());
			order.setuDt(now);
			
			orderCommonService.saveOrder(order);
			
		}
		o.put("result", true);
		
		return o.toString();
	}
	
	@RequestMapping("order-success")
	public String orderSuccess(Integer userId,Model model,HttpServletRequest req){
		
		req.getSession().removeAttribute(KeyConstant.SESSION_BUY_CAR_KEY);
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/buycar/order-success-view.ftl";
	}
}
