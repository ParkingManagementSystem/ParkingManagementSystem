package org.springframework.samples.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 공간나눔 신청을 할 수 있는 글을 작성하고 신청을 눌렀을 시 요청을 공간나눔 작성자에게 보내고
  공간나눔 게시글 페이지로 돌려보내는 기능을 처리하는 controller
 */

@Controller
@RequestMapping("/share/apply.do")
public class ShareParkingApplyController {
	
	@Autowired
	private ShareService shareService;

	@RequestMapping("")
	public String gogo(){
		
		return "shareParkingApply";
	}
}
