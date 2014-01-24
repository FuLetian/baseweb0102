package com.flt.web.module.views.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;
import com.flt.dao.model.ArticleImg;

@View(template="component/article/{theme}/articleImgListInPage4View.ftl")
public class ArticleImgListInPage4View extends BaseView {

	@Autowired
	private IArticleService service;
	
	private Integer articleId;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		List<ArticleImg> imgs=service.listArticleImgsByArticleId(articleId);
		
		root.put("imgs", imgs);
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	
}
