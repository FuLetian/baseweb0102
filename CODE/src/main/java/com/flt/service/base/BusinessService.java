package com.flt.service.base;

import org.springframework.stereotype.Service;

import com.flt.dao.client.BusinessMapper;
import com.flt.dao.client.ExampleMapper;
import com.flt.dao.model.Business;
import com.flt.dao.model.BusinessExample;
import com.flt.dao.model.ExampleExample;

@Service
public class BusinessService extends BaseService {

	public String test(){
		ExampleMapper mapper = this.getSqlSession().getMapper(ExampleMapper.class);
		int count = mapper.countByExample(new ExampleExample());
		return "count:"+count;
	}
	
	public String registBusinisess(Business business){
		
		BusinessMapper mapper = this.getSqlSession().getMapper(BusinessMapper.class);
		
		BusinessExample ex1 = new BusinessExample();
		ex1.createCriteria().andNameEqualTo(business.getName());
		int count = mapper.countByExample(ex1);
		if(count > 0 ){
			return "名字已经被注册";
		}
		
		BusinessExample ex2 = new BusinessExample();
		ex2.createCriteria().andPhoneEqualTo(business.getPhone());
		count = mapper.countByExample(ex2);
		if(count > 0 ){
			return "电话号码已经被注册";
		}
		
		mapper.insert(business);
		
		return null;
	}
}
