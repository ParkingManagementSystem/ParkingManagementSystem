<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ����</title>

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
	<form:label path="id">���̵�</form:label> 
	<form:input path="id" />
	<br/>
	
	<form:label path="pwd">��й�ȣ</form:label>
	<form:password path="pwd"/>
	<br/>
	
	<form:label path="name">�̸�</form:label>
	<form:input path="name"/>
	<br/>
	
	<form:label path="gender">����</form:label>
	<form:radiobuttons items="${gender}" path="gender" /> 
	<br/>
	
	<form:label path="phone">��ȭ��ȣ</form:label>
	<form:input path="phone" />
	<br/>
	
	<form:label path="birthday">����</form:label>
	<form:input type="date" path="birthday" />
	
	
	�����ȣ: <input type="text" name="address.zipcode" value="${account.address.zipcode}" />
	<form:errors path="address.zipcode" />
	<br/>
	�ּ�1: <input type="text" name="address.address1" value="${account.address.address1}" />
	<form:errors path="address.address1" />
	<br/>
	�ּ�2: <input type="text" name="address.address2" value="${account.address.address2}" />
	<form:errors path="address.address2" />
	<br/>
	<input type="submit" value="����"/>
</form:form>

<!-- <form:errors path="name" /> -->

</body>
</html>