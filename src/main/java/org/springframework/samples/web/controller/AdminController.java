package org.springframework.samples.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 관리자 기능 처리
 * 전체 회원 목록 조회 및 탈퇴 
 * 주차공간 나눔 회원 목록의 조회, 정지, 탈퇴 등의 기능을 처리한다.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final String accountList = "showAccountList";
	private static final String shareList = "showShareAccountList";

	@Autowired
	private AccountService accountService;

	// 전체 회원 목록 보여주기
	@RequestMapping(value = "/showAccountList.do", method = RequestMethod.GET)
	public String accountList() {
		return accountList;
	}
}
