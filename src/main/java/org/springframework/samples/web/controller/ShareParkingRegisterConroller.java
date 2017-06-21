package org.springframework.samples.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.dao.ShareDaoImpl;
import org.springframework.samples.web.dao.StudyDao;
import org.springframework.samples.web.service.AccountService;
import org.springframework.samples.web.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

/*
 * 새로운 공간 나눔 게시글을 작성할 수 있는 Form을 제공하고, 이를 완료하면 공간 나눔 게시글 리스트로 돌려보내는 기능 처리
 */

@Controller
@RequestMapping("/share")
@SessionAttributes("accountSession")
public class ShareParkingRegisterConroller {
	
	@Autowired
	private ShareService shareService;
	
	@Autowired
	private AccountService accountService;
	
	//
	@Autowired
	private ShareDaoImpl shareDao;
	
	
	@Autowired
	private StudyDao dao;
	
	@ModelAttribute("command")
	public ShareParkingCommand formBacking(HttpServletRequest request, HttpSession session){
		ShareParkingCommand share = new ShareParkingCommand();
		share.setWriterId(session.getAttribute("id").toString());
		if(request.getMethod().equalsIgnoreCase("POST")){

		}
		
		return share;
	}
	
	// 폼 제공
	@RequestMapping(value ="/create")
	public String createForm(){
		return "shareParkingRegister";
	}
	
	public int setBlack(String id){ // 입력자 아이디를 확인하고 블랙리스트 여부를 저장하는 메소드
		
		int isBlack = accountService.selectAccount(id).getBlacklist();
		return isBlack;
	}
		
	// 값 입력받아서 디비 반영
	@RequestMapping(value="/created", method={RequestMethod.POST, RequestMethod.GET})  //@ModelAttribute("command") ShareParkingCommand share, 
	public String submit(@ModelAttribute("command") ShareParkingCommand share, @RequestParam("image") MultipartFile report,
			BindingResult result, SessionStatus session, HttpSession ss){
		int isIn = 0;
		
		System.out.println("d");
		
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
			return "shareParkingRegister"; 
		}
		
		share.setBlackList(setBlack(share.getWriterId())); // 블랙리스트 여부 반영해서 저장
		//share.setImage(null);
		
		System.out.println("컨틀롤러 " + share.getImage() );
				
		shareService.insertShareParking(share);
		
		//입력한 글의 shareParkingCode
		System.out.println(shareService.getShareParkingCode());
		
//		System.out.println("image : " + share.getImage());
//		//사진 업로드
//		try {
//			Map<String, Object> hmap = new HashMap<String, Object>();
//			hmap.put("image", share.getImage().getBytes());
//			dao.saveImage(hmap);
////			shareDao.saveImage(hmap);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
		ss.setAttribute("code", shareService.getShareParkingCode());
		
		isIn = shareService.isEvaluate(share.getWriterId());
		
		if(isIn == 0) //evaluate table에 들어가 있지 않는 멤버는 새로 추가 
			shareService.insertEvaluate(share.getWriterId());
		
		return "imageTest";
	}
	
//	@RequestMapping("/saveImage")
//	public String saveImage(Vo vo) {
//		try {
//			Map<String, Object> hmap = new HashMap<String, Object>();
//			hmap.put("img", vo.getImgFile().getBytes());
//			dao.saveImage(hmap);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "redirect:/imageTest";
//	}
	
	

}
