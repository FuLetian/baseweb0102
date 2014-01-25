package com.flt.web.manage.channel.service;

import java.util.List;

import com.flt.dao.model.Channel;

public interface IChannelManageService {

	List<Channel> findAllChannel(Integer userId);
	
	void saveOrUpdateChannel(Channel channel);
	
	void deleteChannelById(Integer channelId);
}
