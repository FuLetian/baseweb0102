package com.flt.web.manage.article.service;

import java.util.List;

import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;
import com.flt.dao.model.ArticleProperty;
import com.flt.dao.model.Brand;
import com.flt.dao.model.Channel;
import com.flt.dao.model.Menu;

public interface IArticleManageService {

	List<Article> loadAllArticle(Integer userId);
	
	Article loadArticleById(Integer id);
	
	List<Menu> listAllSecondMenus(Integer userId);
	
	List<Menu> listAllChildMenus(Integer userId);
	
	List<Brand> listAllBrands(Integer userId);
	
	List<Channel> listAllChannels(Integer userId);
	
	void saveOrUpdateArticle(Integer id,String name,double price,double discount,Integer idx,Integer brandId,
			Integer menuId,Integer channelId,String imgs,String properties,String homepageImg,Integer userId);
	
	void deleteArticle(Integer id);
	
	List<ArticleProperty> listArticlePropertiesByArticleId(Integer id);
	
	List<ArticleImg> listArticleImgsByArticleId(Integer id);
 }
