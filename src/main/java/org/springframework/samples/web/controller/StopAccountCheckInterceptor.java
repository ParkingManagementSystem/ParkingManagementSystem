package org.springframework.samples.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.service.AccountService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class StopAccountCheckInterceptor extends HandlerInterceptorAdapter {
	private static final String stop = "/signIn/stopAccount.do";

	@Autowired
	private AccountService accountService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(request.getParameter("id"));
		
		for (String s : accountService.getBlacklistAccount()) {
			System.out.println(s);
			if (request.getParameter("id").equals(s)) {
				response.sendRedirect(request.getContextPath() + stop);
				return false;
			}
		}
		return true;
	}
}
