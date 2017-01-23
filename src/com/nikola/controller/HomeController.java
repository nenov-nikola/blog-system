package com.nikola.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nikola.model.ArticleModel;
import com.nikola.model.UserModel;
import com.nikola.service.ArticleService;

@Controller
public class HomeController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private SessionManager sm;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home");
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
}
