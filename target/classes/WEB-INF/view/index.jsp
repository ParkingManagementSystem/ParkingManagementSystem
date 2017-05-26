<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>붕붕이를 부탁해 - 주차관리시스템</title>
	</head> 
	<body>
		
<%-- 		<%=(String)session.getAttribute("id") %> --%>
		
        <c:if test="${!empty sessionScope.id}">
			<font size="2" color="BLACK"> 환영합니다 <c:out value="${sessionScope.id}"/>님!</font>
        </c:if>
        <br/>
        
		<a href="<c:url value='/account/createAccount.do' />">회원가입</a><br>
		
		<c:if test="${empty sessionScope.id}">
			<a href="<c:url value='/signIn/signIn.do' />">로그인</a><br>
		</c:if>
 		
 		<c:if test="${!empty sessionScope.id}">
			<a href="<c:url value='/signOut/signOut.do' />">로그아웃</a><br>
		</c:if>
		
		<a href="<c:url value='/share/createForm.do' />">글 작성</a><br>
		<a href="<c:url value='/share/shareParkingInfo.do?code=2' />">글 내용</a><br> 
		
		<a href="http://localhost:8081/ParkingManagementSystem/share/createForm.do"> 시발 나니 </a>
		
		<br><br>
		
		
			<c:if test="${empty sessionScope.admin}">
				<a href="<c:url value='/account/showAccount.do?id=${sessionScope.id}'/>"> MYPAGE </a>
			</c:if>
			<c:if test="${!empty sessionScope.admin}">
				<a href="<c:url value='/admin/showAccountList.do'/>"> SETTING </a>
			</c:if>
		
		<br>
		
	</body>
</html>
