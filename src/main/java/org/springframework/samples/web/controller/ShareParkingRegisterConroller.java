package org.springframework.samples.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Account;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.samples.web.service.AccountService;
import org.springframework.samples.web.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/*
 * 새로운 공간 나눔 게시글을 작성할 수 있는 Form을 제공하고, 이를 완료하면 공간 나눔 게시글 리스트로 돌려보내는 기능 처리
 */

@Controller
@RequestMapping("/share/createForm.do")
@SessionAttributes("accountSession")
public class ShareParkingRegisterConroller {
	
	@Autowired
	private ShareService shareService;
	
	@Autowired
	private AccountService accountService;
	
	@ModelAttribute("command")
	public ShareParkingCommand formBacking(HttpServletRequest request, HttpSession session){
		ShareParkingCommand share = new ShareParkingCommand();
		share.setWriterId(session.getAttribute("id").toString());
		if(request.getMethod().equalsIgnoreCase("POST")){

		}
		
		return share;
	}
	
	// 폼 제공
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(){
		return "shareParkingRegister";
	}
	
	public int setBlack(String id){ // 입력자 아이디를 확인하고 블랙리스트 여부를 저장하는 메소드
		
		int isBlack = accountService.selectAccount(id).getBlacklist();
		return isBlack;
	}
		
	// 값 입력받아서 디비 반영
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") ShareParkingCommand share,
			BindingResult result, SessionStatus session){
		
		// 에러여부 확인하는 코드 추가하기 
		if(result.hasErrors()){
		return "shareParkingRegister"; }
		
		share.setBlackList(setBlack(share.getWriterId())); // 블랙리스트 여부 반영해서 저장
		share.setImage(null);
				
		shareService.insertShareParking(share);
		return "shareParkingInfo";
	}
	
	

}
