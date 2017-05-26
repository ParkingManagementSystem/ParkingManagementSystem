<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  공간 나눔 게시글을 새로 작성 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> 새로운 글 작성 </title>
</head>
<body>

	<form:form commandName="command" method="post">
		<form:label path="title"> 글 제목 : </form:label>
		<form:input path="title"/><br/>
		
		<form:label path="parkingName"> 주차장 이름 : </form:label>
		<form:input path="parkingName"/><br/>
		
		<form:label path="address"> 주소 : </form:label>
		<form:input path="address"/><br/>
		
		<form:label path="gu"> 구 : </form:label>
		<form:input path="gu"/><br/>
		
		<form:label path="altitude"> 위도 : </form:label>
		<form:input path="altitude"/><br/>
		
		<form:label path="longitude"> 경도 : </form:label>
		<form:input path="longitude"/><br/>
		
		<form:label path="phone"> 핸드폰 번호 : </form:label>
		<form:input path="phone"/><br/>
		
		<form:label path="carType"> 주차 가능한 차 타입 : </form:label>
		<form:input path="carType"/><br/>
		
		<form:label path="cost"> 1시간 당 가격 : </form:label>
		<form:input path="cost"/><br/>
		
		<form:label path="content"> 글 내용 : </form:label>
		<form:input path="content"/><br/>
		
		<form:label path="image"> 이미지 : </form:label>
		<input type="file" name = "image" ><br/>
		
		<br/>
		
		<input type="submit" value="submit" />
	</form:form>

</body>
</html>