package org.springframework.samples.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signOut")
public class SignOutController {
	
	private static final String index = "index";
	
	@RequestMapping("/signOut.do")
	public String signOut(HttpSession session) throws Exception {
		session.removeAttribute("id");
		session.invalidate();
		return index;
	}
}
