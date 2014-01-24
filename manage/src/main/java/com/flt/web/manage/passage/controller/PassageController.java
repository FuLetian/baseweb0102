package com.flt.web.manage.passage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.dao.model.Passage;
import com.flt.web.manage.passage.service.IPassageManageService;


@Controller
@RequestMapping("passage")
public class PassageController {
	
	@Autowired
	private IPassageManageService service;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/passage/view.ftl";
	}
	
	@RequestMapping(value="onPreviewPassage",method=RequestMethod.POST)
	public String onPreviewPassage(Integer id,String text,Model model,HttpServletRequest req){
		
		model.addAttribute("id", id);
		model.addAttribute("text", text);
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/passage/preview.ftl";
	}
	
	@RequestMapping(value="onUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String onUpdate(Integer id,String text,Model model,HttpServletRequest req){
		
		service.saveOrUpdatePassage(id, text);
		
		return "SUCCESS";
	}
	
	@RequestMapping(value="getPassage")
	@ResponseBody
	public String getPassage(Integer id,Model model,HttpServletRequest req){
		
		Passage p=service.loadPassageById(id);
		return p==null?"内容为空":p.getText();
	}
	
}
