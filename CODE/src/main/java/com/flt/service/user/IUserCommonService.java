package com.flt.service.user;

import com.flt.dao.model.User;

public interface IUserCommonService {

	User loadUserBySiteAddress(String siteAddress);
	
	User loadUserById(Integer userId);
	
	void updateUser(User user);
}
