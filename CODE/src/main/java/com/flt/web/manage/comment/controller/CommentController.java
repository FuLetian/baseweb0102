package com.flt.web.manage.comment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("comment")
public class CommentController {

	
	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/comment/view.ftl";
	}
}
