
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>공영주차장</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/font.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/team.css">
		<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/reply.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/simpleBanner.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/publicParking.css">
	
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
		integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
		crossorigin="anonymous">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
		integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
		crossorigin="anonymous">

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>
		
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
		<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/simpleBanner.js"></script>
	
	
	<!-- date picker 스크립트 -->
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

        <!-- jQuery UI 국제화 대응을 위한 라이브러리 (다국어) -->
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/jquery-ui-i18n.min.js"></script>

        <!-- datepicker 한국어로 -->
        <!-- <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script> -->
        <script>
        $(function() {
            //datepicker 한국어로 사용하기 위한 언어설정
            $.datepicker.setDefaults($.datepicker.regional['ko']); 
            
            // 시작일(fromDate)은 종료일(toDate) 이후 날짜 선택 불가
            // 종료일(toDate)은 시작일(fromDate) 이전 날짜 선택 불가

            //시작일.
            $('#fromDate').datepicker({
              //  showOn: "both",                     // 달력을 표시할 타이밍 (both: focus or button)
                dateFormat: "yy-mm-dd",             // 날짜의 형식
                changeMonth: true,                  // 월을 이동하기 위한 선택상자 표시여부
                //minDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이전 날짜 선택 불가)
                onClose: function( selectedDate ) {    
                    // 시작일(fromDate) datepicker가 닫힐때
                    // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                    $("#toDate").datepicker( "option", "minDate", selectedDate );
                }                
            });

            //종료일
            $('#toDate').datepicker({
              //  showOn: "both", 
                dateFormat: "yy-mm-dd",
                changeMonth: true,
                //minDate: 0, // 오늘 이전 날짜 선택 불가
                onClose: function( selectedDate ) {
                    // 종료일(toDate) datepicker가 닫힐때
                    // 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
                    $("#fromDate").datepicker( "option", "maxDate", selectedDate );
                }                
            });
            
        });
        
        </script>
        
        <!-- timepicker -->
        
        <script>
        $(function() {
	        $('#timepickerHour').timepicker({
	            timeFormat: 'h',
	            interval: 1,
	            minTime: '0',
	            maxTime: '11:59pm',
	            defaultTime: '12',
	            startTime: '10:00',
	            dynamic: false,
	            dropdown: true,
	            scrollbar: true
	        });
        });
        </script>
	
	<!-- 별점 스크립트 -->
	<script>
	var locked = 0;

	function show(star) 
	{
	    if (locked) {
	    	locked = 0;
	    	for (i=1; i<=star; i++) {
		        image = 'image' + i;
		        el = document.getElementById(image);
		        el.src="${pageContext.request.contextPath}/resources/images/star_blank.png";
		    }
	    }
	    var i;
	    var image;
	    var el;
	  var e = document.getElementById('ratetext');
	  var StateMSG;

	    for (i=1; i<=star; i++) {
	        image = 'image' + i;
	        el = document.getElementById(image);
	        el.src="${pageContext.request.contextPath}/resources/images/star.png";
	    }

	  switch (star) {
	   case 1:
	    StateMSG = "1점";
	    break;
	   case 2:
	    StateMSG = "2점";
	    break;
	   case 3:
	    StateMSG = "3점";
	    break;
	   case 4:
	    StateMSG = "4점";
	    break;
	   case 5:
	    StateMSG = "5점";
	    break;
	   default:
	    StateMSG = "";
	  }
	  e.innerHTML = StateMSG;
	}

	function noshow(star)
	{
	    if (locked) return;
	    var i;
	    var image;
	    var el;
	 
	    for (i=1; i<=star; i++) {
	        image = 'image' + i;
	        el = document.getElementById(image);
	        el.src="${pageContext.request.contextPath}/resources/images/star_blank.png";
	    }
	}

	function lock(star)
	{
	    show(star);
	    locked = 1;
	}

	function mark(star)
	{
	    //show(imagenr);
	    //locked = 1;
	    lock(star);
	    document.cmtform.star.value=star;
	}
	</script>
	
