package com.flt.web.pages.page4.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.controller.BaseController;
import com.flt.common.freemarker.HTMLAbled;
import com.flt.common.view.PageWrapper;
import com.flt.dao.model.Article;
import com.flt.dao.model.User;
import com.flt.service.freemarker.FreemarkerService;
import com.flt.web.common.service.ICommonUserService;
import com.flt.web.module.views.article.ArticleCommentListInPage4View;
import com.flt.web.module.views.article.ArticleDetailInPage4View;
import com.flt.web.module.views.article.ArticleImgListInPage4View;
import com.flt.web.module.views.article.ArticlePropertiesInPage4View;
import com.flt.web.module.views.article.IArticleService;
import com.flt.web.module.views.footer.FooterView;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.pages.page4.view.Page4View;

/**
 * 商品详情界面
 * @author Administrator
 *
 */
@Controller
@RequestMapping("page4")
public class Page4Controller extends BaseController implements HTMLAbled{

	@RequestMapping("view")
	public String view(Integer articleId,Model model,HttpServletRequest req){
		
		PageWrapper pw=this.buildPage(articleId,this.getUser(req));
		
		model.addAllAttributes(pw.getRoot());
		model.addAttribute("basePath", req.getContextPath()+"/");
		return pw.getPageTemplate();
	}
	
	@Autowired private Page4View page4View;
	@Autowired private MenuView menuView;
	@Autowired private FooterView footerView;
	@Autowired private ArticleDetailInPage4View articleDetailInPage4View;
	@Autowired private ArticlePropertiesInPage4View articlePropertiesInPage4View;
	@Autowired private ArticleImgListInPage4View articleImgListInPage4View;
	@Autowired private ArticleCommentListInPage4View articleCommentListInPage4View;
	private PageWrapper buildPage(Integer articleId,User user){
		PageWrapper pw=new PageWrapper(page4View, new HashMap<String,Object>(),user);
		
		articleDetailInPage4View.setArticleId(articleId);
		articlePropertiesInPage4View.setArticleId(articleId);
		
		pw.addView(menuView);
		pw.addView(footerView);
		pw.addView(articleDetailInPage4View);
		pw.addView(articlePropertiesInPage4View);
		pw.addView(articleImgListInPage4View);
		pw.addView(articleCommentListInPage4View);
		return pw;
	}
	
	@Autowired
	private IArticleService articleService;
	@Autowired private ICommonUserService userService;
	@Autowired private FreemarkerService freemarkerService;
	
	@Override
	public String createHtml(HttpServletRequest req, Integer userId) {
		// TODO Auto-generated method stub
		
		User user=userService.loadUserById(userId);
		
		List<Article> list=articleService.findArticlesIfConditionExist(null, null, null, null, null, userId, null);
		for(Article a:list){
			PageWrapper p=this.buildPage(a.getId(),user);
			Map<String, Object> root=p.getRoot();
			root.put("basePath","../");
			freemarkerService.flush(req,userId,"page4-articleId-"+a.getId()+".html", p.getPageTemplate(),root);
		}
		return null;
	}
}
