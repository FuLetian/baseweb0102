package com.flt.service.article;

import java.util.List;

import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;
import com.flt.dao.model.ArticleProperty;

public interface IArticleCommonService {

	List<Article> listArticleByMenuId(Integer menuId);
	
	Article loadArticleById(Integer articleId);
	
	List<ArticleProperty> listArticlePropertyByArticleId(Integer articleId);
	
	List<ArticleImg> listArticleImgByArticleId(Integer articleId);
	
	List<Article> listArticleByTypeFlag(int type);
}
