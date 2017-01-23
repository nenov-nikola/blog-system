package com.nikola.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nikola.model.UserModel;
import com.nikola.service.UserService;
import com.nikola.utils.EmailValidator;
import com.nikola.utils.MD5Encoder;

@Controller
public class RegisterController {

	@Autowired
	private SessionManager sm;

	@Autowired
	private UserService userService;

	@Autowired
	private EmailValidator emailValidator;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("register");
		UserModel user = sm.get(request);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "pass", required = true) String pass, HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		UserModel user = sm.get(request);
		mav.addObject("user", user);

		if (!emailValidator.isValidEmailAddress(email)) {
			mav = new ModelAndView("redirect:/register");
			mav.addObject("msg", "Invalid email");
			return mav;
		}

		try {
			UserModel u = userService.addUser(firstname, lastname, username, email, MD5Encoder.getFormatedString(pass));
			mav = new ModelAndView("redirect:/login");
			return mav;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			mav = new ModelAndView("redirect:/register");
			return mav;
		}
	}
}
