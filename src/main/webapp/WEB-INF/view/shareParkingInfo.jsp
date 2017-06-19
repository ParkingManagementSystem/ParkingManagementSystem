<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
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

<meta http-equiv="imagetoolbar" content="no" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/simpleBanner.js"></script>

<c:set var="isApply"  value = "0"/>

<script>
	function check(){
		//alert('신청이 완료되었습니다');
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
<!-- *************************************************** 여기까지 ****************************************************************** -->


	<h2> 공간나눔 게시글 </h2><br/>
	
	<form name="f" class="form-horizontal" method="POST">
	<div class="form-group">
		<label for="title" class="col-sm-2">글 제목</label>
		<div class="col-sm-10"> ${command.title}</div><br/>
	</div>
	<div class="form-group">
		<label for="parkingName" class="col-sm-2">주차장 이름</label>
		<div class="col-sm-10"> ${command.parkingName}</div><br/>
	</div>	
	<div class="form-group">
		<label for="writerId" class="col-sm-2">등록한 사람</label>
		<div class="col-sm-10"> ${command.writerId}</div><br/>
	</div>	
	<div class="form-group">
		<label for="address" class="col-sm-2">주소</label>
		<div class="col-sm-10"> ${command.address}</div><br/>
	</div>	
	<div class="form-group">
		<label for="gu" class="col-sm-2">구</label>
		<div class="col-sm-10"> ${command.gu}</div><br/>
	</div>	
	<div class="form-group">
		<label for="phone" class="col-sm-2">핸드폰 번호</label>
		<div class="col-sm-10"> ${command.phone}</div><br/>
	</div>
	<div class="form-group">
		<label for="carType" class="col-sm-2">주차 가능한 차 타입</label>
		<div class="col-sm-10"> ${command.carType}</div><br/>
	</div>
	<div class="form-group">
		<label for="cost" class="col-sm-2">1시간 당 가격</label>
		<div class="col-sm-10"> ${command.cost}</div><br/>
	</div>
	<div class="form-group">
		<label for="content" class="col-sm-2">글 내용 </label>
		<div class="col-sm-10"> ${command.content}</div><br/>
	</div>
	
	</form>
	
	<br/> <br/>
	

	<!-- 다른 사람이 올린 게시글에 가면 공간 나눔 신청 가능  && 신청 버튼 누르기 전에는 신청버튼이 보인다. --> 
	<c:if test="${sessionScope.id != command.writerId}">
		<form method="GET" action="apply.do?code=${command.shareParkingCode}">
			<input class="btn btn-info" type="submit" value="신청" onClick="check()"/>
		</form>
	</c:if>
	
	<!-- 타임 테이블 작성할 수 있는 폼 보인다  --> 
	<c:if test="${isApply == 1}">
		<form method="POST" action="apply.do?code=${command.shareParkingCode}">
			응~~ 
		</form>
	</c:if>
	
	<!-- 글 작성자가 자신이 작성한 글에 들어왔다면 신청자 목록을 보여준다 -->
	<c:if test="${sessionScope.id == command.writerId}">
		<table>
		<tr><td>신청자</td>
		<c:forEach var="list" items="${applyList}">
			<tr><td> 		${list.applierCode}
			</td></tr>
		</c:forEach>
	
	</table>
	</c:if>
	
<!-- *************************************************** 여기까지 ****************************************************************** -->

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