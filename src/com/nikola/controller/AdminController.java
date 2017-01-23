package com.nikola.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nikola.model.ArticleModel;
import com.nikola.model.UserModel;
import com.nikola.service.ArticleService;

@Controller
public class AdminController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private SessionManager sm;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView showView(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin");
		UserModel user = sm.get(request);
		mav.addObject("user", user);

		try {
			List<ArticleModel> articles = articleService.listFiveArticles();
			mav.addObject("articles", articles);
			return mav;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return mav;
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editArticle(@RequestParam(value = "id", required = true) int id, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("article-edit");

		try {
			ArticleModel am = articleService.selectArticleById(id);
			mav.addObject("am", am);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			return mav;
		}
	}

	@RequestMapping(value = "/edit-article", method = RequestMethod.POST)
	public ModelAndView edit(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "author", required = true) String author,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "article", required = true) String article, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("redirect:/admin");

		try {
			articleService.updateArticle(name, article, author, id);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			return mav;
		}
	}

}
