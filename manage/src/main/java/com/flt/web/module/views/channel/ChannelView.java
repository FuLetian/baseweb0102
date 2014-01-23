package com.flt.web.module.views.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Channel;

@View(template="component/channel/{theme}/channelView.ftl")
public class ChannelView extends BaseView {
	
	@Autowired
	private IChannelService channelService;
	
	private Integer activeChannelId=0;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		List<Channel> list=channelService.listChannels();
		
		root.put("channels", list);
		root.put("activeChannelId", activeChannelId);
	}

	public IChannelService getChannelService() {
		return channelService;
	}

	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}

	public Integer getActiveChannelId() {
		return activeChannelId;
	}

	public void setActiveChannelId(Integer activeChannelId) {
		this.activeChannelId = activeChannelId;
	}
}
