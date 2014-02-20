package com.flt.web.manage.staticimg;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("staticimg")
public class StaticImgController {

	@RequestMapping("view")
	public String staticimg(Model model,HttpServletRequest req){
		
		return "manage/staticimg/view";
	}
}
