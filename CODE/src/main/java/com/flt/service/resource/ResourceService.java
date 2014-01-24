package com.flt.service.resource;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ResourceMapper;
import com.flt.dao.model.Resource;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.staticstate.IServiceAndPromiseService;

@Service
public class ResourceService extends BaseService implements IServiceAndPromiseService {

	@Override
	public Resource findResourceById(Integer id) {
		// TODO Auto-generated method stub
		ResourceMapper m=getSqlSession().getMapper(ResourceMapper.class);
		
		return m.selectByPrimaryKey(id);
	}

}
