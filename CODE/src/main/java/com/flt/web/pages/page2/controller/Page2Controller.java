package com.flt.web.pages.page2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.controller.BaseController;
import com.flt.common.freemarker.HTMLAbled;
import com.flt.common.view.PageWrapper;
import com.flt.dao.model.User;
import com.flt.service.freemarker.FreemarkerService;
import com.flt.web.common.service.ICommonUserService;
import com.flt.web.module.views.article.ArticleInPage2View;
import com.flt.web.module.views.channel.IChannelService;
import com.flt.web.module.views.footer.FooterView;
import com.flt.web.module.views.menu.IMenuService;
import com.flt.web.module.views.menu.MenuDTO;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.module.views.staticstate.LocationView;
import com.flt.web.pages.page2.view.Page2View;

/**
 * @description Grid show article
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="page2")
public class Page2Controller extends BaseController implements HTMLAbled{

	@Autowired private MenuView menuView;
	@Autowired private FooterView footerView;
	@Autowired private ArticleInPage2View articleInPage2View;
	@Autowired private LocationView locationView;
	@Autowired private Page2View page2View;
	public PageWrapper buildPage(User user,Integer channelId){
		
		PageWrapper p=new PageWrapper(page2View, new HashMap<String,Object>(),user);
		
		
		articleInPage2View.setChannelId(channelId);
		
		p.addView(locationView);
		p.addView(menuView);
		p.addView(footerView);
		p.addView(articleInPage2View);
		
		return p;
	}
	
	@RequestMapping("view")
	public String view(Integer brandId,Integer channelId,Integer menuId,String priceRange,String discountRange,Integer orderByType,Model model,HttpServletRequest req){
		
		PageWrapper p=this.buildPage(this.getUser(req),channelId);
		
		
		model.addAllAttributes(p.getRoot());
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("param_menu_id", menuId);
		return p.getPageTemplate();
	}
	@RequestMapping("query")
	@ResponseBody
	/**
	 * 
	 * @param consumerId 若不为null，则需要选择出每一个商品的"收藏"状态
	 * @param brandId
	 * @param channelId
	 * @param discountRange
	 * @param menuId
	 * @param priceRange
	 * @param orderByType 1-销量降序，2-价格声讯,3-折扣升序
	 * @return
	 */
	public String query(Integer consumerId,Integer brandId,Integer channelId,String discountRange,Integer menuId,String priceRange,Integer orderByType,HttpServletRequest req){
		
		articleInPage2View.setConsumerId(consumerId);
		articleInPage2View.setBrandId(brandId);
		articleInPage2View.setChannelId(channelId);
		articleInPage2View.setDiscountRange(discountRange);
		articleInPage2View.setMenuId(menuId);
		articleInPage2View.setPriceRange(priceRange);
		articleInPage2View.setOrderByType(orderByType);
		articleInPage2View.setUserId(this.getUser(req).getId());
		
		String json=articleInPage2View.getJSON();
		
		return json;
	}

	@Autowired private FreemarkerService freemarkerService;
	@Autowired private ICommonUserService userService;
	@Autowired private IChannelService channelService;
	@Autowired private IMenuService menuService;
	
	@Override
	public String createHtml(HttpServletRequest req, Integer userId) {
		// TODO Auto-generated method stub
		User user=userService.loadUserById(userId);
		
		List<MenuDTO> dtos=menuService.listMenus(userId);
		
		for(MenuDTO dto:dtos){
			List<MenuDTO> childs=dto.getChildMenus();
			for(MenuDTO c:childs){
				PageWrapper p=this.buildPage(user,c.getMenu().getId());
				Map<String, Object> root=p.getRoot();
				root.put("basePath",user.getDomain());
				root.put("param_menu_id", c.getMenu().getId());
				freemarkerService.flush(req,userId,"page2-menuId-"+c.getMenu().getId()+".html", p.getPageTemplate(),root);
			}
		}
		
		return "success";
	}
}
