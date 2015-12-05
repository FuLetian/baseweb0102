package com.flt.service.base;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ExampleMapper;
import com.flt.dao.model.ExampleExample;

@Service
public class BusinessService extends BaseService {

	public String test(){
		ExampleMapper mapper = this.getSqlSession().getMapper(ExampleMapper.class);
		int count = mapper.countByExample(new ExampleExample());
		return "count:"+count;
	}
}
