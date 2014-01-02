package com.flt.web.module.views.product;

import java.util.List;

import org.springframework.ui.Model;

import com.flt.dao.model.Product;
import com.flt.web.base.BaseView;

public class HomepageProductView extends BaseView {
	
	private List<Product> productList;

	public HomepageProductView(Model model) {
		super(model, HomepageProductView.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rander() {
		// TODO Auto-generated method stub
		model.addAttribute("productList", productList);
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
