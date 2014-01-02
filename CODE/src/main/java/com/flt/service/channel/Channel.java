package com.flt.service.channel;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ChannelMapper;
import com.flt.dao.model.ChannelExample;
import com.flt.service.base.BaseService;
import com.flt.web.pages.controller.IPage1ChannelService;

@Service
public class Channel extends BaseService implements IPage1ChannelService {

	@Override
	public List<com.flt.dao.model.Channel> listChannels() {
		// TODO Auto-generated method stub
		
		ChannelMapper mapper=this.getSqlSession().getMapper(ChannelMapper.class);
		
		ChannelExample ex=new ChannelExample();
		ex.setOrderByClause("ind DESC");
		return mapper.selectByExample(ex);
	}

}
