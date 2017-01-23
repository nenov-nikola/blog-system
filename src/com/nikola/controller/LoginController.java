package com.nikola.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nikola.model.UserModel;
import com.nikola.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private SessionManager sm;

	@Autowired
	private UserService userService;

	@PersistenceContext
	private EntityManager em;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ModelAndView auth(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		try {
			int id = userService.authUser(email);
			UserModel um = userService.getUserById(id);
			sm.init(request, um, true);
			mav = new ModelAndView("redirect:/home");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav = new ModelAndView("redirect:/login");
			return mav;
		}
	}
}
