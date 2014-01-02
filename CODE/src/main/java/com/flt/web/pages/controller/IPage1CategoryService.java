package com.flt.web.pages.controller;

import java.util.List;

import com.flt.dao.model.Category;

public interface IPage1CategoryService {

	List<Category> listCategoriesByType(int type);
}

