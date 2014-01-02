package com.flt.web.base;

import java.io.File;

import org.springframework.ui.Model;

public abstract class BaseView {

	private String template;
	
	public Model model;
	
	public BaseView(Model model,Class<? extends BaseView> clz) {
		// TODO Auto-generated constructor stub
		this.model=model;
		this.template=this.findTemplate(clz);
		
	}

	public abstract void rander();

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
	
	public String findTemplate(Class<? extends BaseView> clz){
		String name=clz.getName();
		
		String name2=name.replace(".", File.separator);
		
		return name2+".ftl";
	}
}
