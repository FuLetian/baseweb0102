package com.flt.service.access;

public interface IAccessLogService {

	void addLog(String ip,Integer consumerId,Integer userId);
}
