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
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private SessionManager sm;

	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public ModelAndView articleForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("add-article");
		UserModel user = sm.get(request);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/add-article", method = RequestMethod.POST)
	public ModelAndView addArticle(@RequestParam(value = "author", required = true) String author,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "article", required = true) String article, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/home");
		UserModel user = sm.get(request);
		mav.addObject("user", user);

		try {
			articleService.addArticle(name, article, author);
			return mav;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			mav = new ModelAndView("add-article");
			return mav;
		}
	}

	@RequestMapping(value = "/all-articles", method = RequestMethod.GET)
	public ModelAndView showAuthorArticles(@RequestParam(value = "name", required = true) String name) {
		ModelAndView mav = new ModelAndView("all-articles");

		try {
			List<ArticleModel> articles = articleService.selectAuthorArticles(name);
			mav.addObject("articles", articles);
			return mav;
		} catch (Exception e) {
			return mav;
		}

	}
}
