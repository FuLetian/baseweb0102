package com.flt.web.manage.article.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.config.Configuration;
import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;
import com.flt.web.manage.article.service.IArticleManageService;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	private IArticleManageService service;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		List<Article> list=service.loadAllArticle(Configuration.TMP_SESSION_USER_ID);
		String allArticleJSON=buildJSON(list);
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("articles", allArticleJSON);
		return "manage/article/view.ftl";
	}
	
	@RequestMapping(value="onSaveOrUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String saveOrUpdate(Integer id,String name,Long price,Long discount,Integer idx,Integer brandId,
			Integer menuId,Integer channelId,String imgs,String properties,String homepageImg,Model model,HttpServletRequest req){
		
		if(id!=null&&"0".equals(id.toString())){
			id=null;
		}
		
		Assert.notNull(name);
		Assert.notNull(price);
		Assert.notNull(brandId);
		Assert.notNull(menuId);
		Assert.notNull(channelId);
		
		service.saveOrUpdateArticle(id, name, price, discount, idx, brandId, menuId, channelId, imgs, properties,homepageImg,Configuration.TMP_SESSION_USER_ID);
		
		return "SUCCESS";
	}
	
	@RequestMapping("editor")
	public String edit(Integer id,Model model,HttpServletRequest req){
		
		if(id!=null){
			Article a=service.loadArticleById(id);
			model.addAttribute("article", a);
			model.addAttribute("properties", service.listArticlePropertiesByArticleId(id));
			
			List<ArticleImg> list2= service.listArticleImgsByArticleId(id);
			model.addAttribute("imgs",list2);
		}
		
		model.addAttribute("id", id);
		model.addAttribute("brands", service.listAllBrands(Configuration.TMP_SESSION_USER_ID));
		model.addAttribute("menus", service.listAllSecondMenus(Configuration.TMP_SESSION_USER_ID));
		model.addAttribute("channels", service.listAllChannels(Configuration.TMP_SESSION_USER_ID));
		
		model.addAttribute("basePath",req.getContextPath()+"/");
		return "manage/article/editor.ftl";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer id,Model model,HttpServletRequest req){
		
		Assert.notNull(id);
		service.deleteArticle(id);
		return "SUCCESS";
	}

	private String buildJSON(List<Article> list) {
		// TODO Auto-generated method stub
		
		JSONArray ja=JSONArray.fromObject(list);
		return ja.toString();
	}
}
