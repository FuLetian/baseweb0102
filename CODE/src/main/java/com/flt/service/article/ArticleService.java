package com.flt.service.article;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ArticleMapper;
import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleExample;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.article.IArticleService;

@Service
public class ArticleService extends BaseService implements IArticleService{

	@Override
	public List<Article> listArticlesByChannelId(final Integer channelId) {
		// TODO Auto-generated method stub
		
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		
		return m.selectByExample(new ArticleExample(){{
			this.createCriteria().andChannelIdEqualTo(channelId);
			this.setOrderByClause("idx DESC");
		}});
	}

	
}
