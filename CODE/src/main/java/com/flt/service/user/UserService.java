package com.flt.service.user;

import org.springframework.stereotype.Service;

import com.flt.dao.client.UserMapper;
import com.flt.dao.model.User;
import com.flt.service.base.BaseService;
import com.flt.web.common.service.ICommonUserService;

@Service
public class UserService extends BaseService implements ICommonUserService {

	@Override
	public User loadConsumerById(Integer userId) {
		// TODO Auto-generated method stub
		
		UserMapper m=this.getSqlSession().getMapper(UserMapper.class);
		
		return m.selectByPrimaryKey(userId);
	}

}
