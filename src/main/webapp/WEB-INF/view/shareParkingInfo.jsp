<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  이미 작성된 공간 나눔 게시글과 관련된 정보를 볼 수 있는 view이다.
	글 작성자는 게시글, 공간 나눔 신청 목록, 댓글을 볼 수 있으며,
	일반 사용자는 게시글, 댓글목록을 볼 수 있고, 공간나눔 신청을 위한 버튼
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>붕붕이를 부탁해 - 주차관리시스템</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/team.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/button.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/simpleBanner.css">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />

<meta http-equiv="imagetoolbar" content="no" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/simpleBanner.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/jquery-ui-i18n.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

<script>

	window.onload=btn_set;
	
	function beforeSubmit(i) {

		var plus = i;
		document.form.action = document.form.action.concat(plus);
		alert(document.form.action + " ");
		alert("신청을 수락했습니다 ");
	}

	function beforeSubmit0() {

		alert("신청이 완료되었습니다");

	}
	
	function btn_set(){
		
		<c:if test="${sessionScope.btn == 1}">
			document.getElementById("b1").style.visibility="hidden";
			document.getElementById("b3").style.visibility="hidden";
			document.getElementById("b2").style.visibility="visible";
		</c:if>
		
		<c:if test="${sessionScope.btn == 2}">
			document.getElementById("b2").style.visibility="hidden";
			document.getElementById("b3").style.disabled = "disabled";
		</c:if>
		
		<c:if test="${sessionScope.btn == 3}">
			document.getElementById("b1").style.visibility="hidden";
			document.getElementById("b3").style.visibility="hidden";
		</c:if>
	}
</script>

