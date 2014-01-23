package com.flt.service.channel;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ChannelMapper;
import com.flt.dao.model.Channel;
import com.flt.dao.model.ChannelExample;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.channel.IChannelService;

@Service
public class ChannelService extends BaseService implements IChannelService {

	@Override
	public List<Channel> listChannels() {
		// TODO Auto-generated method stub
		ChannelMapper mapper=getSqlSession().getMapper(ChannelMapper.class);
		
		return mapper.selectByExample(new ChannelExample());
	}

}
