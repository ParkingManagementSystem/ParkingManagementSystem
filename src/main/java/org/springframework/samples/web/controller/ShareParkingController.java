package org.springframework.samples.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/*
 이미 작성된 공간 나눔 게시글에서 할 수 있는 처리를 담당하는 controller 
 공간 나눔 글의 작성자는 자신이 작성한 글, 댓글목록들과 함께 다른 사람들이 공간나눔을 신청한 목록을 볼 수 있고 이를 수락할 수 있다
 공간나눔 신청을 할 수 있는 글을 작성하고 신청을 눌렀을 시 요청을 공간나눔 작성자에게 보내고
  공간나눔 게시글 페이지로 돌려보내는 기능을 처리하는 controller
 */

@Controller
@RequestMapping("/share")
@SessionAttributes("accountSession")
public class ShareParkingController {

	@Autowired
	private ShareService shareService;
	
	@ModelAttribute("command")
	public ShareParkingCommand formBacking(HttpSession session,
			@RequestParam(value="code", required=false) String shareParkingCode, Model model){ //TODO 리퀘스트파람없는경우디폴트넣기
				
		ShareParkingCommand share = new ShareParkingCommand();
		if(shareParkingCode == null){
			System.out.println("null");
			shareParkingCode = session.getAttribute("code").toString();
		}
		share = shareService.getShareParking(shareParkingCode);
		model.addAttribute("command", share);
		
		return share;
	}
	
	@RequestMapping(value="/shareParkingInfo")
	public String info( //게시물 보여주는 페이지
			@RequestParam(value="code") String shareParkingCode, Model model, HttpSession session){

		ShareParkingCommand share = new ShareParkingCommand();
		
		session.setAttribute("code", shareParkingCode);
		share = shareService.getShareParking(shareParkingCode);
		model.addAttribute("command", share);
		
		if(share.getWriterId().equals(session.getAttribute("id").toString())){
			
			List<Apply> applyList = new ArrayList<Apply>();
			applyList = shareService.getApplyList(shareParkingCode);
			model.addAttribute("applyList", applyList);
		}
				
		return "/shareParkingInfo";
	}
	
	@RequestMapping(value="/apply.do", method=RequestMethod.POST) // TimeTable 정보 입력 //TODO 얄루얄루 
	public String getForm(HttpSession session){
		
		System.out.println("post로들어옴 ");
		return "shareParkingApply";
	}
	
	//@Transactional
	@RequestMapping(value="/apply.do",method=RequestMethod.GET) // Apply 신청
	public String insertApply(HttpSession session, Model model, @ModelAttribute("command") ShareParkingCommand share){
				
		// 들어온 정보 기반으로 apply 테이블에 레코드를 추가하는 코드
		Apply apply = new Apply(); 
		apply.setShareParkingCode(share.getShareParkingCode());
		apply.setApplierCode(session.getAttribute("id").toString());
		apply.setWriterCode(share.getWriterId());
		apply.setApproval(0);
		
		shareService.insertShareApply(apply);
				
		apply = shareService.getApply(share.getShareParkingCode(), session.getAttribute("id").toString()); //여기다 
				
		ShareParkingCommand info = new ShareParkingCommand();
		info = shareService.getShareParking(share.getShareParkingCode());
				
		model.addAttribute("command", share);
		
		ModelAndView mav = new ModelAndView();
		mav.setView(new RedirectView("redirect:/shareParkingInfo.do?code=" + share.getShareParkingCode()));
		mav.addObject("code",share.getShareParkingCode());
			
		return "/shareParkingInfo";
	}
}
