package com.flt.service.article;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ArticleImgMapper;
import com.flt.dao.client.ArticleMapper;
import com.flt.dao.client.ArticlePropertyMapper;
import com.flt.dao.client.BrandMapper;
import com.flt.dao.client.ChannelMapper;
import com.flt.dao.client.CommentMapper;
import com.flt.dao.client.CommonArticleMapper;
import com.flt.dao.client.CommonMapper;
import com.flt.dao.client.MenuMapper;
import com.flt.dao.client.OrderMapper;
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
import com.flt.dao.model.CommentExample;
import com.flt.dao.model.Menu;
import com.flt.dao.model.MenuExample;
import com.flt.dao.model.Order;
import com.flt.dao.model.OrderExample;
import com.flt.service.base.BaseService;
import com.flt.web.itf.service.IBuycarService;
import com.flt.web.manage.article.service.IArticleManageService;
import com.flt.web.module.views.article.IArticleService;

@Service
public class ArticleService extends BaseService implements IArticleService,IBuycarService,IArticleManageService,IArticleCommonService{

	@Override
	public List<Article> listArticlesByChannelId(final Integer channelId) {
		// TODO Auto-generated method stub
		
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		
		return m.selectByExampleWithBLOBs(new ArticleExample(){{
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
			Integer channelId, String imgs, String properties,
			String homepageImg, Integer userId) {
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
		
		if(homepageImg!="0"){
			a.setHomepageImg(homepageImg);
		}
		
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
	public Integer loadConsumerArticleCollectionStatus(Integer consumerId,
			Integer articleId) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample e=new OrderExample();
		e.createCriteria().andArticleIdEqualTo(articleId).andConsumerIdEqualTo(consumerId).andRunStatusEqualTo(4);
		return m.countByExample(e);
	}

	@Override
	public Integer loadArticleCollectionCount(Integer articleId) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample e=new OrderExample();
		e.createCriteria().andArticleIdEqualTo(articleId).andRunStatusEqualTo(4);
		return m.countByExample(e);
	}

	@Override
	public Integer loadCommentCountByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		CommentMapper m=this.getSqlSession().getMapper(CommentMapper.class);
		CommentExample e=new CommentExample();
		e.createCriteria().andArticleIdEqualTo(articleId);
		return m.countByExample(e);
	}

	@Override
	public void cancelCollection(Integer articleId, Integer consumerId) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample e=new OrderExample();
		e.createCriteria().andArticleIdEqualTo(articleId).andConsumerIdEqualTo(consumerId).andRunStatusEqualTo(4);
		m.deleteByExample(e);
	}

	@Override
	public List<Article> listArticleByMenuId(Integer menuId) {
		// TODO Auto-generated method stub
		
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		ArticleExample ex=new ArticleExample();
		
		ex.createCriteria().andMenuIdEqualTo(menuId);
		
		return m.selectByExample(ex);
	}

	@Override
	public List<ArticleProperty> listArticlePropertyByArticleId(
			Integer articleId) {
		// TODO Auto-generated method stub
		ArticlePropertyMapper m=this.getSqlSession().getMapper(ArticlePropertyMapper.class);
		ArticlePropertyExample e=new ArticlePropertyExample();
		e.createCriteria().andArticleIdEqualTo(articleId);
		return m.selectByExample(e);
	}

	@Override
	public List<ArticleImg> listArticleImgByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		ArticleImgMapper m=this.getSqlSession().getMapper(ArticleImgMapper.class);
		ArticleImgExample e=new ArticleImgExample();
		e.createCriteria().andArticleIdEqualTo(articleId);
		return m.selectByExample(e);
	}

	/**
	 * type 0-人气，1-最新
	 */
	@Override
	public List<Article> listArticleByTypeFlag(int type) {
		// TODO Auto-generated method stub
		List<Article> as=new ArrayList<>();
		
		CommonArticleMapper m=this.getSqlSession().getMapper(CommonArticleMapper.class);
		
		switch(type){
		case 0:{
			as=m.listPopularArticle();
			break;
		}
		case 1:{
			as=m.listNewerArticle();
			break;
		}
		}
		return as;
	}

	@Override
	public void addClip(Integer articleId) {
		// TODO Auto-generated method stub
		Article a=this.loadArticleById(articleId);
		
		ArticleMapper m=getSqlSession().getMapper(ArticleMapper.class);
		Integer clip=a.getClipCount()+1;
		
		a.setClipCount(clip);
		m.updateByPrimaryKey(a);
	}

	@Override
	public List<Menu> listAllChildMenus(final Integer userId) {
		// TODO Auto-generated method stub
		MenuMapper m=getSqlSession().getMapper(MenuMapper.class);
		return m.selectByExample(new MenuExample(){{
			this.createCriteria().andUserIdEqualTo(userId).andPIdNotEqualTo(0).andPIdIsNotNull();
		}});
	}

	
}
