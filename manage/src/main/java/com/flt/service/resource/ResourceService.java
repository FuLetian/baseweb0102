package com.flt.service.resource;

import org.springframework.stereotype.Service;

import com.flt.dao.client.resourceMapper;
import com.flt.dao.model.resource;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.staticstate.IServiceAndPromiseService;

@Service
public class ResourceService extends BaseService implements IServiceAndPromiseService {

	@Override
	public resource findResourceById(Integer id) {
		// TODO Auto-generated method stub
		resourceMapper m=getSqlSession().getMapper(resourceMapper.class);
		
		return m.selectByPrimaryKey(id);
	}

}
