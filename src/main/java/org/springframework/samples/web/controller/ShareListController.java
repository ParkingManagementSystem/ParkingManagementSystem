package org.springframework.samples.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.service.ShareServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shareList")
public class ShareListController {
	
	private static final String shareList = "showShareList";

	@Autowired
	private ShareServiceImpl shareService;

	//주차장 나눔 내역 보여주기 (내가 쓴 글 보기)
	@RequestMapping("/showShareList.do")
	public ModelAndView showShareList(HttpSession session) {
		ModelAndView mav = new ModelAndView(shareList);
		mav.addObject("shareList", shareService.getShareParkingListByWriter(session.getAttribute("id").toString()));
		return mav;
	}
	
//	//사설 주차장 평가 - 좋아요
//	@RequestMapping("/likeUseList.do")
//	public String likeUseList(HttpSession session, @RequestParam("useCode") String useCode, @RequestParam("lender") String lender) {
//		System.out.println(useCode + "," + lender);
//		useService.likeShareParking(useCode, lender);
//		return "redirect:/useList/showUseList.do";
//	}
//	
//	//사설 주차장 평가 - 싫어요
//	@RequestMapping("/dislikeUseList.do")
//	public String dislikeUseList(HttpSession session, @RequestParam("useCode") String useCode, @RequestParam("lender") String lender) {
//		useService.dislikeShareParking(useCode, lender);
//		return "redirect:/useList/showUseList.do";
//	}
}