<script>
	$(function() {
		//datepicker 한국어로 사용하기 위한 언어설정
		$.datepicker.setDefaults($.datepicker.regional['ko']);

		// 시작일(fromDate)은 종료일(toDate) 이후 날짜 선택 불가
		// 종료일(toDate)은 시작일(fromDate) 이전 날짜 선택 불가

		//시작일.
		$('#fromDate').datepicker({
			//  showOn: "both",                     // 달력을 표시할 타이밍 (both: focus or button)
			dateFormat : "yy-mm-dd", // 날짜의 형식
			changeMonth : true, // 월을 이동하기 위한 선택상자 표시여부
			//minDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이전 날짜 선택 불가)
			onClose : function(selectedDate) {
				// 시작일(fromDate) datepicker가 닫힐때
				// 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
				$("#toDate").datepicker("option", "minDate", selectedDate);
			}
		});

		//종료일
		$('#toDate').datepicker({
			//  showOn: "both", 
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			//minDate: 0, // 오늘 이전 날짜 선택 불가
			onClose : function(selectedDate) {
				// 종료일(toDate) datepicker가 닫힐때
				// 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
				$("#fromDate").datepicker("option", "maxDate", selectedDate);
			}
		});

	});
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
						<a href="<c:url value='/map/parkingMap.do' />"
							style="padding: 30px">붕붕맵</a> <a
							href="<c:url value='/publicParkingList.do?pageNo=1'/>"
							style="padding: 30px">공영주차장</a> <a
							href="<c:url value='/share/list.do'/>" style="padding: 30px">공간나눔</a>

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
				<!-- *************************************************** 여기까지 ****************************************************************** -->


				<h2>공간나눔 게시글</h2>
				<hr>
				<br />
				<br />

				<form name="f" class="form-horizontal" method="POST">
					<div class="form-group">
						<label for="title" class="col-sm-2">글 제목</label>
						<div class="col-sm-10">${command.title}</div>
						<br />
					</div>
					<div class="form-group">
						<label for="parkingName" class="col-sm-2">주차장 이름</label>
						<div class="col-sm-10">${command.parkingName}</div>
						<br />
					</div>
					<div class="form-group">
						<label for="writerId" class="col-sm-2">등록한 사람</label>
						<div class="col-sm-10">${command.writerId}</div>
						<br />
					</div>
					<div class="form-group">
						<label for="address" class="col-sm-2">주소</label>
						<div class="col-sm-10">${command.address}</div>
						<br />
					</div>
					<div class="form-group">
						<label for="gu" class="col-sm-2">구</label>
						<div class="col-sm-10">${command.gu}</div>
						<br />
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2">핸드폰 번호</label>
						<div class="col-sm-10">${command.phone}</div>
						<br />
					</div>
					<div class="form-group">
						<label for="carType" class="col-sm-2">주차 가능한 차 타입</label>
						<div class="col-sm-10">${command.carType}</div>
						<br />
					</div>
					<div class="form-group">
						<label for="cost" class="col-sm-2">1시간 당 가격</label>
						<div class="col-sm-10">${command.cost}</div>
						<br />
					</div>
					<div class="form-group">
						<label for="content" class="col-sm-2">글 내용 </label>
						<div class="col-sm-10">${command.content}</div>
						<br />
					</div>

		<img src="${pageContext.request.contextPath}/DisplayBlobExample?code=${command.shareParkingCode}" width="300px"></img>
				</form>

				<br /> <br />
				<br /> <br />


				<!-- 다른 사람이 올린 게시글에 가면 공간 나눔 신청 가능  && 신청 버튼 누르기 전에는 신청버튼이 보인다.  버튼들 -->
				<c:if test="${sessionScope.id != command.writerId}">
				<center>
					<form method="GET" action="apply.do?code=${command.shareParkingCode}" >
						<c:if test="${sessionScope.time != 1}">
						<input class="btn sbtn" type="submit" value="나눔신청" id="b1" onClick="btn_set()"/>&nbsp;
						<input class="btn cbtn" type="button" value="승인대기중" id="b2"/>&nbsp;
						<input class="btn bbtn" type="button" value="승인완료" id="b3"/>
						</c:if>
					</form>
				</center>
				</c:if>


				<!-- 타임 테이블 작성할 수 있는 폼 출력  -->
				<c:if test="${sessionScope.time == 1}">
					<input class="btn btn-info" type="submit" value="주차장 이용 기간 입력"
						disabled="disabled" />
					<br /><br /><br /><br />

					<form method="POST" action="apply.do">
						<div class="form-group">
							<div class="col-sm-1">기간</div>
							<div class="col-sm-2">시작 날짜</div>
							<div class="col-sm-2">
								<input name="startDate" id="fromDate" size="10"
									class="form-control">
							</div>
							<div class="col-sm-2">종료 날짜</div>
							<div class="col-sm-2">
								<input type="text" name="endDate" id="toDate" size="10"
									class="form-control" />
							</div>
							<br /><br />

							<div class="col-sm-1">이용 시각</div>
							<div class="col-xs-2">시작 시각</div>
							<div class="col-xs-1">
								<input type="text" class="form-control" name="startHour" />
							</div>
							<div class="col-xs-1">
								<input type="text" class="form-control" name="startMinute" />
							</div>

							<div class="col-xs-2">종료 시각</div>
							<div class="col-xs-1">
								<input type="text" class="form-control" name="endHour" />
							</div>
							<div class="col-xs-1">
								<input type="text" class="form-control" name="endMinute" />
							</div>
							<br /><br />

						</div>

						<br /><br /><br /><br /> 
						<input type="submit" value="제출하기 " class="btn btn-info"
							onClick="beforeSubmit0()" />
					</form>
				</c:if>

				<!-- ★글 작성자가 자신이 작성한 글에 들어왔다면 신청자 목록을 보여준다  승인누르면 정보가지고 떠나기 -->
				
				<br/> <br/><br/>
				<c:if test="${sessionScope.id == command.writerId}">
				
					<br/><br/>
					<c:if test="${ fn:length(applyList) >= 1 }">  
					<input type="button" value="신청자리스트 " class="btn btn-info" disabled="disabled" />
					</c:if>
					<br/><br/><br/>
						
					<table class="table table-condensed" width="300px" cellpadding="20px" >
						<c:forEach var="list" items="${applyList}">
							<!--  신청자 목록  -->
							<tr>
								<td>ID : ${list.applierCode}</td>
								<td>기간 :&nbsp; 2017- ${list.time.startDate.month} -
									${list.time.startDate.day} ~ 2017- ${list.time.endDate.month} -
									${list.time.endDate.day}</td>
								<td>이용시간 :&nbsp; ${list.time.startHour} 시 ${list.time.startMinute}분 ~
									${list.time.endHour} 시 ${list.time.endMinute}분</td>
								<td>

									<form action="accept.do">
										<input type="hidden" name="parkingName" value="${command.parkingName}"> <input type="hidden" name="renter" value="${list.applierCode}"> 
										<input type="hidden" name="applyCode" value="${list.applyCode}">
										<c:if test="${list.approval == 0}">
											<input type="submit" value="승인하기 " class="btn btn-info" onClick="beforeSubmit(1)" />
											<br />
											<br />
										</c:if>
										<c:if test="${list.approval== 1}">
											<input type="submit" value="승인완료 " class="btn btn-info" disabled="disabled" />
											<br />
											<br />
										</c:if>
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>

				<!-- *************************************************** 여기까지 ****************************************************************** -->
			<br /><br /><br />
			</div>
			<hr>
			<div class="footer" style="clear: both">
				<div class="sitemap">
					<div class="stitle">site map</div>
					<div class="row" style="padding-left: 60px;">
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/map/parkingMap.do' />"
								style="padding: 30px">붕붕맵</a>
						</div>

						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/publicParkingList.do?pageNo=1'/>"
								style="padding: 30px">공영주차장</a><br>
						</div>

						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/share/list.do'/>" style="padding: 30px">공간나눔</a><br>
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