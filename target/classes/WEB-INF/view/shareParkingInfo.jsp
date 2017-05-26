<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  이미 작성된 공간 나눔 게시글과 관련된 정보를 볼 수 있는 view이다.
	글 작성자는 게시글, 공간 나눔 신청 목록, 댓글을 볼 수 있으며,
	일반 사용자는 게시글, 댓글목록을 볼 수 있고, 공간나눔 신청을 위한 버튼
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> 글 정보 </title>
</head>
<body>

	글 제목 : ${command.title} <br/>
	주차장 이름 : ${command.parkingName} <br/>
	주소 : ${command.address} <br/>
	구 : ${command.gu} <br/>
	위도 : ${command.altitude} <br/>
	경도 : ${command.longitude} <br/> 
	핸드폰 번호 :${command.phone} <br/>
	주차 가능한 차 타입 :${command.carType} <br/>
	가격 : ${command.cost} <br/>
	글 내용 :${command.content} <br/>
	
	<form method="post" action="apply.do">
	<input type="submit" value="신청" />
	</form>
</body>
</html>