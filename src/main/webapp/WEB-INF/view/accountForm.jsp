<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<br/>
	
	<form:label path="pwd">비밀번호</form:label>
	<form:password path="pwd"/>
	<br/>
	
	<form:label path="name">이름</form:label>
	<form:input path="name"/>
	<br/>
	
	<form:label path="gender">성별</form:label>
	<form:radiobuttons items="${gender}" path="gender" /> 
	<br/>
	
	<form:label path="phone">전화변호</form:label>
	<form:input path="phone" />
	<br/>
	
	<form:label path="birthday">생일</form:label>
	<form:input type="date" path="birthday" />
	
	
	우편번호: <input type="text" name="address.zipcode" value="${account.address.zipcode}" />
	<form:errors path="address.zipcode" />
	<br/>
	주소1: <input type="text" name="address.address1" value="${account.address.address1}" />
	<form:errors path="address.address1" />
	<br/>
	주소2: <input type="text" name="address.address2" value="${account.address.address2}" />
	<form:errors path="address.address2" />
	<br/>
	<input type="submit" value="전송"/>
</form:form>

<!-- <form:errors path="name" /> -->

</body>
</html>