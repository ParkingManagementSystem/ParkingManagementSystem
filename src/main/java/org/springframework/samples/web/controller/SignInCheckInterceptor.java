package org.springframework.samples.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SignInCheckInterceptor extends HandlerInterceptorAdapter {
	private static final String signIn = "/signIn/signIn.do";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("id") != null) {
			return true;
		}
		
		response.sendRedirect(request.getContextPath() + signIn);
		
		return false;

	}
}
