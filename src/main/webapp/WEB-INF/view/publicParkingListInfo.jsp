<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����������</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/font.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/team.css">
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
	
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/simpleBanner.js"></script>

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
								<c:out value="${sessionScope.id}" />�� ȯ���մϴ� ^^
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
						<a href="<c:url value='/map/parkingMap.do' />" style="padding: 30px">�غظ�</a>
						
						<a href="<c:url value='/publicParkingList.do?pageNo=1'/>" style="padding: 30px">����������</a> 
						
						<a href="<c:url value='/share/list.do'/>"  style="padding: 30px">��������</a>
						
						<!-- MYPAGE / SETTING(ADMIN) -->
						<c:if test="${empty sessionScope.admin}">
							<a href="<c:url value='/account/showAccount.do'/>"
								style="padding: 30px" class="user"> ���������� </a>
						</c:if>
						<c:if test="${!empty sessionScope.admin}">
							<a href="<c:url value='/admin/showAccountList.do'/>"
								style="padding: 30px" class="user"> ������������ </a>
						</c:if>

					</div>
				</div>
			</div>
			<hr>
			<div class="content">
<!-- ------------------------content---------------------------------- -->

<h1>����������</h1>
<hr>
<center>
		<table class="type09">
		<thead>
		    <tr>
		        <th scope="cols">�׸�</th>
		        <th scope="cols">����</th>
		    </tr>
		    </thead>
		    <tbody>
			<tr>
				<th scope="row">�̸�</th>
				<td>${info.title}</td>
			</tr>
			<tr>
				<th scope="row">�ּ�</th>
				<td>${info.addr}</td>
			</tr>
			<tr>
				<th scope="row">��ȭ��ȣ</th>
				<td>${info.tel}</td>
			</tr>
			<tr>
				<th scope="row"d>���� ���� ���� ��</th>
				<td>${info.capacity}</td>
			</tr>
			<tr>
				<th scope="row">���� �������� ���</th>
				<td>${info.cur_parking}</td>
			</tr>
			<tr>
				<th scope="row">���� � ���۽ð�</th>
				<td>${info.weekday_begin_time}</td>
			</tr>
			<tr>
				<th scope="row">���� � ����ð�</th>
				<td>${info.weekday_end_time}</td>
			</tr>
			<tr>
				<th scope="row">�ָ� � ���۽ð�</th>
				<td>${info.weekend_begin_time}</td>
			</tr>
			<tr>
				<th scope="row">�ָ� � ����ð�</th>
				<td>${info.weekend_end_time}</td>
			</tr>
			<tr>
				<th scope="row">�⺻ ���� �ð�(�� ����)</th>
				<td>${info.time_rate}</td>
			</tr>
			<tr>
				<th scope="row">�⺻ ���� ���</th>
				<td>${info.rates}</td>
			</tr>
			<tr>
				<th scope="row">�߰� ���� �ð�(�� ����)</th>
				<td>${info.add_time_rate}</td>
			</tr>
			<tr>
				<th scope="row">�߰� ���� ���</th>
				<td>${info.add_rates}</td>
			</tr>
			<tr>
				<th scope="row">�� �ִ� ���</th>
				<td>${info.day_maximum}</td>
			</tr>
			<tr>
				<th scope="row">�� ����� �ݾ�</th>
				<td>${info.fulltime_monthly}</td>
			</tr>
			</tbody>
		</table>
	</center>
	
	<!-- ---------------------------------content----------------------------------------- -->

</div>
			<hr>
			<div class="footer" style="clear: both">
				<div class="sitemap">
					<div class="stitle">site map</div>
					<div class="row" style="padding-left: 60px;">
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/map/parkingMap.do' />" style="padding: 30px">�غظ�</a>
						</div>
						
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/publicParkingList.do?pageNo=1'/>" style="padding: 30px">����������</a><br>
						</div>
						
						<div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
							<a href="<c:url value='/share/list.do'/>"  style="padding: 30px">��������</a><br>
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