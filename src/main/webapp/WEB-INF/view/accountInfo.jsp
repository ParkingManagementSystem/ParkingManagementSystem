<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 정보 보기</title>

<script type="text/javascript">
	function delete_confirm() {
		return confirm("정말로 탈퇴하시겠습니까?");
	}
</script>

</head>
<body>

	ID ${account.id} <br/>
	
	NAME ${account.name} <br/>
	
	GENDER <br/>
	
	PHONE ${account.phone} <br/>
	
	BIRTHDAY <br/>
	
	<a href="<c:url value='/account/updateAccount.do?id=${sessionScope.id}'/>">회원정보 수정</a><br>
	
	<a href="<c:url value='/account/updateAccount.do?id=${sessionScope.id}'/>">비밀번호 수정</a><br>
	
	<a href="<c:url value='/account/deleteAccount.do?id=${sessionScope.id}'/>" onClick="return delete_confirm();">탈퇴하기</a><br>
</body>
</html>