package org.springframework.samples.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.samples.web.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 공간 나눔 게시글 리스트를 보여주는 기능을 처리하는 controller
 */

@Controller
@RequestMapping("/share/list")
public class ShareParkingListController {

	@Autowired
	ShareService shareService;
	
	@ModelAttribute("shareParkingList")
	public List<ShareParking> setShareParkingList(){
		
		List<ShareParking> shareParkingList = new ArrayList<ShareParking>();
		shareParkingList = shareService.getShareParkingList();
		
		return shareParkingList;
	}
	
	@RequestMapping("")
	public String toList(){
		
		
		return "shareParkingList";
	}
}
