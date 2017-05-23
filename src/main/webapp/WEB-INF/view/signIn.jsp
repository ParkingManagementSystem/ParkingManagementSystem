<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Sign In</title>

</head>
<body>
	
	<form:form commandName="account" method="post">
		<form:errors element="div" class="error-color"/>
		아이디 <form:input path="id"/>
		<form:errors path="id" class="error-color"/><br>
		비밀번호<form:password path="pwd"/>
		<form:errors path="pwd" class="error-color"/><br>
		<input type="submit" value="전송">
	</form:form>
	
</body>
</html>