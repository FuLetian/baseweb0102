package com.flt.web.itf.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.common.constant.KeyConstant;
import com.flt.common.controller.BaseController;
import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleImg;
import com.flt.web.itf.dto.AritcleCountDTO;
import com.flt.web.itf.service.IBuycarService;
import com.flt.web.module.views.article.ArticleCommentListInPage4View;
import com.flt.web.module.views.article.IArticleService;

@Controller
@RequestMapping("buycar")
public class BuyCarController extends BaseController {
	
	@Autowired
	private IBuycarService service;
	@Autowired
	private IArticleService articleService;

	@RequestMapping("addItem")
	@ResponseBody
	public String addItem(Integer articleId,final Integer count,HttpServletRequest req){
		
		Set<AritcleCountDTO> list=(Set<AritcleCountDTO>) req.getSession().getAttribute(KeyConstant.SESSION_BUY_CAR_KEY);
		if(list==null){
			list=new HashSet<>();
		}
		final Article a=service.loadArticleById(articleId);
		list.add(new AritcleCountDTO(){{
			this.setArticle(a);
			this.setCount(count);
			ArticleImg img=articleService.loadFirstArticleImgByArticleId(a.getId());
			if(img!=null){
				this.setThumbnail(img.getPath());
			}
		}});
		
		req.getSession().setAttribute(KeyConstant.SESSION_BUY_CAR_KEY, list);
		return JSONArray.fromObject(list).toString();
	}
	
	@RequestMapping("getBuycar")
	@ResponseBody
	public String getBuycar(HttpServletRequest req){
		Set<AritcleCountDTO> list=(Set<AritcleCountDTO>) req.getSession().getAttribute(KeyConstant.SESSION_BUY_CAR_KEY);
		if(list==null){
			list=new HashSet<>();
		}
		
		return JSONArray.fromObject(list).toString();
	}
	
	@RequestMapping("removeItem")
	@ResponseBody
	public String removeItem(Integer articleId,HttpServletRequest req){
		
		Set<AritcleCountDTO> list=(Set<AritcleCountDTO>) req.getSession().getAttribute(KeyConstant.SESSION_BUY_CAR_KEY);
		if(list==null){
			list=new HashSet<>();
		}
		
		for(AritcleCountDTO o:list){
			if(o.getArticle().getId().equals(articleId)){
				list.remove(o);
				break;
			}
		}
		
		return JSONArray.fromObject(list).toString();
		
	}
	
}
