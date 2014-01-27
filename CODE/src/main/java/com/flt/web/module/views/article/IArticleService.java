package com.flt.web.module.views.article;

import java.util.List;

import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;
import com.flt.dao.model.ArticleProperty;
import com.flt.dao.model.Order;

public interface IArticleService {
	
	List<ArticleProperty> listArticlePropertiesByArticleIdAndType(Integer articleId,String type);
	
	Article loadArticleById(Integer id);

	List<Article> listArticlesByChannelId(Integer channelId);
	
	List<Article> findArticlesIfConditionExist(Integer channelId,Integer brandId,Integer menuId,
			String priceRange,String discountRange,Integer userId);
	
	Integer countArticleGrade(Integer articleId);
	
	ArticleImg loadFirstArticleImgByArticleId(Integer articleId);
	
	List<ArticleImg> listArticleImgsByArticleId(Integer articleId);
	
	void saveOrder(Order o);
}
