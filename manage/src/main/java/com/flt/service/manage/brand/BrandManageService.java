package com.flt.service.manage.brand;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.BrandMapper;
import com.flt.dao.model.Brand;
import com.flt.dao.model.BrandExample;
import com.flt.service.manage.base.BaseManageService;
import com.flt.web.manage.brand.service.IBrandManageService;
import com.flt.web.module.views.brand.IBrandService;

@Service
public class BrandManageService extends BaseManageService implements IBrandService ,IBrandManageService{

	@Override
	public List<Brand> listbBrandsByType(Integer type) {
		// TODO Auto-generated method stub
		
		BrandMapper m=getSqlSession().getMapper(BrandMapper.class);
		BrandExample ex=new BrandExample();
		ex.createCriteria().andTypeEqualTo(type);
		
		return m.selectByExample(ex);
	}

	@Override
	public List<Brand> listAllBrands(Integer userId) {
		// TODO Auto-generated method stub
		BrandMapper m=getSqlSession().getMapper(BrandMapper.class);
		BrandExample ex=new BrandExample();
		ex.createCriteria().andUserIdEqualTo(userId);
		
		return m.selectByExample(ex);
	}

	@Override
	public void saveOrUpdateBrand(Integer id, String name, Integer idx,Integer userId) {
		// TODO Auto-generated method stub
		BrandMapper m=getSqlSession().getMapper(BrandMapper.class);
		
		if(id!=null&&id.toString().equals("0")){
			id=null;
		}
		
		Brand b=new Brand();
		b.setcDt(new Date());
		b.setId(id);
		b.setIdx(idx);
		b.setName(name);
		b.setuDt(new Date());
		b.setType(0);
		b.setUserId(userId);
		
		if(id==null){
			m.insert(b);
		}else{
			m.updateByPrimaryKey(b);
		}
	}

	@Override
	public void deleteBrand(Integer id) {
		// TODO Auto-generated method stub
		BrandMapper m=getSqlSession().getMapper(BrandMapper.class);
		
		m.deleteByPrimaryKey(id);
	}

}
