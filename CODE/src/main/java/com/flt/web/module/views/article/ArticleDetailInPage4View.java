package com.flt.web.module.views.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.flt.common.annotation.View;
import com.flt.common.constant.FieldConstant;
import com.flt.common.view.BaseView;
import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;
import com.flt.dao.model.ArticleProperty;

@View(template="component/article/{theme}/articleDetailInPage4View.ftl")
public class ArticleDetailInPage4View extends BaseView {

	@Autowired
	private IArticleService service;
	
	private Integer articleId;
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		Assert.notNull(articleId);
		
		Article a=service.loadArticleById(articleId);
		
		List<ArticleProperty> articleDetailProps=service.listArticlePropertiesByArticleIdAndType(articleId, 
				FieldConstant.articleProperty.type.ARTICLE_DETAIL_PROPS);
		
		Integer grade=service.countArticleGrade(articleId);
		String[] grades=new String[grade];
		
		ArticleImg img=service.loadFirstArticleImgByArticleId(articleId);
		
		root.put("a", a);
		root.put("props0", articleDetailProps);
		root.put("grade", grades);
		root.put("img", img);
		
		
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
}
