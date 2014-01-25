package com.flt.service.article;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ArticleImgMapper;
import com.flt.dao.client.ArticleMapper;
import com.flt.dao.client.ArticlePropertyMapper;
import com.flt.dao.client.BrandMapper;
import com.flt.dao.client.ChannelMapper;
import com.flt.dao.client.MenuMapper;
import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleExample;
import com.flt.dao.model.ArticleImg;
import com.flt.dao.model.ArticleImgExample;
import com.flt.dao.model.ArticleProperty;
import com.flt.dao.model.ArticlePropertyExample;
import com.flt.dao.model.Brand;
import com.flt.dao.model.BrandExample;
import com.flt.dao.model.Channel;
import com.flt.dao.model.ChannelExample;
import com.flt.dao.model.Menu;
import com.flt.dao.model.MenuExample;
import com.flt.service.base.BaseService;
import com.flt.web.manage.article.service.IArticleManageService;
import com.flt.web.module.views.article.IArticleService;

@Service
public class ArticleService extends BaseService implements IArticleService,IArticleManageService{

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
	public List<Article> findArticlesIfConditionExist(Integer channelId,
			Integer brandId, Integer menuId, String priceRange,
			String discountRange) {
		// TODO Auto-generated method stub
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		ArticleExample ex=new ArticleExample();
		ArticleExample.Criteria c=ex.createCriteria();
		
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
		
		return m.selectByExample(ex);
	}

	private Double[] parseRangeToInteger(String priceRange) {
		// TODO Auto-generated method stub
		String[] strs=priceRange.split("-");
		Double[] nums=new Double[]{Double.valueOf(strs[0]),Double.valueOf(strs[1])};
		return nums;
	}

	@Override
	public List<Article> loadAllArticle(final Integer userId) {
		// TODO Auto-generated method stub
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		
		return m.selectByExample(new ArticleExample(){{
			this.setOrderByClause("idx DESC");
			this.createCriteria().andUserIdEqualTo(userId);
		}});
	}

	@Override
	public Article loadArticleById(Integer id) {
		// TODO Auto-generated method stub
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		
		return m.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> listAllSecondMenus(final Integer userId) {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		return m.selectByExample(new MenuExample(){{
			this.createCriteria().andUserIdEqualTo(userId);
		}});
	}

	@Override
	public List<Brand> listAllBrands(final Integer userId) {
		// TODO Auto-generated method stub
		BrandMapper m=getSqlSession().getMapper(BrandMapper.class);
		return m.selectByExample(new BrandExample(){{
			this.createCriteria().andUserIdEqualTo(userId);
		}});
	}

	@Override
	public List<Channel> listAllChannels(final Integer userId) {
		// TODO Auto-generated method stub
		
		ChannelMapper m=getSqlSession().getMapper(ChannelMapper.class);
		return m.selectByExample(new ChannelExample(){{
			this.createCriteria().andUserIdEqualTo(userId);
		}});
	}

	@Override
	public void saveOrUpdateArticle(Integer id, String name, double price,
			double discount, Integer idx, Integer brandId, Integer menuId,
			Integer channelId, String imgs, String properties,Integer userId) {
		// TODO Auto-generated method stub
		
		
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		
		Article a=new Article();
		a.setBrandId(brandId);
		a.setcDt(new Date());
		a.setChannelId(channelId);
		a.setDiscount(discount);
		a.setId(id);
		a.setIdx(idx);
		a.setMenuId(menuId);
		a.setName(name);
		a.setPrice(price);
		a.setuDt(new Date());
		a.setUserId(userId);
		
		if(id==null){
			m.insert(a);
		}else{
			m.updateByPrimaryKey(a);
		}

		if(imgs!=null){
			String[] paths=imgs.split(",");
			ArticleImgMapper m2=this.getSqlSession().getMapper(ArticleImgMapper.class);
			
			for(String path:paths){
				ArticleImg img=new ArticleImg();
				img.setArticleId(a.getId());
				img.setPath(path.replaceAll("-", "/"));
				m2.insert(img);
			}
		}
		
		if(properties!=null){
			ArticlePropertyMapper m3=this.getSqlSession().getMapper(ArticlePropertyMapper.class);
			String[] props=properties.split(",");
			int i=0;
			for(String p:props){
				i++;
				String[] nv=p.split("-");
				String n=nv[0];
				String v=nv[1];
				String type=nv[2];
				
				ArticleProperty o=new ArticleProperty();
				o.setArticleId(a.getId());
				o.setcDt(new Date());
				o.setIdx(i);
				o.setName(n);
				o.setuDt(new Date());
				o.setValue(v);
				o.setType(type);
				m3.insert(o);
			}
		}
	}

	@Override
	public void deleteArticle(final Integer id) {
		// TODO Auto-generated method stub
		ArticlePropertyMapper m3=this.getSqlSession().getMapper(ArticlePropertyMapper.class);
		m3.deleteByExample(new ArticlePropertyExample(){{
			this.createCriteria().andArticleIdEqualTo(id);
		}});
		
		ArticleImgMapper m2=this.getSqlSession().getMapper(ArticleImgMapper.class);
		m2.deleteByExample(new ArticleImgExample(){{
			this.createCriteria().andArticleIdEqualTo(id);
		}});
		
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		m.deleteByPrimaryKey(id);
	}

	@Override
	public List<ArticleProperty> listArticlePropertiesByArticleId(final Integer id) {
		// TODO Auto-generated method stub
		ArticlePropertyMapper m3=this.getSqlSession().getMapper(ArticlePropertyMapper.class);
		return m3.selectByExample(new ArticlePropertyExample(){{
			this.createCriteria().andArticleIdEqualTo(id);
		}});
	}

	@Override
	public List<ArticleImg> listArticleImgsByArticleId(final Integer id) {
		// TODO Auto-generated method stub
		ArticleImgMapper m2=this.getSqlSession().getMapper(ArticleImgMapper.class);
		return m2.selectByExample(new ArticleImgExample(){{
			this.createCriteria().andArticleIdEqualTo(id);
		}});
	}

	
}
