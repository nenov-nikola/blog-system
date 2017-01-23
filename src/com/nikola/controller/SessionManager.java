package com.nikola.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.nikola.model.UserModel;

@Component
public class SessionManager {

	public static final String ProfileUser = "profileuser";

	public UserModel get(HttpServletRequest request) {
		HttpSession session = null;
		session = request.getSession(false);

		if (session == null)
			return null;
		return (UserModel) session.getAttribute(ProfileUser);
	}

	public void set(HttpServletRequest request, UserModel auth) {
		HttpSession session = null;
		session = request.getSession(false);

		if (session == null)
			return;

		session.setAttribute(ProfileUser, auth);
	}

	public void remember(HttpServletRequest request) {
		HttpSession session = null;
		session = request.getSession(false);

		if (session != null)
			session.invalidate();

		session.setMaxInactiveInterval(60 * 60 * 60);
	}

	public void init(HttpServletRequest request, UserModel auth, Boolean remember) {
		HttpSession session = null;
		session = request.getSession(false);

		if (session != null)
			session.invalidate();

		session = request.getSession(true);
		if (remember)
			session.setMaxInactiveInterval(60 * 60 * 60 * 60);
		else
			session.setMaxInactiveInterval(1800);
		session.setAttribute(ProfileUser, auth);
	}

	public void destroy(HttpServletRequest request) {
		HttpSession session = null;
		session = request.getSession(false);

		if (session == null)
			return;

		session.removeAttribute(ProfileUser);
		session.invalidate();
	}

}