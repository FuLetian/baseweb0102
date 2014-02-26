package com.flt.web.common.service;

import com.flt.dao.model.Consumer;
import com.flt.dao.model.User;

public interface ICommonService {

	User loadUserById(Integer id);
	
	Consumer findConsumerByEmail(String email);
}
