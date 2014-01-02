package com.flt.web.module.views.category;

import java.util.List;

import org.springframework.ui.Model;

import com.flt.dao.model.Category;
import com.flt.web.base.BaseView;

public class HotSaleCategoryView extends BaseView {
	
	private List<Category> categories;

	public HotSaleCategoryView(Model model) {
		super(model, HotSaleCategoryView.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rander() {
		// TODO Auto-generated method stub

	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
