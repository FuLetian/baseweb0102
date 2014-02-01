package com.flt.service.channel;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ChannelMapper;
import com.flt.dao.client.OrderMapper;
import com.flt.dao.model.Channel;
import com.flt.dao.model.ChannelExample;
import com.flt.dao.model.Order;
import com.flt.service.base.BaseService;
import com.flt.web.manage.channel.service.IChannelManageService;
import com.flt.web.module.views.channel.IChannelService;

@Service
public class ChannelService extends BaseService implements IChannelService,IChannelManageService {

	@Override
	public List<Channel> listChannels() {
		// TODO Auto-generated method stub
		ChannelMapper mapper=getSqlSession().getMapper(ChannelMapper.class);
		
		return mapper.selectByExample(new ChannelExample());
	}

	@Override
	public List<Channel> findAllChannel(final Integer userId) {
		// TODO Auto-generated method stub
		
		ChannelMapper mapper=getSqlSession().getMapper(ChannelMapper.class);
		
		return mapper.selectByExample(new ChannelExample(){{
			this.createCriteria().andUserIdEqualTo(userId);
		}});
	}

	@Override
	public void saveOrUpdateChannel(Channel channel) {
		// TODO Auto-generated method stub
		
		ChannelMapper mapper=getSqlSession().getMapper(ChannelMapper.class);
		
		Channel newChannel=null;
		if(channel.getId()==null){
			newChannel=channel;
			newChannel.setcDt(new Date());
			newChannel.setuDt(new Date());
			mapper.insert(newChannel);
		}else{
			newChannel=mapper.selectByPrimaryKey(channel.getId());
			newChannel.setuDt(new Date());
			newChannel.setIdx(channel.getIdx());
			newChannel.setName(channel.getName());
			newChannel.setUserId(channel.getUserId());
			mapper.updateByPrimaryKey(newChannel);
		}
	}

	@Override
	public void deleteChannelById(Integer channelId) {
		// TODO Auto-generated method stub
		ChannelMapper mapper=getSqlSession().getMapper(ChannelMapper.class);
		mapper.deleteByPrimaryKey(channelId);
	}


}
