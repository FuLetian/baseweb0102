package com.flt.web.module.views.passage;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Passage;

@View(template="component/passage/{theme}/mainPassageView.ftl")
public class MainPassageView extends BaseView {
	
	@Autowired
	private IPassageService service;

	private Integer passageId;

	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		Passage p=service.findPassageById(passageId);
		
		root.put("passage", p);
	}

	public Integer getPassageId() {
		return passageId;
	}

	public void setPassageId(Integer passageId) {
		this.passageId = passageId;
	}
	
	
	
	
}
