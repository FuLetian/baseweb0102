package com.flt.web.module.views.passage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.flt.common.annotation.View;
import com.flt.common.config.Configuration;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Passage;

@View(template="component/passage/{theme}/mainPassageView.ftl")
public class MainPassageView extends BaseView {
	
	@Autowired
	private IPassageService service;

	private Integer num;
	
	private Integer userId;

	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		Assert.notNull(userId);
		
		Passage p=service.findPassageByNum(num,userId);
		
		root.put("passage", p);
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
}