</head>
<body>
	<div class="row">
		<div class="col-md-2 col-xs-2 col-sm-2 col-lg-2"></div>
		<div class="col-md-8 col-xs-8 col-sm-8 col-lg-8">
			<div class="header">
				<div class="row">
					<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3">
						<!-- LOGO IMAGE -->
						<a href="/ParkingManagementSystem/index"><img
							src="${pageContext.request.contextPath}/resources/images/icon.png"
							height=80px></a>
					</div>

					<div class="col-md-9 col-xs-9 col-sm-9 col-lg-9 subtitle">
						<!-- LOGIN -->
						<c:if test="${!empty sessionScope.id}">
							<span
								style='font-size: 15px; padding-right: 10px; color: #8babd6; font-family: Jeju Gothic'>
								<c:out value="${sessionScope.id}" />님 환영합니다 ^^
							</span>
						</c:if>

						<c:if test="${empty sessionScope.id}">
							<a href="<c:url value='/signIn/signInForm.do' />"
								style='font-size: 15px; padding-right: 30px;'>login</a>
							<br>
						</c:if>
						<!-- LOGIN -->
						<c:if test="${!empty sessionScope.id}">
							<a href="<c:url value='/signOut/signOut.do' />"
								style='font-size: 15px; padding-right: 30px;'>logout</a>
							<br>
						</c:if>
						<br>

						<!-- MAIN MENU -->
						<a href="<c:url value='/map/parkingMap.do' />" style="padding: 30px">붕붕맵</a>
						
						<a href="<c:url value='/publicParkingList.do?pageNo=1'/>" style="padding: 30px">공영주차장</a> 
						
						<a href="<c:url value='/share/list.do'/>"  style="padding: 30px">공간나눔</a>
						
						<!-- MYPAGE / SETTING(ADMIN) -->
						<c:if test="${empty sessionScope.admin}">
							<a href="<c:url value='/account/showAccount.do'/>"
								style="padding: 30px" class="user"> 마이페이지 </a>
						</c:if>
						<c:if test="${!empty sessionScope.admin}">
							<a href="<c:url value='/admin/showAccountList.do'/>"
								style="padding: 30px" class="user"> 관리자페이지 </a>
						</c:if>

					</div>
				</div>
			</div>
			<hr>
			<div class="content">
<!-- ------------------------content---------------------------------- -->

