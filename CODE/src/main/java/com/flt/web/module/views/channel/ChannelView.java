package com.flt.web.module.views.channel;

import java.util.List;

import org.springframework.ui.Model;

import com.flt.dao.model.Channel;
import com.flt.web.base.BaseView;

public class ChannelView extends BaseView {
	
	private List<Channel> channelList;

	public ChannelView(Model model) {
		super(model, ChannelView.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rander() {
		// TODO Auto-generated method stub
		model.addAttribute("channelList", channelList);
	}

	public List<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
	}

}
