package com.flt.web.manage.brand.service;

import java.util.List;

import com.flt.dao.model.Brand;

public interface IBrandManageService {

	List<Brand> listAllBrands();
	
	void saveOrUpdateBrand(Integer id,String name,Integer idx);
	
	void deleteBrand(Integer id);
}
