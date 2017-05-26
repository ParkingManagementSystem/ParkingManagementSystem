<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 정보 수정</title>

</head>
<body>

	<form:form commandName="account" method="post">
		* 아이디는 수정하실 수 없습니다.<br/>
		<form:label path="id">아이디</form:label> 
		<%-- <form:input path="id" disabled="true" /> --%>
 		<form:input path="id" readonly="true"/> 
		<form:errors path="id" />
		<br/>
		
		<form:label path="name">이름</form:label>
		<form:input path="name"/>
		<form:errors path="name" />
		<br/>
		
		<form:label path="gender">성별</form:label> &nbsp;&nbsp;&nbsp;&nbsp;
			남자 <form:radiobutton path="gender" value="m" />&nbsp;&nbsp;&nbsp;&nbsp;
			여자 <form:radiobutton path="gender" value="w" />
			<form:errors path="gender" />
		<br/>
		
		<form:label path="phone">전화변호</form:label>
		<form:input path="phone" />
		<form:errors path="phone" />
		<br/>
		
		<form:label path="birthday">생일</form:label>
		<form:input type="date" path="birthday" />
		<form:errors path="birthday" />
		<br/>
		
		<input type="submit" value="submit" />
	</form:form>

</body>
</html>