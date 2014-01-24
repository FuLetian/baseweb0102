package com.flt.web.module.views.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.constant.FieldConstant;
import com.flt.common.view.BaseView;
import com.flt.dao.model.ArticleProperty;

@View(template="component/article/{theme}/articlePropertiesInPage4View.ftl")
public class ArticlePropertiesInPage4View extends BaseView {

	@Autowired
	private IArticleService service;
	
	private Integer articleId;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		
		List<ArticleProperty> props=service.listArticlePropertiesByArticleIdAndType(articleId, FieldConstant.articleProperty.type.ARTICLE_PROPERTY_LIST);
		
		root.put("props", props);
		
		super.render();
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
}
