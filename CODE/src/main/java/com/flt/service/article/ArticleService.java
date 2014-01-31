package com.flt.service.article;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ArticleImgMapper;
import com.flt.dao.client.ArticleMapper;
import com.flt.dao.client.ArticlePropertyMapper;
import com.flt.dao.client.CommonMapper;
import com.flt.dao.client.OrderMapper;
import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleExample;
import com.flt.dao.model.ArticleImg;
import com.flt.dao.model.ArticleImgExample;
import com.flt.dao.model.ArticleProperty;
import com.flt.dao.model.ArticlePropertyExample;
import com.flt.dao.model.Order;
import com.flt.service.base.BaseService;
import com.flt.web.itf.service.IBuycarService;
import com.flt.web.module.views.article.IArticleService;

@Service
public class ArticleService extends BaseService implements IArticleService,IBuycarService{

	@Override
	public List<Article> listArticlesByChannelId(final Integer channelId) {
		// TODO Auto-generated method stub
		
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		
		return m.selectByExample(new ArticleExample(){{
			this.createCriteria().andChannelIdEqualTo(channelId);
			this.setOrderByClause("idx DESC");
		}});
	}

	@Override
	/**
	 * @param orderByType 0-默认排序 1-销量降序，2-价格声讯,3-折扣升序
	 */
	public List<Article> findArticlesIfConditionExist(Integer channelId,
			Integer brandId, Integer menuId, String priceRange,
			String discountRange,Integer userId,Integer orderByType) {
		// TODO Auto-generated method stub
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		ArticleExample ex=new ArticleExample();
		ArticleExample.Criteria c=ex.createCriteria();
		
		c.andUserIdEqualTo(userId);
		
		if(channelId!=null){
			c.andChannelIdEqualTo(channelId);
		}
		if(brandId!=null){
			c.andBrandIdEqualTo(brandId);
		}
		if(menuId!=null){
			c.andMenuIdEqualTo(menuId);
		}
		if(priceRange!=null){
			Double[] nums=parseRangeToInteger(priceRange);
			c.andPriceBetween(nums[0], nums[1]);
		}
		if(discountRange!=null){
			Double[] nums=parseRangeToInteger(discountRange);
			c.andDiscountBetween(nums[0], nums[1]);
		}
		
		if(orderByType!=null){
			switch(orderByType.intValue()){
			case 1:{
				ex.setOrderByClause("sale_count ASC");
				break;
			}
			case 2:{
				ex.setOrderByClause("price ASC");
				break;
			}
			case 3:{
				ex.setOrderByClause("discount ASC");
				break;
			}
			}

			
		}
		
		return m.selectByExample(ex);
	}

	private Double[] parseRangeToInteger(String priceRange) {
		// TODO Auto-generated method stub
		String[] strs=priceRange.split("-");
		Double[] nums=new Double[]{Double.valueOf(strs[0]),Double.valueOf(strs[1])};
		return nums;
	}

	@Override
	public Article loadArticleById(Integer id) {
		// TODO Auto-generated method stub
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		return m.selectByPrimaryKey(id);
	}

	@Override
	public List<ArticleProperty> listArticlePropertiesByArticleIdAndType(
			Integer articleId, String type) {
		// TODO Auto-generated method stub
		ArticlePropertyMapper m=this.getSqlSession().getMapper(ArticlePropertyMapper.class);
		
		ArticlePropertyExample ex=new ArticlePropertyExample();
		ex.createCriteria().andArticleIdEqualTo(articleId).andTypeEqualTo(type);
		return m.selectByExample(ex);
	}

	@Override
	public Integer countArticleGrade(Integer articleId) {
		// TODO Auto-generated method stub
		CommonMapper m=this.getSqlSession().getMapper(CommonMapper.class);

		String avg=m.countArticleGrade(articleId);
		if(avg==null){
			return 0;
		}else{
			Double d= Math.ceil(Double.valueOf(avg));
			return d.intValue();
		}
	}

	@Override
	public ArticleImg loadFirstArticleImgByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		
		CommonMapper m=this.getSqlSession().getMapper(CommonMapper.class);
		return m.selectFirstImgForArticle(articleId);
	}

	@Override
	public List<ArticleImg> listArticleImgsByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		
		ArticleImgMapper m=this.getSqlSession().getMapper(ArticleImgMapper.class);
		
		return m.selectByExample(new ArticleImgExample());
	}

	@Override
	public void saveOrder(Order o) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		
		m.insert(o);
	}

	
}
