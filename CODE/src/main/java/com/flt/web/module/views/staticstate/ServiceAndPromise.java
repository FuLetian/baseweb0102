package com.flt.web.module.views.staticstate;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.constant.FieldConstant;
import com.flt.common.view.BaseView;

@View(template="component/staticstate/{theme}/serviceAndPromise.ftl")
public class ServiceAndPromise extends BaseView {
	
	@Autowired
	private IServiceAndPromiseService service;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		root.put("static_text1", service.findResourceById(FieldConstant.resource.id.ServiceAndPromise_RES_1));
		root.put("static_text2", service.findResourceById(FieldConstant.resource.id.ServiceAndPromise_RES_2));
		root.put("static_text3", service.findResourceById(FieldConstant.resource.id.ServiceAndPromise_RES_3));
	}
}
