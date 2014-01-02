package com.flt.web.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.web.module.views.category.HotSaleCategoryView;

@Controller
@RequestMapping(value="module")
public class ModuleController {

	public String categoryView(Model model){
		HotSaleCategoryView categoryView=new HotSaleCategoryView(model);
		
		return categoryView.getTemplate();
	}
}
