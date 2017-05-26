<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  공간 나눔 게시글을 보고 다른 사용자가 공간 나눔을 신청 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> 신청 </title>
</head>
<body>
	신청신청 ^^77
	
	<form:form commandName="time" method="post">
	
		<input type="hidden" name="apply_code" value="${command.apply_code} }">
		
		<form:label path=" "> </form:label>
		<form:input path="" /><br/>
		
	</form:form>

</body>
</html>