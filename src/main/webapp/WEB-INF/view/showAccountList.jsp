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
<title>Admin - 전체 회원 보기</title>

<script type="text/javascript">
	function delete_confirm() {
		return confirm("정말로 탈퇴하시겠습니까?");
	}
</script>

</head>
<body>

	<c:forEach var="account" items="${accountList}" varStatus="status">
		[${status.count}] 
		<a href="<c:url value='/account/showAccount.do?id=${account.id}'/>">${account.id}</a>
		${account.name} ${account.phone} ${account.blacklist} <br/>
	</c:forEach>
	
</body>
</html>