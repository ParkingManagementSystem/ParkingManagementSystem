package org.springframework.samples.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 이미 작성된 공간 나눔 게시글에서 할 수 있는 처리를 담당하는 controller 
 공간 나눔 글의 작성자는 자신이 작성한 글, 댓글목록들과 함께 다른 사람들이 공간나눔을 신청한 목록을 볼 수 있고 이를 수락할 수 있다. 
 */

@Controller
@RequestMapping("/share/shareParkingInfo")
public class ShareParkingController {

	@Autowired
	private ShareService shareService;
	
	@ModelAttribute("command")
	public ShareParkingCommand formBacking(HttpServletRequest request,
			@RequestParam("code") String shareParkingCode, Model model){
		
		ShareParkingCommand share = new ShareParkingCommand();
		share = shareService.getShareParking(shareParkingCode);
		model.addAttribute("command", share);
		
		return share;
	}
	
	@RequestMapping("")
	public String info( //게시물 보여주는 페이지
			@RequestParam("code") String shareParkingCode
			, Model model){
		
		ShareParkingCommand share = new ShareParkingCommand();
		share = shareService.getShareParking(shareParkingCode);
		model.addAttribute("command", share);
		return "/shareParkingInfo";
	}
}
