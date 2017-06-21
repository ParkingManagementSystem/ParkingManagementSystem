package org.springframework.samples.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.domain.MapLocation;
import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.samples.web.service.ShareService;
import org.springframework.samples.web.service.XmlParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/map")
public class MapController {
	@Autowired
	private XmlParser xmlParser;
	
	@Autowired
	ShareService shareService;
	
	@RequestMapping("/parkingMap.do")
	public ModelAndView parking() {
		ModelAndView mav = new ModelAndView();
		List<ShareParking> shareList= new ArrayList<ShareParking>();
		shareList = shareService.getShareParkingList();
		mav.setViewName("map2");
		mav.addObject("greeting", getGreeting());
		mav.addObject("privating", shareList);
		return mav;
	}
	@RequestMapping(value = "/search.do", method=RequestMethod.POST)
	public ModelAndView searchPublicParking(MapLocation mapLocation, ModelAndView mav) throws UnsupportedEncodingException{
		//PublicParking publicParking = new PublicParking();
		mav = new ModelAndView();
		//들어온 지역정보 가지고
		String location = mapLocation.getLocation();
		//String location = "서초";
		location = URLEncoder.encode(location, "UTF-8");
		mav.setViewName("map3");
		mav.addObject("searchParkingList", getSearching(location));
		return mav;
	}
	
	private ArrayList<PublicParking> getGreeting() {
		
		return xmlParser.apiParserSearch();
	}
	private ArrayList<PublicParking> getSearching(String n) {
		
		return xmlParser.apiParserSearch2(n);
	}
	
}
