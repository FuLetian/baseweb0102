package com.flt.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.UserMapper;
import com.flt.dao.model.User;
import com.flt.dao.model.UserExample;
import com.flt.service.base.BaseService;
import com.flt.web.common.service.ICommonUserService;

@Service
public class UserService extends BaseService implements ICommonUserService,IUserCommonService {

	@Override
	public User loadConsumerById(Integer userId) {
		// TODO Auto-generated method stub
		
		UserMapper m=this.getSqlSession().getMapper(UserMapper.class);
		
		return m.selectByPrimaryKey(userId);
	}

	@Override
	public User loadUserByDomain(String domain) {
		// TODO Auto-generated method stub
		UserMapper m=this.getSqlSession().getMapper(UserMapper.class);
		UserExample ex=new UserExample();
		ex.createCriteria().andDomainEqualTo(domain);
		
		List<User> list=m.selectByExample(ex);
		
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
		
	}

	@Override
	public User loadUserById(Integer id) {
		// TODO Auto-generated method stub
		UserMapper m=this.getSqlSession().getMapper(UserMapper.class);
		
		return m.selectByPrimaryKey(id);
	}

	@Override
	public User loadUserBySiteAddress(String siteAddress) {
		// TODO Auto-generated method stub
		
		UserMapper m=this.getSqlSession().getMapper(UserMapper.class);
		UserExample ex=new UserExample();
		ex.createCriteria().andSiteAddressEqualTo(siteAddress);
		
		List<User> list=m.selectByExample(ex);
		
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		UserMapper m=this.getSqlSession().getMapper(UserMapper.class);
		m.updateByPrimaryKey(user);
	}

}
