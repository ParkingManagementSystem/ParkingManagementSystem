package org.springframework.samples.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	private static final String notAdmin = "noPermission";
	private static final String info = "accountInfo";
	
	@Autowired
	private AccountService accountService;

	// 전체 회원 목록 보여주기
	@RequestMapping(value = "/showAccountList.do")
	public ModelAndView accountList() {
		ModelAndView mav = new ModelAndView(accountList);
		mav.addObject("accountList", accountService.getAccountList());
		return mav;
	}

	// 주차장 공유 전체 회원 목록 보여주기
	@RequestMapping(value = "/showShareAccountList.do")
	public ModelAndView shareAccountList() {
		ModelAndView mav = new ModelAndView(shareList);
		mav.addObject("shareAccountList", accountService.getShareAccountList());
		return mav;
	}
	
	// 회원 정보 보여주기
	@RequestMapping("/showAccount.do")
	public ModelAndView showAccountInfo(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView(info);
		mav.addObject("account", accountService.selectAccount(id));
		return mav;
	}
	
	// 회원 정지
	@RequestMapping("/stopAccount.do")
	public ModelAndView stopAccount(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView(shareList);
		accountService.stopAccount(id);
		mav.addObject("shareAccountList", accountService.getShareAccountList());
		return mav;
	}
	
	// 정지 해제
	@RequestMapping("/activeAccount.do")
	public ModelAndView activeAccount(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView(shareList);
		accountService.activeAccount(id);
		mav.addObject("shareAccountList", accountService.getShareAccountList());
		return mav;
	}
	
	//권한 없을 경우 체크
	@RequestMapping("/noPermission.do")
	public String notAdmin() {
		return notAdmin;
	}
}
