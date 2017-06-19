package org.springframework.samples.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.service.ParkingParserImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicParkingController {
	
	@Autowired
	private ParkingParserImpl parser;
	
	
	@RequestMapping("/publicParkingListPage.do")
	public ModelAndView publicParkingListPage(@RequestParam("pageNo") String pageNo) {
		ModelAndView mav = new ModelAndView("publicParkingList");
		ArrayList<PublicParking> a = new ArrayList<PublicParking>();
		a = parser.apiParserSearch();
		ArrayList<PublicParking> result = new ArrayList<PublicParking>();
		
		int page = a.size()/10+1;
		mav.addObject("page", page);
		
		int cur_page;
		if(pageNo.isEmpty())
			cur_page = 1;
		else
			cur_page = Integer.parseInt(pageNo);

		int j = 1;
		for(j=1;j<=page;j++)
		{
			if(cur_page == j)
			{
				mav.addObject("page", cur_page);
				int start = (j*10) - 9;
				int last = j*10;
				for(int k = start ; k<=last ; k++ )
					result.add(a.get(k));
				break;
			}
		}
		
		mav.addObject("page_all", page);
		mav.addObject("list", result);
		
		return mav;
	}
	
	
	@RequestMapping("/publicParkingList.do")
	public ModelAndView publicParkingList(@RequestParam("pageNo") String pageNo) {
		ModelAndView mav = new ModelAndView("publicParkingList");
		ArrayList<PublicParking> a = new ArrayList<PublicParking>();
		a = parser.apiParserSearch();
		ArrayList<PublicParking> result = new ArrayList<PublicParking>();
		
		int page = a.size()/10+1;
		mav.addObject("page", page);
		
		int cur_page;
		if(pageNo.isEmpty())
			cur_page = 1;
		else
			cur_page = Integer.parseInt(pageNo);

		int j = 1;
		for(j=1;j<=page;j++)
		{
			if(cur_page == j)
			{
				mav.addObject("page", cur_page);
				int start = (j*10) - 9;
				int last = j*10;
				for(int k = start ; k<=last ; k++ )
					result.add(a.get(k));
				break;
			}
		}
		
		mav.addObject("page_all", page);
		mav.addObject("list", result);
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/publicParkingListInfo.do")
	public ModelAndView publicParkingListInfo(@RequestParam("code") String code) {
		ModelAndView mav = new ModelAndView("publicParkingListInfo");
		ArrayList<PublicParking> a = new ArrayList<PublicParking>();
		PublicParking publicParking = new PublicParking();
		a = parser.apiParserSearch();
		
		
		int i = 0;
		for(i = 0 ; i<a.size() ; i++)
		{
			if(a.get(i).getCode().equals(code))
			{
				publicParking = a.get(i);
				if(a.get(i).getStatus().equals("0"))
					publicParking.setCur_parking("미연계");
			}
		}
		mav.addObject("info", publicParking);
        
		return mav;
	}
	

}
