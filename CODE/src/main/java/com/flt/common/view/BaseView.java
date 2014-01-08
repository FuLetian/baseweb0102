package com.flt.common.view;

import java.util.Map;


public abstract class BaseView {

	protected Map<String, Object> root;
	
	public BaseView() {
		// TODO Auto-generated constructor stub
	}
	
	public void setRoot(Map<String, Object> root) {
		// TODO Auto-generated constructor stub
		this.root=root;
	}
	
	public void render(){}
}
