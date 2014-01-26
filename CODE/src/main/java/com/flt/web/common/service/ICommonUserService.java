package com.flt.web.common.service;

import com.flt.dao.model.User;

public interface ICommonUserService {

	User loadConsumerById(Integer userId);
	
	User loadUserByDomain(String domain);
}
