package com.flt.web.module.views.staticstate;

import org.springframework.context.annotation.Scope;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;

@View(template="component/staticstate/{theme}/locationView.ftl")
@Scope(value="prototype")
public class LocationView extends BaseView {

	private String title="DEFAULT";
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		root.put("locationView_title", title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
