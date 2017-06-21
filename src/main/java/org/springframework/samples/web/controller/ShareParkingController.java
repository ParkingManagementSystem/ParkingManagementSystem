package org.springframework.samples.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.ApplyCommand;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.Time;
import org.springframework.samples.web.domain.Use;
import org.springframework.samples.web.service.ShareService;
import org.springframework.samples.web.service.UseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	@Autowired
	private UseService useService;

	@ModelAttribute("command")
	public ShareParkingCommand formBacking(HttpSession session,
			@RequestParam(value = "code", required = false) String shareParkingCode, Model model) {

		ShareParkingCommand share = new ShareParkingCommand();
		if (shareParkingCode == null) {
			shareParkingCode = session.getAttribute("code").toString();
		}
		share = shareService.getShareParking(shareParkingCode);
		model.addAttribute("command", share);
		session.setAttribute("btn", "0");
		
		return share;
	}

	@RequestMapping(value = "/shareParkingInfo")
	public String info( // 寃뚯떆臾� 蹂댁뿬二쇰뒗 �럹�씠吏�
			@RequestParam(value = "code") String shareParkingCode, Model model, HttpSession session) {

		ShareParkingCommand share = new ShareParkingCommand();

		session.setAttribute("code", shareParkingCode);
		share = shareService.getShareParking(shareParkingCode);
		model.addAttribute("command", share);

		// 湲� �옉�꽦�옄媛� �옄�떊�쓽 湲��뿉 �뱾�뼱媛� 寃쎌슦 applyCommand 紐⑸줉 �솗�씤 媛��뒫 
		if (share.getWriterId().equals(session.getAttribute("id").toString())) { 
			List<ApplyCommand> applyList = new ArrayList<ApplyCommand>();
			applyList = shareService.getApplyCommandList(shareParkingCode);
			model.addAttribute("applyList", applyList);
		}

		session.setAttribute("time", "0");
		
		//媛� 2�삤硫� session 媛� 2濡� 
		int n = shareService.isAccepted(shareParkingCode, session.getAttribute("id").toString());
		if(n>=1)
			session.setAttribute("btn", "2");
		n = shareService.isApplied(shareParkingCode, session.getAttribute("id").toString());
		if(n==1)
			session.setAttribute("btn", "3");

		return "/shareParkingInfo";
	}

	@RequestMapping(value = "/accept.do") // �옉�꽦�옄媛� �떊泥��옄�뱾 紐⑸줉 蹂닿퀬 �닔�씫
	public String acceptApply(HttpSession session, @RequestParam("renter") String renter,
			@RequestParam("parkingName") String parkingName, @ModelAttribute("command") ShareParkingCommand share,
			@RequestParam("applyCode") String applyCode) {

		Use use = new Use(parkingName, share.getShareParkingCode(), renter, session.getAttribute("id").toString());

		shareService.updateApply(applyCode);
		useService.insertShareUse(use);
		return "redirect:/share/shareParkingInfo.do?code=" + session.getAttribute("code").toString();
	}

	@RequestMapping(value = "/apply.do", method = RequestMethod.POST) // TimeTable
																		// �젙蹂� �엯�젰
	public String getForm(HttpSession session, @RequestParam("startDate") String d1, @RequestParam("endDate") String d2,
			@RequestParam("startHour") int s1, @RequestParam("startMinute") int s2, @RequestParam("endHour") int e1,
			@RequestParam("endMinute") int e2) throws ParseException {

		SimpleDateFormat trans = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = trans.parse(d1);
		Date endDate = trans.parse(d2);

		Time time = new Time(null, session.getAttribute("applyCode").toString(),
				session.getAttribute("code").toString(), startDate, endDate, s1, s2, e1, e2);

		shareService.insertShareTime(time);
		
		session.setAttribute("time", "0");
		session.setAttribute("btn", "1");

		return "/shareParkingInfo";
	}

	// @Transactional
	@RequestMapping(value = "/apply.do", method = RequestMethod.GET) // Apply �떊泥�
	public String insertApply(HttpSession session, Model model, @ModelAttribute("command") ShareParkingCommand share) {
		
		// �뱾�뼱�삩 �젙蹂� 湲곕컲�쑝濡� apply �뀒�씠釉붿뿉 �젅肄붾뱶瑜� 異붽��븯�뒗 肄붾뱶
		Apply apply = new Apply();
		apply.setShareParkingCode(share.getShareParkingCode());
		apply.setApplierCode(session.getAttribute("id").toString());
		apply.setWriterCode(share.getWriterId());
		apply.setApproval(0);

		shareService.insertShareApply(apply);

		System.out.println(share.getShareParkingCode() + "  " +  session.getAttribute("id").toString() );
		
		apply = shareService.getApply(share.getShareParkingCode(), session.getAttribute("id").toString()); // �뿬湲곕떎

		session.setAttribute("applyCode", apply.getApplyCode());
		session.setAttribute("time", "1");

		ShareParkingCommand info = new ShareParkingCommand();
		info = shareService.getShareParking(share.getShareParkingCode());

		model.addAttribute("command", share);

		return "/shareParkingInfo";
	}

}
