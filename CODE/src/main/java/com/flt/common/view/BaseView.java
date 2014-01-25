package com.flt.common.view;

import java.util.Map;


public abstract class BaseView {

	protected Map<String, Object> root;
	
	protected Integer userId;
	
	public BaseView() {
		// TODO Auto-generated constructor stub
	}
	
	public void setRoot(Map<String, Object> root) {
		// TODO Auto-generated constructor stub
		this.root=root;
	}
	
	public void render(){}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
