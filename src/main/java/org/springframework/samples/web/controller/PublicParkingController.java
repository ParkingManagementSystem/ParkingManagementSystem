package org.springframework.samples.web.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.domain.PublicParking;
import org.springframework.samples.web.domain.Rating;
import org.springframework.samples.web.domain.RatingHistory;
import org.springframework.samples.web.domain.Reply;
import org.springframework.samples.web.domain.Use;
import org.springframework.samples.web.service.ParkingParserImpl;
import org.springframework.samples.web.service.PublicParkingService;
import org.springframework.samples.web.service.ReplyService;
import org.springframework.samples.web.service.UseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PublicParkingController {
	
	@Autowired
	private ParkingParserImpl parser;
	
	@Autowired
	private PublicParkingService publicParkingService;
	
	@Autowired
	private UseService useService;
	
	@Autowired
	private ReplyService replyService;
	
	public ArrayList<PublicParking> parsingresult() {
		ArrayList<PublicParking> a = new ArrayList<PublicParking>();
		a = parser.apiParserSearch();
		return a;
	}
	
	
	@RequestMapping("/publicPatkingReplyDelete.do")
	public ModelAndView publicPatkingReplyDelete(@RequestParam("code") String code, HttpServletRequest request
			,HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		String replyCode = Integer.toString(Integer.parseInt(request.getParameter("replyCode")));
		replyService.deleteReply(replyCode);
		
		String url = "publicParkingListInfo.do?code=" + code;
		mav.setView(new RedirectView(url));
		
		return mav;
	} 
	
	
	@RequestMapping("/publicPatkingReply.do")
	public ModelAndView publicPatkingReply(@RequestParam("code") String code, HttpServletRequest request
			,HttpSession session) {
		Calendar calendar = Calendar.getInstance();
		String year = calendar.get(Calendar.YEAR) + "-";
		String month = (calendar.get(Calendar.MONTH)+1) +"-";
		String day = calendar.get(Calendar.DAY_OF_MONTH) + " ";
		String hour = calendar.get(Calendar.HOUR) + "시 ";
		String min = calendar.get(Calendar.MINUTE) + "분";
		
		String time = year + month + day + hour + min;
		
		ModelAndView mav = new ModelAndView();
		Reply reply = new Reply();
		
		reply.setContent(request.getParameter("content"));
		reply.setPublicParkingCode(code);
		reply.setSecret(0);
		reply.setReplywriterid(session.getAttribute("id").toString());
		reply.setTime(time);
//		
//		int count;
//		
//		if(replyService.selectReplyCount(code).equals(""))
//			count = 1;
//		else
//			count = Integer.parseInt(replyService.selectReplyCount(code)) + 1;
//		
//		reply.setCount(Integer.toString(count));
		
		replyService.insertReply(reply);
		
		String url = "publicParkingListInfo.do?code=" + code;
		
		mav.setView(new RedirectView(url));
		
		return mav;
	}
	
	
	
	@RequestMapping("/publicParkingListRating.do")
	public ModelAndView publicParkingListRating(@RequestParam("code") String code, HttpServletRequest request
			,HttpSession session) {
		
		
		//별점정보 insert
		Use use = new Use();
		use.setPublicParkingCode(code);
		use.setParkingName(request.getParameter("title")); //주차장 이름
		use.setCost(Integer.parseInt(request.getParameter("cost"))); //사용금액
		use.setPublicRating(Integer.parseInt(request.getParameter("star"))); //별점
		use.setRenter(session.getAttribute("id").toString()); //사용자
		
		useService.insertPublicParkingRating(use);
		
		RatingHistory ratingHistory = new RatingHistory();
		ratingHistory.setPublicparkingcode(code);
		ratingHistory.setRating(Integer.parseInt(request.getParameter("star")));
		ratingHistory.setId(session.getAttribute("id").toString());
		
		publicParkingService.insertPublicRating(ratingHistory);
		
		
		ModelAndView mav = new ModelAndView("publicParkingListInfo");
		ArrayList<PublicParking> a = parsingresult();
		PublicParking publicParking = new PublicParking();
		
		
		int i = 0;
		for(i = 0 ; i<a.size() ; i++)
		{
			if(a.get(i).getCode().equals(code))
			{
				publicParking = a.get(i);
				if(a.get(i).getStatus().equals("0"))
					publicParking.setCur_parking("미연계");
				publicParking.setAvg_rate(publicParkingService.selectAvgRate(code));
			}
		}
		
		mav.addObject("info", publicParking);
		
		return mav;
	}
	
	
	@RequestMapping("/publicPatkingRating.do")
	public ModelAndView publicParkingRating(HttpServletRequest request) {
		int time_rate = Integer.parseInt(request.getParameter("time_rate")); //기준시간(분)
		int rates = Integer.parseInt(request.getParameter("rates")); //기준시간 당 요금
		int day_maximum = Integer.parseInt(request.getParameter("day_maximum"));//일 최대 요금
		int fulltime_monthly = Integer.parseInt(request.getParameter("fulltime_monthly"));//월 정기 요금	
		int payment;
		String chk_info = request.getParameter("chk_info");
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("publicParkingRating");
		Rating rating = new Rating();
		
		Date dateStartday = null;
		Date dateEndday = null;
		DateFormat dateFormat = new SimpleDateFormat("yy-mm-dd");
		
		String startday=request.getParameter("startday");
		String endday=request.getParameter("endday");
		
		int starttimeHour=Integer.parseInt(request.getParameter("starttimeHour"));
		int starttimeMin = Integer.parseInt(request.getParameter("starttimeMin"));
		int endtimeHour=Integer.parseInt(request.getParameter("endtimeHour"));
		int endtimeMin=Integer.parseInt(request.getParameter("endtimeMin"));
		
		try {
			dateStartday = dateFormat.parse(startday);
			dateEndday = dateFormat.parse(endday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//요금계산
		long diff = dateEndday.getTime() - dateStartday.getTime();
		int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		int diffMonth = diffDays / 30;
		
		switch(chk_info)
		{
		case "일 정기권":
			payment = diffDays * day_maximum;
			break;
		case "월 정기권":
			payment = diffMonth * fulltime_monthly;
			break;
		case "해당없음":
			if(0 <= diffDays && diffDays <= 30)
			{	
				int startTime = starttimeHour * 60 + starttimeMin;
				int endTime = endtimeHour * 60 + endtimeMin;
				
				if(endTime<startTime)
				{
					int buff = endTime;
					endTime = startTime;
					startTime = buff;
				}
				
				int MinRating = (endTime - startTime) / time_rate;
				
				if(MinRating % time_rate != 0)
					MinRating = MinRating + 1;
				
				payment = (int) ((diffDays * day_maximum) + (MinRating * rates));
				if(diffDays == 0)
				{
					if(payment > day_maximum) payment = day_maximum;
				}
			}
			else
			{	
				diffDays = diffDays - (diffMonth * 30);
				
				int startTime = starttimeHour * 60 + starttimeMin;
				int endTime = endtimeHour * 60 + endtimeMin;
				
				if(endTime<startTime)
				{
					int buff = endTime;
					endTime = startTime;
					startTime = buff;
				}
				
				int MinRating = (endTime - startTime) / time_rate;
				
				if(MinRating % time_rate != 0)
					MinRating = MinRating + 1;
				
				payment = (int) (diffMonth * fulltime_monthly + diffDays * day_maximum + MinRating * rates);
			}
			break;
			default:
				payment = 0;
		}
		
		rating.setPayment(payment);
		rating.setStartday(startday);
		rating.setEndday(endday);
		rating.setStarttimeHour(starttimeHour);
		rating.setStarttimeMin(starttimeMin);
		rating.setEndtimeHour(endtimeHour);
		rating.setEndtimeMin(endtimeMin);
		rating.setChk_info(request.getParameter("chk_info"));
		rating.setTitle(request.getParameter("title"));
		rating.setStar(Integer.parseInt(request.getParameter("star")));
		rating.setCode(request.getParameter("code"));
		mav.addObject("rating", rating);
		return mav;
	}
	
	@RequestMapping("/publicParkingListPageIndexback.do")
	public ModelAndView publicParkingListPageIndexback(@RequestParam("pageNo") String pageNo) {
		ModelAndView mv = new ModelAndView();
		int page = Integer.parseInt(pageNo);
		String url = "publicParkingListPage.do?pageNo=";
		if(page/10==0)
			url += pageNo;
		else
		{
			page = page - (page%10 + 1);
			url += Integer.toString(page);
		}
		mv.setView(new RedirectView(url));
		return mv;
	}
	
	@RequestMapping("/publicParkingListPageIndexfront.do")
	public ModelAndView publicParkingListPageIndexfront(@RequestParam("pageNo") String pageNo) {
		ModelAndView mv = new ModelAndView();
		int page = Integer.parseInt(pageNo);
		String url = "publicParkingListPage.do?pageNo=";
		if(page/10 == 9)
			url += pageNo;
		else
		{
			page = page - page%10 + 1;
			url += Integer.toString(page);
		}
		mv.setView(new RedirectView(url));
		return mv;
	}
	
	@RequestMapping("/publicParkingListPage.do")
	public ModelAndView publicParkingListPage(@RequestParam("pageNo") String pageNo) {
		ModelAndView mav = new ModelAndView("publicParkingList");
		ArrayList<PublicParking> a = parsingresult();
		ArrayList<PublicParking> result = new ArrayList<PublicParking>();
		
		int page = a.size()/10+1;
		mav.addObject("page", page);
		
		int index = page/10;
		if(index % 10 != 0) index = index+1;
		
		int cur_index;
		int cur_page;
		
		if(pageNo.isEmpty())
		{
			cur_page = 1;
			cur_index = 1;
		}
		else
		{
			cur_page = Integer.parseInt(pageNo);
			cur_index = Integer.parseInt(pageNo)/10 + 1;
		}

		int j = 1;
		for(j=1;j<=page;j++)
		{
			if(cur_page == j)
			{
				mav.addObject("page", cur_page);
				int start = (j*10) - 9;
				int last = j*10;
				if(last > a.size()) last = a.size() - 1;
				for(int k = start ; k<=last ; k++ )
					result.add(a.get(k));
				break;
			}
		}
		int page_all = cur_index*10;
		if(page_all > page) page_all = page;
		int page_all_start=page_all-9;
		mav.addObject("page_all", page_all);
		mav.addObject("page_all_start", page_all_start);
		mav.addObject("list", result);
		
		return mav;
	}
	
	
	@RequestMapping("/publicParkingList.do")
	public ModelAndView publicParkingList(@RequestParam("pageNo") String pageNo) {
		ModelAndView mav = new ModelAndView("publicParkingList");
		ArrayList<PublicParking> a = parsingresult();
		ArrayList<PublicParking> result = new ArrayList<PublicParking>();
		
		for(int i=0 ; i<a.size() ; i++)
		{
			if(a.get(i).getAddr().equals(publicParkingService.selectAddr(a.get(i).getAddr())))
				continue;
			else if(a.get(i).getCode().equals(publicParkingService.selectId(a.get(i).getCode())))
				publicParkingService.insertPublicParking(a.get(i));
			else
				publicParkingService.insertPublicParking(a.get(i));
		}
		
		
		int page = a.size()/10+1;
		mav.addObject("page", page);
		
		int index = page/10;
		if(index % 10 != 0) index = index+1;
		
		int cur_index;
		int cur_page;
		if(pageNo.isEmpty())
		{
			cur_page = 1;
			cur_index = 1;
		}
		else
		{
			cur_page = Integer.parseInt(pageNo);
			cur_index = Integer.parseInt(pageNo)/10 + 1;
		}

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
		int page_all = cur_index*10;
		if(page_all > page) page_all = page;
		int page_all_start=page_all-9;
		mav.addObject("page_all", page_all);
		mav.addObject("page_all_start", page_all_start);
		mav.addObject("list", result);
		
		return mav;
	}
	

	
	@RequestMapping(value = "/publicParkingListInfo.do")
	public ModelAndView publicParkingListInfo(@RequestParam("code") String code) {
		ModelAndView mav = new ModelAndView("publicParkingListInfo");
		
		//댓글객체
		List<Reply> replyList = new ArrayList<Reply>();
		
		ArrayList<PublicParking> a = parsingresult();
		PublicParking publicParking = new PublicParking();
		replyList = replyService.publicListReply(code);
		
		int i = 0;
		for(i = 0 ; i<a.size() ; i++)
		{
			if(a.get(i).getCode().equals(code))
			{
				publicParking = a.get(i);
				if(a.get(i).getStatus().equals("0"))
					publicParking.setCur_parking("미연계");
				if(a.get(i).getTel().equals(""))
					publicParking.setTel("미연계");
				publicParking.setAvg_rate(publicParkingService.selectAvgRate(code));
			}
		}
		
		
		mav.addObject("info", publicParking);
		mav.addObject("reply", replyList);
        
		return mav;
	}
	

}