<h1>공영주차장</h1>
<hr>
<div class="dd">
<div class="table_left">
<h2>정보</h2>
		<table class="type09">
		<thead>
		    <tr>
		        <th scope="cols">항목</th>
		        <th scope="cols">내용</th>
		    </tr>
		    </thead>
		    <tbody>
		    <tr>
				<th scope="row">별점</th>
				<td>${info.avg_rate}</td>
			</tr>
			<tr>
				<th scope="row">이름</th>
				<td>${info.title}</td>
			</tr>
			<tr>
				<th scope="row">주소</th>
				<td>${info.addr}</td>
			</tr>
			<tr>
				<th scope="row">전화번호</th>
				<td>${info.tel}</td>
			</tr>
			<tr>
				<th scope="row"d>주차 가능 차량 수</th>
				<td>${info.capacity}</td>
			</tr>
			<tr>
				<th scope="row">현재 주차중인 대수</th>
				<td>${info.cur_parking}</td>
			</tr>
			<tr>
				<th scope="row">평일 운영 시작시간</th>
				<td>${info.weekday_begin_time}</td>
			</tr>
			<tr>
				<th scope="row">평일 운영 종료시간</th>
				<td>${info.weekday_end_time}</td>
			</tr>
			<tr>
				<th scope="row">주말 운영 시작시간</th>
				<td>${info.weekend_begin_time}</td>
			</tr>
			<tr>
				<th scope="row">주말 운영 종료시간</th>
				<td>${info.weekend_end_time}</td>
			</tr>
			<tr>
				<th scope="row">기본 주차 시간(분 단위)</th>
				<td>${info.time_rate}</td>
			</tr>
			<tr>
				<th scope="row">기본 주차 요금</th>
				<td>${info.rates}</td>
			</tr>
			<tr>
				<th scope="row">추가 단위 시간(분 단위)</th>
				<td>${info.add_time_rate}</td>
			</tr>
			<tr>
				<th scope="row">추가 단위 요금</th>
				<td>${info.add_rates}</td>
			</tr>
			<tr>
				<th scope="row">일 최대 요금</th>
				<td>${info.day_maximum}</td>
			</tr>
			<tr>
				<th scope="row">월 정기권 금액</th>
				<td>${info.fulltime_monthly}</td>
			</tr>
			</tbody>
		</table>
		</div>
		<br/>
	
	
	
	
	<!-- 사용내역, 금액계산, 별점 -->
	<div class="table_right">
	<h2>사용내역 등록</h2>
	<form action="publicPatkingRating.do" method="post" name="cmtform">
 	<table class="type09">
		<thead>
		    <tr>
		        <th scope="cols" width="30%">항목</th>
		        <th scope="cols">내용</th>
		    </tr>
		    </thead>
		    <tbody>
		    <tr>
				<th scope="row">시작일</th>
				<td>날짜 : <input name="startday" type="text" id="fromDate" size="7"/> &nbsp;
					<input name="starttimeHour" type="text" id="timepickerHour" size="3"/>시 
					<input name="starttimeMin" type="text" size="3"/>분
				</td>
			</tr>
			<tr>
				<th scope="row">종료일</th>
				<td>날짜 : <input name="endday" type="text" id="toDate" size="7"/> &nbsp;
					<input name="endtimeHour" type="text" size="3"/>시 
					<input name="endtimeMin" type="text" size="3"/>분
				</td>
			</tr>
			<tr>
				<th scope="row">정액제 항목</th>
				<td>
					<input type="radio" name="chk_info" value="일 정기권"/>일 정기권&nbsp;
					<input type="radio" name="chk_info" value="월 정기권"/>월 정기권&nbsp;
					<input type="radio" name="chk_info" value="해당없음" checked="checked"/>해당없음
				</td>
			</tr>
	<!-- 		<tr>
				<th scope="row">사용금액</th>
				<td></td>
			</tr> -->
			<tr>
				<th scope="row">별점</th>
				<td>
    				<img id=image1 onmouseover=show(1) onclick=mark(1) onmouseout=noshow(1) src="${pageContext.request.contextPath}/resources/images/star_blank.png">
    				<img id=image2 onmouseover=show(2) onclick=mark(2) onmouseout=noshow(2) src="${pageContext.request.contextPath}/resources/images/star_blank.png">
    				<img id=image3 onmouseover=show(3) onclick=mark(3) onmouseout=noshow(3) src="${pageContext.request.contextPath}/resources/images/star_blank.png">
    				<img id=image4 onmouseover=show(4) onclick=mark(4) onmouseout=noshow(4) src="${pageContext.request.contextPath}/resources/images/star_blank.png">
    				<img id=image5 onmouseover=show(5) onclick=mark(5) onmouseout=noshow(5) src="${pageContext.request.contextPath}/resources/images/star_blank.png">
   					<span id=ratetext>평가하기</span>
 					<input type="hidden" name="star"/>
				</td>
			</tr>
			</tbody>
		</table>
		
		<br/>
		<input type="hidden" name="title" value="${info.title}"/>
		<input type="hidden" name="code" value="${info.code}"/>
		<input type="hidden" name="time_rate" value="${info.time_rate}"/>
		<input type="hidden" name="rates" value="${info.rates}"/>
		<input type="hidden" name="day_maximum" value="${info.day_maximum}"/>
		<input type="hidden" name="fulltime_monthly" value="${info.fulltime_monthly}"/>
 		<input type="submit" name="submit" value="완료"/>
 	</form>
 	</div>
 	</div>
 	<br/>
 	<hr>
 	<div class="reply">
 	<h3>댓글</h3>
 	<form action="publicPatkingReply.do?code=${info.code}" method="post" name="replyForm">
		  <div class="form-group">
		    <label for="reply">댓글 내용</label>
		    <textarea class="form-control" rows="3" name="content" placeholder="댓글을 입력하세요."></textarea>
		  </div>
		  <button type="submit" class="btn btn-default">작성하기</button>
	</form>
	<hr>
	<h3>댓글 목록</h3>
	<form action="publicPatkingReplyDelete.do?code=${info.code}" method="post" name="replyInfo"> 
	<table class="table table-striped">
	<thead>
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>내용</td>
			<td>작성시간</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
 		<c:forEach items="${reply}" varStatus="status" var="reply">
			<tr>
				<td>${status.count}</td>
				<td>${reply.replywriterid}</td>
				<td>${reply.content}</td>
				<td>${reply.time}</td>
				<input type="hidden" name="replyCode" value="${reply.replyCode}"/>
				<td>
				<c:if test="${sessionScope.id == reply.replywriterid}">
        			<input type="submit" id="btnDelete" value="삭제"/>
    			</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</form>
	</div>
	
	<!-- ---------------------------------content----------------------------------------- -->

</div>
			<hr>
			<div class="footer" style="clear: both">
				<div class="sitemap">
					<div class="stitle">site map</div>
					<div class="row" style="padding-left: 60px;">
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/map/parkingMap.do' />" style="padding: 30px">붕붕맵</a>
						</div>
						
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/publicParkingList.do?pageNo=1'/>" style="padding: 30px">공영주차장</a><br>
						</div>
						
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/share/list.do'/>"  style="padding: 30px">공간나눔</a><br>
						</div>
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<c:if test="${empty sessionScope.admin}">
								<a href="<c:url value='/account/showAccount.do'/>"
									style="padding: 30px"> MYPAGE </a>
							</c:if>
							<c:if test="${!empty sessionScope.admin}">
								<a href="<c:url value='/admin/showAccountList.do'/>"
									style="padding: 30px"> SETTING </a>
							</c:if>
						</div>
					</div>
				</div>

				<hr>
				<div class="copyright" style="text-align: center">copyright
					&copy; 2017 by BOONGBOONG2</div>
			</div>
		</div>
		<div class="col-md-2 col-xs-2 col-sm-2 col-lg-2"></div>
	</div>
</body>
</html>