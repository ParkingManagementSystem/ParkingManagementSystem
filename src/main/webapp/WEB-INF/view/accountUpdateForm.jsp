<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 정보 수정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/button.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/team.css">

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

<script type="text/javascript">
	function delete_confirm() {
		return confirm("정말로 탈퇴하시겠습니까?");
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
						<a href="index.m2?command=main&type=all" style="padding: 30px">MAIN</a>
						<a href="team_list.m2?command=teamList&type=all"
							style="padding: 30px">TEAM</a> <a
							href="user_recommend.m2?command=recommend" style="padding: 30px">PEOPLE</a>
						<!-- MYPAGE / SETTING(ADMIN) -->
						<c:if test="${empty sessionScope.admin}">
							<a href="<c:url value='/account/showAccount.do'/>"
								style="padding: 30px" class="user"> MYPAGE </a>
						</c:if>
						<c:if test="${!empty sessionScope.admin}">
							<a href="<c:url value='/admin/showAccountList.do'/>"
								style="padding: 30px" class="user"> SETTING </a>
						</c:if>

					</div>
				</div>
			</div>
			<hr>
			<div class="content">
<!-- *************************************************** 여기까지 ****************************************************************** -->
	<div>
		<a href="<c:url value='/useList/showUseList.do'/>" class="team_sub_menu">이용내역</a>
		<a href="<c:url value='/shareList/showShareList.do'/>" class="team_sub_menu">나눔내역</a>
	</div>
	<hr/>
	
<!-- *************************************************** Sub Menu Section ****************************************************************** -->

	<form:form commandName="account" method="post">
		* 아이디는 수정하실 수 없습니다.<br/>
		<form:label path="id">아이디</form:label> 
 		<form:input path="id" readonly="true" class="form-control" style="width:250px"/> 
		<form:errors path="id" />
		<br/>
		
		<form:label path="name">이름</form:label>
		<form:input path="name" class="form-control" style="width:250px"/>
		<form:errors path="name" />
		<br/>
		
		<form:label path="gender">성별</form:label> &nbsp;&nbsp;&nbsp;&nbsp;
			남자 <form:radiobutton path="gender" value="m" />&nbsp;&nbsp;&nbsp;&nbsp;
			여자 <form:radiobutton path="gender" value="w" />
			<form:errors path="gender" />
		<br/><br/>
		
		<form:label path="phone">전화변호</form:label>
		<form:input path="phone" class="form-control" style="width:250px" />
		<form:errors path="phone" />
		<br/>
		
		<form:label path="birthday">생일</form:label>
		<form:input type="date" path="birthday" class="form-control" style="width:250px"/>
		<form:errors path="birthday" />
		<br/>
		
		<input type="submit" value="수정하기" class="btn bbtn"  style="width: 250px" />
	</form:form>
<!-- *************************************************** 여기까지 ****************************************************************** -->

			</div>
			<hr>
			<div class="footer" style="clear: both">
				<div class="sitemap">
					<div class="stitle">site map</div>
					<div class="row" style="padding-left: 60px;">
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="index.m2?command=main&type=all">Main</a><br> <a
								href="index.m2?command=main&type=marketing">Marketing</a><br>
							<a href="index.m2?command=main&type=develop">Develop</a><br>
							<a href="index.m2?command=main&type=plan">Plan</a><br> <a
								href="index.m2?command=main&type=culture">Culture</a><br> <a
								href="index.m2?command=main&type=design">Design</a><br>
						</div>
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="team_list.m2?command=teamList&type=all">TEAM</a><br>
							<a href="team_list.m2?command=teamList&type=all">전체 보기</a><br>
							<a href="team_list.m2?command=teamList&type=urgent">마감임박팀</a><br>
							<a href="team_list.m2?command=teamList&type=marketing">Marketing</a><br>
							<a href="team_list.m2?command=teamList&type=develop">Develop</a><br>
							<a href="team_list.m2?command=teamList&type=plan">Plan</a><br>
							<a href="team_list.m2?command=teamList&type=culture">Culture</a><br>
							<a href="team_list.m2?command=teamList&type=design">Design</a><br>
						</div>
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="user_recommend.m2?command=recommend"
								style="padding: 30px">PEOPLE</a><br>
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