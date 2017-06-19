package org.springframework.samples.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.service.XmlParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/map")
public class MapController {
	@Autowired
	private XmlParser xmlParser;
	@RequestMapping("/parkingMap.do")
	public ModelAndView parking() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("map2");
		mav.addObject("greeting", getGreeting());
		return mav;
	}

	private ArrayList<PublicParking> getGreeting() {
		
		return xmlParser.apiParserSearch();
	}
}
