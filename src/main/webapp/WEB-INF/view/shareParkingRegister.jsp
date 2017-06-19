<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <!--  공간 나눔 게시글을 새로 작성 -->
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

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=21b2fc9f251dee472597fc087fcdb828&libraries=services"></script>

<script> <!-- 주소로 위도 경도 받아오기 -->

//주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

function getLocation() {
// 주소로 좌표를 검색합니다
	
	var location = document.getElementById("gu").value;
	location = location.concat(" ");
	location = location.concat(document.getElementById("address").value);

	geocoder.addr2coord(location, function(status, result) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
       
		document.getElementById("altitude").value = result.addr[0].lat;
		document.getElementById("longitude").value = result.addr[0].lng;
		
     }
    
    document.form.submit();
   
    })};

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
			<div class="margin_bottom">
				<span class="btitle"> 공간나눔 글 등록 </span> <br>
				<span class="bcontent">각 항목을 모두 입력해주세요~ </span>
			</div>

	<br/><br/>
	<form:form commandName="command" method="post" class="form-horizontal" name="form">
	
	<div class="form-group">
		<form:label path="title" class="col-sm-2"> 글 제목 </form:label>
		<div class="col-sm-5">
		<form:input path="title"  class="form-control"/><br/>
		</div>
	</div>
			
	<div class="form-group">
		<form:label path="parkingName" class="col-sm-2"> 주차장 이름 </form:label>
		<div class="col-sm-5">
		<form:input path="parkingName"  class="form-control"/><br/>
		</div>
	</div>
	
	<div class="form-group">
		<form:label path="gu" class="col-sm-2"> 구 </form:label>
		<div class="col-sm-5">
		<form:input path="gu"  class="form-control" id="gu"/><br/>
		</div>
	</div>
	
	<div class="form-group">
		<form:label path="address" class="col-sm-2"> 주소 </form:label>
		<div class="col-sm-5">
		<form:input path="address" class="form-control" id="address"/><br/>
		</div>
	</div>
			
	<input type="hidden" name="altitude" id="altitude" value="0">
	<input type="hidden" name="longitude" id="longitude" value="0">			

	<div class="form-group">
		<form:label path="phone" class="col-sm-2"> 핸드폰 번호 </form:label>
		<div class="col-sm-5">
		<form:input path="phone"  class="form-control"/><br/>
		</div>
	</div>
		
	<div class="form-group">
		<form:label path="carType" class="col-sm-2"> 주차 가능한 차 타입 </form:label>
		<div class="col-sm-5">
		<select name="carType" class="form-control">
			<option value="소형차">소형차 </option>
			<option value="중형차">중형차 </option>
			<option value="대형차">대형차 </option>			
		</select>
		</div>
	</div>
		<br />
		
	<div class="form-group">
		<form:label path="cost" class="col-sm-2"> 1시간 당 가격 </form:label>
		<div class="col-sm-5">
		<form:input path="cost"  class="form-control"/><br/>
		</div>
	</div>

	<div class="form-group">
		<label for="contest_content" class="col-sm-2">내용</label>
			<div class="col-sm-8">
				<textarea class="form-control" rows="10" name="content"></textarea>
			 </div>
	</div>
	
	<div class="form-group">
		<label for="image" class="col-sm-2">이미지</label>
			<div class="col-sm-10">
				<input class="btn btn-default" type="file" value="이미지추가">
			 </div>
	</div>
		<br/><br/><br/>
				
		<center>
		<input type="button" value=" 제출하기 " class="btn btn-info" onClick='getLocation()'/> <br/>
		</center>
		
	</form:form>

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