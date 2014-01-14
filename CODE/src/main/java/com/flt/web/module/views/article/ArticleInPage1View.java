package com.flt.web.module.views.article;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;

@View(template="component/article/{theme}/articleInPage1View.ftl")
public class ArticleInPage1View extends BaseView {

	@Autowired
	private IArticleService service;
	
	private Integer channelId=0;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		root.put("articles", service.listArticlesByChannelId(channelId));
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	
	
}
