package com.flt.web.manage.comment.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.utils.JSONDateValueProcessor;
import com.flt.dao.model.Comment;
import com.flt.service.comment.ICommentCommonService;
import com.flt.web.itf.dto.ConsumerCommentDTO;


@Controller
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
	private ICommentCommonService commentCommonService;

	
	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		model.addAttribute("userId", 1);
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/comment/view.ftl";
	}
	
	@RequestMapping("getItems")
	@ResponseBody
	public String getItems(Integer userId){
		
		List<ConsumerCommentDTO> list=this.commentCommonService.listConsumerCommentDTOsByUserId(1);
		
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JSONDateValueProcessor());
		return JSONArray.fromObject(list, jsonConfig).toString();
	}
	
	@RequestMapping("setContent")
	@ResponseBody
	public String setContent(Integer commentId,String replyContent){
		
		Comment c=this.commentCommonService.loadCommentById(commentId);
		c.setReplyContent(replyContent);
		this.commentCommonService.updateComment(c);
		
		JSONObject o=new JSONObject();
		o.put("result", true);
		
		return o.toString();
	}
}
