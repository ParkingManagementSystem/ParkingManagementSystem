<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 정보</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
    
<script>
$(function() {
  $( "#datepicker1" ).datepicker({
    dateFormat: 'yy/mm/dd'
  });
});
</script>

</head>
<body>

	<form:form commandName="account" method="post">
		<form:label path="id">아이디</form:label> 
		<form:input path="id" />
		<form:errors path="id" />
		<br/>
		
		<form:label path="pwd">비밀번호</form:label>
		<form:password path="pwd"/>
		<form:errors path="pwd" />
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