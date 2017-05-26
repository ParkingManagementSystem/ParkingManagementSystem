package org.springframework.samples.web.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.SignInCommand;
import org.springframework.samples.web.domain.Account;
import org.springframework.samples.web.service.AccountService;
import org.springframework.samples.web.validator.SignInValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("accountSession")
@RequestMapping("/signIn")
public class SignInController {

	private static final String index = "index";
	private static final String form = "signInForm";
	private static final String stop = "stopAccount";
	
	@Autowired
	private AccountService accountService;
	
	@ModelAttribute("account")
	public SignInCommand formBacking(HttpServletRequest request) throws ParseException {
		return new SignInCommand();
	}
	
	@RequestMapping("/stopAccount.do")
	public String stopAccount() {
		return stop;
	}
	
	//로그인 폼으로 
	@RequestMapping("/signInForm.do")
	public String signInForm() {
		return form;
	}
	
	//로그인 처리
	@RequestMapping("/signIn.do")
	public String signIn(@ModelAttribute("account") SignInCommand signInCommand, BindingResult result, HttpSession session) {
		
		new SignInValidator().validate(signInCommand, result);
		
		//empty form check
		if (result.hasErrors()) { 
			return form;
		}
		
		Account account = accountService.getAccount(signInCommand.getId(), signInCommand.getPwd());
		String adminId = accountService.getAdminId(signInCommand.getId(), signInCommand.getPwd());
		
		//invalid signInCommand check
		if(account == null && adminId == null) {
			result.reject("invalidAccount", "invalidAccount");
			return form;
		}
		
		//admin id check
		if(adminId != null) { 
			session.setAttribute("admin", adminId);
			//saving admin id
			session.setAttribute("id", adminId);
			return index;
		}
		
		//saving signed id
		session.setAttribute("id", account.getId());
		
		return index;
	}
}
