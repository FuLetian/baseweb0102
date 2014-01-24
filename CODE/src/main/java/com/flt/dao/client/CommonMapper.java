package com.flt.dao.client;

import com.flt.dao.model.ArticleImg;

public interface CommonMapper {

	String countArticleGrade(Integer articleId);
	
	ArticleImg selectFirstImgForArticle(Integer articleId);
}
