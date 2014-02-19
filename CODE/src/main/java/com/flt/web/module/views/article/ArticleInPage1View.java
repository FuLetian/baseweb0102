package com.flt.web.module.views.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Article;

/**
 * @description 商品列表，竖直排列
 * @author Administrator
 *
 */
@View(template="component/article/{theme}/articleInPage1View.ftl")
public class ArticleInPage1View extends BaseView {

	@Autowired
	private IArticleService service;
	
	private Integer channelId=0;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		List<Article> list=service.listArticlesByChannelId(channelId);
		root.put("articles", list);
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	
	
}
