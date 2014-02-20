package com.flt.web.manage.brand.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.config.Configuration;
import com.flt.dao.model.Brand;
import com.flt.web.manage.brand.service.IBrandManageService;

@Controller
@RequestMapping("brand")
public class BrandController {
	
	@Autowired
	private IBrandManageService service;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		List<Brand> list=service.listAllBrands(Configuration.TMP_SESSION_USER_ID);
		
		model.addAttribute("brands", JSONArray.fromObject(list).toString());
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/brand/view.ftl";
	}
	
	@RequestMapping(value="onSaveOrUpdate")
	@ResponseBody
	public String saveOrUpdate(Integer id,String name,Integer idx,String thumbnail,Model model,HttpServletRequest req){
		
		service.saveOrUpdateBrand(id, name, idx,thumbnail,Configuration.TMP_SESSION_USER_ID);
		return "SUCCESS";
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public String delete(Integer id,Model model,HttpServletRequest req){
		
		service.deleteBrand(id);
		return "SUCCESS";
	}
	
	
}
