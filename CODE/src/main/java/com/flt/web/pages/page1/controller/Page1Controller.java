package com.flt.web.pages.page1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.controller.BaseController;
import com.flt.common.freemarker.htmlAbled;
import com.flt.common.view.PageWrapper;
import com.flt.service.freemarker.FreemarkerService;
import com.flt.web.module.views.channel.ChannelView;
import com.flt.web.pages.page1.view.Page1View;

@Controller
@RequestMapping(value="page1")
public class Page1Controller extends BaseController implements htmlAbled{
	
	@Autowired private Page1View page;
	@Autowired private ChannelView channelView;
	private PageWrapper buildPage(){
		Map<String, Object> root=new HashMap<>();
		
		PageWrapper p=new PageWrapper(page,root);
		p.addView(channelView);
		
		return p;
	}

	@RequestMapping(value="view")
	public String view(Model model){
		
		PageWrapper p=this.buildPage();
		
		model.addAllAttributes(p.getRoot());
		return p.getPageTemplate();
	}

	@Autowired private FreemarkerService freemarkerService;
	@Override
	@RequestMapping("html")
	@ResponseBody
	public String createHtml(HttpServletRequest req) {
		// TODO Auto-generated method stub
		PageWrapper p=this.buildPage();
		
		freemarkerService.flush(req, p.getTargetHtmlName(), p.getPageTemplate(), p.getRoot());
		
		return "success";
	}
}
