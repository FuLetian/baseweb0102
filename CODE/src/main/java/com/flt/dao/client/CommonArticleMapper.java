package com.flt.dao.client;

import java.util.List;

import com.flt.dao.model.Article;

public interface CommonArticleMapper {

	List<Article> listPopularArticle();
	
	List<Article> listNewerArticle();
}
