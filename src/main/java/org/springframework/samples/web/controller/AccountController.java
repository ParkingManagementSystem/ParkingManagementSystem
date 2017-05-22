package org.springframework.samples.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.web.command.AccountCommand;
import org.springframework.samples.web.service.AccountService;
import org.springframework.samples.web.service.AccountServiceImpl;
import org.springframework.samples.web.validator.AccountValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * MyPage기능 처리
 * 사용자 계정에 대해서 계정 생성, 보기, 수정, 삭제 등의 기능을 처리한다.
 */

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //yyyy-MM-dd'T'HH:mm:ssZ example
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@ModelAttribute("account")
	public AccountCommand formBacking(HttpServletRequest request) throws ParseException {
		AccountCommand account = new AccountCommand();
		//빈 string을 date로 parse할 수 없기 때문에 초기값 지정.. (Could not parse date: Unparseable date)
		account.setBirthday(new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
		return account;
	}
	
	//회원가입 폼 보여주기
	@RequestMapping(value="/createAccount.do", method = RequestMethod.GET)
	public String createForm() {
		return "accountForm";
	}
	
	//회원가입 폼 submit
	@RequestMapping(value="/createAccount.do", method = RequestMethod.POST)
	public String createFormSubmit(@ModelAttribute("account") AccountCommand account, 
			BindingResult result) {
		new AccountValidator().validate(account, result);
		if (result.hasErrors()) {
			return "accountForm";
		}
		accountService.insertAccount(account);
		return "index";
	}
	
	//회원 정보 수정 폼 보여주기
	@RequestMapping(value="/updateAccount.do", method = RequestMethod.GET)
	public String updateForm() {
		return "accountForm";
	}
	
	//회원 정보 update 처리
	//회원가입 폼 submit
		@RequestMapping(value="/updateAccount.do", method = RequestMethod.POST)
		public String updateFormSubmit(@ModelAttribute("account") AccountCommand account, 
				BindingResult result) {
			new AccountValidator().validate(account, result);
			if (result.hasErrors()) {
				return "accountInfo"; //showAccount.do?id=00 으로 보내면 될 듯...
			}
			return "index";
		}
	
	//회원 정보 보여주기
	@RequestMapping("/showAccount.do")
	public String showAccountInfo() { //RequestParam 쓰기
		return "accountInfo";
	}
	
	//탈퇴 처리
	@RequestMapping("/deleteAccount.do")
	public String deleteAccount() { //RequestParam 쓰기
		return "index";
	}
	
	//setting service
//	public void setAccountService(AccountServiceImpl accountService) {
//		this.accountService = accountService;
//	}
}