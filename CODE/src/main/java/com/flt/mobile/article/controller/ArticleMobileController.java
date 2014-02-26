package com.flt.mobile.article.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.service.article.IArticleCommonService;
import com.flt.service.comment.ICommentCommonService;

@Controller
@RequestMapping("mobile-article")
public class ArticleMobileController {
	
	@Autowired
	private IArticleCommonService articleCommonService;
	@Autowired
	private ICommentCommonService commentCommonService;

	/**
	 * listView for article
	 * @param userId
	 * @param menuId
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("view")
	public String view(Integer userId,Integer menuId,Model model,HttpServletRequest req){
		
		model.addAttribute("articles", articleCommonService.listArticleByMenuId(menuId));
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/article/view.ftl";
	}
	
	@RequestMapping("details")
	public String details(Integer userId,Integer articleId,Model model,HttpServletRequest req){
		
		model.addAttribute("imgs", articleCommonService.listArticleImgByArticleId(articleId));
		model.addAttribute("props", articleCommonService.listArticlePropertyByArticleId(articleId));
		model.addAttribute("article", articleCommonService.loadArticleById(articleId));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		return "mobile/article/details.ftl";
	}
	
	@RequestMapping("details-info")
	public String detailsInfo(Integer userId,Integer articleId,Model model,HttpServletRequest req){

		model.addAttribute("imgs", articleCommonService.listArticleImgByArticleId(articleId));
		model.addAttribute("props", articleCommonService.listArticlePropertyByArticleId(articleId));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/article/details-info.ftl";
	}
	
	@RequestMapping("comments-list")
	public String commentsList(Integer userId,Integer articleId,Model model,HttpServletRequest req){

		model.addAttribute("comments", commentCommonService.listCommentsByArticleId(articleId));
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		model.addAttribute("userId", userId);
		
		return "mobile/article/comments.ftl";
	}
}
