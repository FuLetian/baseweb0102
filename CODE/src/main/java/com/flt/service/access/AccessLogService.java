package com.flt.service.access;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.flt.dao.client.AccessLogMapper;
import com.flt.dao.model.AccessLog;
import com.flt.service.base.BaseService;

@Service
public class AccessLogService extends BaseService implements IAccessLogService {

	@Override
	public void addLog(String ip, Integer consumerId, Integer userId) {
		// TODO Auto-generated method stub
		AccessLogMapper m=this.getSqlSession().getMapper(AccessLogMapper.class);
		
		AccessLog log=new AccessLog();
		log.setConsumerId(consumerId);
		log.setIp(ip);
		log.setLunchDt(new Date());
		log.setUserId(userId);
		
		m.insert(log);
	}

}
