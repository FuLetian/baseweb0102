package com.flt.web.module.views.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.config.Configuration;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Brand;

@View(template="component/brand/{theme}/brandInPage1View.ftl")
public class BrandInPage1View extends BaseView {

	@Autowired
	private IBrandService service;
	
	private Integer brandType=0;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		List<Brand> list=service.listbBrandsByType(brandType,Configuration.TMP_SESSION_USER_ID);
		
		root.put("brands", list);
		
	}

	public IBrandService getService() {
		return service;
	}

	public void setService(IBrandService service) {
		this.service = service;
	}

	public Integer getBrandType() {
		return brandType;
	}

	public void setBrandType(Integer brandType) {
		this.brandType = brandType;
	}
	
}
