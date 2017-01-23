package com.nikola.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private SessionManager sm;

	@Autowired
	private MessageSourceAccessor msa;

	@SuppressWarnings("deprecation")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String return_url = request.getRequestURL().toString() + "?" + request.getQueryString();
		return_url = return_url.replace(msa.getMessage("config.baseurl"), "");
		if (!request.getRequestURI().contains("login")) {
			if (sm.get(request) == null) {
				response.sendRedirect(
						msa.getMessage("config.baseurl") + "/login?return=" + URLEncoder.encode(return_url));
				return false;
			}
		}
		return true;
	}

}