package org.springframework.samples.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.SignInCommand;
import org.springframework.samples.web.service.AccountService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class StopAccountCheckInterceptor extends HandlerInterceptorAdapter {
	private static final String stop = "/signIn/stopAccount.do";

	@Autowired
	private AccountService accountService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		for (SignInCommand command : accountService.getBlacklistAccount()) {
			if (id.equals(command.getId()) && pwd.equals(command.getPwd())) {
				response.sendRedirect(request.getContextPath() + stop);
				return false;
			}
		}
		
		return true;
	}
}
