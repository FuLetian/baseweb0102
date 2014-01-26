package com.flt.service.util;

import org.springframework.stereotype.Service;

import com.flt.dao.client.UserMapper;
import com.flt.dao.model.User;
import com.flt.service.base.BaseService;
import com.flt.web.common.service.ICommonService;

@Service
public class UtilService extends BaseService implements ICommonService {

	@Override
	public User loadUserById(Integer id) {
		// TODO Auto-generated method stub
		
		UserMapper m=this.getSqlSession().getMapper(UserMapper.class);
		
		
		return m.selectByPrimaryKey(id);
	}

}
