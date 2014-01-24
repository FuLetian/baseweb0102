package com.flt.web.manage.serviceAndPromise.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.constant.FieldConstant;
import com.flt.dao.model.Resource;
import com.flt.web.manage.serviceAndPromise.service.IserviceAndPromiseManageService;


@Controller
@RequestMapping("serviceAndPromise")
public class ServiceAndPromiseController {
	
	@Autowired
	private IserviceAndPromiseManageService service;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		model.addAttribute("res1",FieldConstant.resource.id.ServiceAndPromise_RES_1);
		model.addAttribute("res2",FieldConstant.resource.id.ServiceAndPromise_RES_2);
		model.addAttribute("res3",FieldConstant.resource.id.ServiceAndPromise_RES_3);
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/serviceAndPromise/view.ftl";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public String update(Resource resource,Model model,HttpServletRequest req){
		
		service.saveOrUpdateResource(resource);
		
		return "SUCCESS";
	}
	
	@RequestMapping("getText")
	@ResponseBody
	public String getText(Integer id,Model model,HttpServletRequest req){
		
		Resource r=service.loadResourceById(id);
		
		return r==null?"内容为空":r.getText();
	}
}
