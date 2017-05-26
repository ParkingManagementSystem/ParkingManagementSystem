package org.springframework.samples.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	private static final String notAdmin = "/admin/noPermission.do";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("admin") != null) {
			return true;
		}
		
		response.sendRedirect(request.getContextPath() + notAdmin);
		
		return false;

	}
}
