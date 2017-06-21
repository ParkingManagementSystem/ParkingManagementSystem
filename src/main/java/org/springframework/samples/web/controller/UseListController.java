package org.springframework.samples.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.service.AccountService;
import org.springframework.samples.web.service.UseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/useList")
public class UseListController {

	private static final String useList = "showUseList";

	@Autowired
	private UseServiceImpl useService;
	
	@Autowired
	private AccountService accountService;

	//사용 목록 보여주기
	@RequestMapping("/showUseList.do")
	public ModelAndView showUseList(HttpSession session) {
		ModelAndView mav = new ModelAndView(useList);
		mav.addObject("useList", useService.showUseList(session.getAttribute("id").toString()));
		return mav;
	}
	
	//사설 주차장 평가 - 좋아요
	@RequestMapping("/likeUseList.do")
	public String likeUseList(HttpSession session, @RequestParam("useCode") String useCode, @RequestParam("lender") String lender) {
		System.out.println(useCode + "," + lender);
		useService.likeShareParking(useCode, lender);
		return "redirect:/useList/showUseList.do";
	}
	
	//사설 주차장 평가 - 싫어요
	@RequestMapping("/dislikeUseList.do")
	public String dislikeUseList(HttpSession session, @RequestParam("useCode") String useCode, @RequestParam("lender") String lender) {
		useService.dislikeShareParking(useCode, lender);
		accountService.setBlackList(useCode);
		return "redirect:/useList/showUseList.do";
	}
}
