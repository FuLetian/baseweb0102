package com.flt.web.pages.page1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.controller.BaseController;
import com.flt.common.freemarker.htmlAbled;
import com.flt.common.log.Assert;
import com.flt.common.view.PageWrapper;
import com.flt.dao.model.Channel;
import com.flt.service.freemarker.FreemarkerService;
import com.flt.web.module.views.article.ArticleInPage1View;
import com.flt.web.module.views.brand.BrandInPage1View;
import com.flt.web.module.views.channel.ChannelView;
import com.flt.web.module.views.channel.IChannelService;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.pages.page1.view.Page1View;

@Controller
@RequestMapping(value="page1")
public class Page1Controller extends BaseController implements htmlAbled{
	
	@Autowired private Page1View page;
	@Autowired private ChannelView channelView;
	@Autowired private ArticleInPage1View articleView;
	@Autowired private BrandInPage1View brandInPage1View;
	@Autowired private MenuView menuView;
	private PageWrapper buildPage(Integer channelId){
		
		Assert.notNull(channelId,"channelId is unable to be null",this.getClass());
		
		PageWrapper p=new PageWrapper(page,new HashMap<String,Object>());
		
		articleView.setChannelId(channelId);
		p.addView(articleView);
		p.addView(channelView);
		p.addView(menuView);
		
		brandInPage1View.setBrandType(Page1View.BRAND_TYPE);
		p.addView(brandInPage1View);
		
		return p;
	}

	@RequestMapping(value="view")
	public String view(Integer channelId,Model model,HttpServletRequest req){
		if(channelId==null){
			channelId=0;
		}
		
		PageWrapper p=this.buildPage(channelId);
		
		model.addAllAttributes(p.getRoot());
		model.addAttribute("basePath",req.getServletPath());
		return p.getPageTemplate();
	}

	@Autowired private FreemarkerService freemarkerService;
	@Autowired private IChannelService channelService;
	@Override
	@RequestMapping("html")
	@ResponseBody
	public String createHtml(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		List<Channel> channels=channelService.listChannels();
		for(Channel c:channels){
			PageWrapper p=this.buildPage(c.getId());
			Map<String, Object> root=p.getRoot();
			root.put("basePath", req.getServletPath());
			freemarkerService.flush(req, p.getTargetHtmlName(), p.getPageTemplate(),root);
		}
		
		return "success";
	}
}
