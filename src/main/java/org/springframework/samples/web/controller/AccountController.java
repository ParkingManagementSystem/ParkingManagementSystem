package org.springframework.samples.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.samples.web.command.AccountCommand;
import org.springframework.samples.web.command.PasswordCommand;
import org.springframework.samples.web.service.AccountService;
import org.springframework.samples.web.validator.AccountUpdateValidator;
import org.springframework.samples.web.validator.AccountValidator;
import org.springframework.samples.web.validator.PasswordUpdateValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * MyPage기능 처리
 * 사용자 계정에 대해서 계정 생성, 보기, 수정, 삭제 등의 기능을 처리한다.
 */

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final String index = "index";
	private static final String form = "accountForm";
	private static final String updateForm = "accountUpdateForm";
	private static final String updatePwd = "updatePassword";
	private static final String info = "accountInfo";

	@Autowired
	private AccountService accountService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ModelAttribute("account")
	public AccountCommand formBacking(HttpServletRequest request) throws ParseException {
		AccountCommand account = new AccountCommand();
		// 빈 string을 date로 parse할 수 없기 때문에 초기값 지정.. (Could not parse date:
		// Unparseable date)
		account.setBirthday(new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
		return account;
	}

	// 회원가입 폼 보여주기
	@RequestMapping(value = "/createAccount.do", method = RequestMethod.GET)
	public String createForm() {
		return form;
	}

	// 회원가입 폼 submit
	@RequestMapping(value = "/createAccount.do", method = RequestMethod.POST)
	public String createFormSubmit(@ModelAttribute("account") AccountCommand account, BindingResult result,
			HttpSession session) {

		new AccountValidator().validate(account, result);

		if (result.hasErrors()) { // form error check
			return form;
		}

		if (accountService.hasId(account.getId())) { // ID duplication check
			result.rejectValue("id", "alreadyExistsId");
			return form;
		}

		accountService.insertAccount(account);

		// saving signed id
		session.setAttribute("id", account.getId());

		return index;
	}

	// 회원 정보 수정 폼 보여주기
	@RequestMapping(value = "/updateAccount.do", method = RequestMethod.GET)
	public ModelAndView updateForm(HttpSession session) {
		// Get account -> accountCommand
		AccountCommand account = new AccountCommand(
				accountService.selectAccount(session.getAttribute("id").toString()));

		return new ModelAndView(updateForm, "account", account);
	}

	// 회원 정보 update 처리. 회원정보 수정 폼 submit
	@RequestMapping(value = "/updateAccount.do", method = RequestMethod.POST)
	public String updateFormSubmit(@ModelAttribute("account") AccountCommand accountCommand, BindingResult result,
			HttpSession session) {

		// TODO 왜 누르면 id가 한번 더 들어오는지... 해결하기! 해결하면 session 빼고 그냥 커맨드 객체로 넘기기
		System.out.println("account command : " + accountCommand.toString());
		accountCommand.setId(session.getAttribute("id").toString());

		new AccountUpdateValidator().validate(accountCommand, result);

		if (result.hasErrors()) { // form error check
			return updateForm;
		}

		accountService.updateAccount(accountCommand);

		return info;
	}

	// 회원 정보 보여주기
	@RequestMapping("/showAccount.do")
	public ModelAndView showAccountInfo(HttpSession session) {
		ModelAndView mav = new ModelAndView(info);
		mav.addObject("account", accountService.selectAccount(session.getAttribute("id").toString()));
		return mav;
	}

	// 비밀번호 수정 화면 보여주기
	@RequestMapping(value = "/updatePassword.do", method = RequestMethod.GET)
	public ModelAndView updatePasswordForm(HttpSession session) {
		ModelAndView mav = new ModelAndView(updatePwd);
		mav.addObject("pwd", new PasswordCommand());
		return mav;
	}

	// 비밀번호 수정 처리
	@RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
	public String updatePassword(@ModelAttribute("pwd") PasswordCommand passwordCommand, BindingResult result, HttpSession session) {
		String id = session.getAttribute("id").toString();
		passwordCommand.setId(id);
		passwordCommand.setPwd(accountService.getPwd(id));
		
		new PasswordUpdateValidator().validate(passwordCommand, result);
		
		if(result.hasErrors()) {
			return updatePwd;
		}
		
		accountService.updatePassword(id, passwordCommand.getPwdNew());
		return "redirect:/account/showAccount.do";
	}

	// 탈퇴 처리
	@RequestMapping("/deleteAccount.do")
	public String deleteAccount(HttpSession session) {
		accountService.deleteAccount(session.getAttribute("id").toString());
		session.removeAttribute("id");
		return index;
	}
}