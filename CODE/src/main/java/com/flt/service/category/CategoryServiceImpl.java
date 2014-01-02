package com.flt.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.CategoryMapper;
import com.flt.dao.model.Category;
import com.flt.dao.model.CategoryExample;
import com.flt.service.base.BaseService;
import com.flt.web.pages.controller.IPage1CategoryService;

@Service
public class CategoryServiceImpl extends BaseService implements IPage1CategoryService {

	
	
	@Override
	public List<Category> listCategoriesByType(int type) {
		// TODO Auto-generated method stub
		
		CategoryMapper mapper=getSqlSession().getMapper(CategoryMapper.class);
		
		CategoryExample ex=new CategoryExample();
		ex.createCriteria().andCategoryTypeEqualTo(type);
		
		return mapper.selectByExample(ex);
	}

}
