package com.flt.web.manage.channel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.config.Configuration;
import com.flt.dao.model.Channel;
import com.flt.web.manage.channel.service.IChannelManageService;

@Controller
@RequestMapping("channel")
public class ChannelController {
	
	@Autowired
	private IChannelManageService service;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		List<Channel> list=service.findAllChannel(Configuration.TMP_SESSION_USER_ID);
		
		model.addAttribute("channels", JSONArray.fromObject(list).toString());
		model.addAttribute("basePath", req.getContextPath()+"/");
		
		return "manage/channel/view.ftl";
	}
	
	@RequestMapping("onSaveOrUpdateChannel")
	@ResponseBody
	public String onSaveOrUpdateChannel(Channel channel,Model model,HttpServletRequest req){
		
		channel.setUserId(Configuration.TMP_SESSION_USER_ID);
		service.saveOrUpdateChannel(channel);
		
		return "SUCCESS";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer channelId,Model model,HttpServletRequest req){
		service.deleteChannelById(channelId);
		return "SUCCESS";
	}
}
