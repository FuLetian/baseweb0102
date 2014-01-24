package com.flt.web.pages.page4.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flt.common.view.PageWrapper;
import com.flt.web.module.views.article.ArticleCommentListInPage4View;
import com.flt.web.module.views.article.ArticleDetailInPage4View;
import com.flt.web.module.views.article.ArticleImgListInPage4View;
import com.flt.web.module.views.article.ArticlePropertiesInPage4View;
import com.flt.web.module.views.footer.FooterView;
import com.flt.web.module.views.menu.MenuView;
import com.flt.web.pages.page4.view.Page4View;

@Controller
@RequestMapping("page4")
public class Page4Controller {

	@RequestMapping("view")
	public String view(Integer articleId,Model model,HttpServletRequest req){
		
		PageWrapper pw=this.buildPage(articleId);
		
		model.addAllAttributes(pw.getRoot());
		return pw.getPageTemplate();
	}
	
	@Autowired private Page4View page4View;
	@Autowired private MenuView menuView;
	@Autowired private FooterView footerView;
	@Autowired private ArticleDetailInPage4View articleDetailInPage4View;
	@Autowired private ArticlePropertiesInPage4View articlePropertiesInPage4View;
	@Autowired private ArticleImgListInPage4View articleImgListInPage4View;
	@Autowired private ArticleCommentListInPage4View articleCommentListInPage4View;
	private PageWrapper buildPage(Integer articleId){
		PageWrapper pw=new PageWrapper(page4View, new HashMap<String,Object>());
		
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
}