package com.flt.service.brand;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.BrandMapper;
import com.flt.dao.model.Brand;
import com.flt.dao.model.BrandExample;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.brand.IBrandService;

@Service
public class BrandService extends BaseService implements IBrandService {

	@Override
	public List<Brand> listbBrandsByType(Integer type,Integer userId) {
		// TODO Auto-generated method stub
		
		BrandMapper m=getSqlSession().getMapper(BrandMapper.class);
		BrandExample ex=new BrandExample();
		ex.createCriteria().andTypeEqualTo(type)
		.andUserIdEqualTo(userId);
		
		return m.selectByExample(ex);
	}

}
