package com.flt.web.module.views.article;

import java.util.List;

import com.flt.dao.model.Article;

public interface IArticleService {

	List<Article> listArticlesByChannelId(Integer channelId);
}
