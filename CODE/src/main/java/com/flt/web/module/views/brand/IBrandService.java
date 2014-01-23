package com.flt.web.module.views.brand;

import java.util.List;

import com.flt.dao.model.Brand;

public interface IBrandService {

	List<Brand> listbBrandsByType(Integer type);
}
