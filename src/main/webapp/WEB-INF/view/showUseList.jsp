<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주차장 이용 내역</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/font.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/button.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/team.css">

<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
   integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
   crossorigin="anonymous">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
   integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
   crossorigin="anonymous">
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
   integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
   crossorigin="anonymous"></script>

<meta http-equiv="imagetoolbar" content="no" />
<meta name="viewport"
   content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript"
   src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/simpleBanner.js"></script>

<script type="text/javascript">
   function change_opacity(id) {
      id.style.opacity = 0.5;
   }
   function change_opacity(id1, id2) {
      id1.style.opacity = 0.5;
      id2.style.opacity = 0.5;
   }
</script>

</head>
<body onload="change_opacity();">
   <div class="row">
      <div class="col-md-2 col-xs-2 col-sm-2 col-lg-2"></div>
      <div class="col-md-8 col-xs-8 col-sm-8 col-lg-8">
         <div class="header">
            <div class="row">
               <div class="col-md-3 col-xs-3 col-sm-3 col-lg-3">
                  <!-- LOGO IMAGE -->
                  <a href="/ParkingManagementSystem/index"><img
                     src="${pageContext.request.contextPath}/resources/images/icon.png"
                     height=80px></a>
               </div>

               <div class="col-md-9 col-xs-9 col-sm-9 col-lg-9 subtitle">
                  <!-- LOGIN -->
                  <c:if test="${!empty sessionScope.id}">
                     <span
                        style='font-size: 15px; padding-right: 10px; color: #8babd6; font-family: Jeju Gothic'>
                        <c:out value="${sessionScope.id}" />님 환영합니다 ^^
                     </span>
                  </c:if>

                  <c:if test="${empty sessionScope.id}">
                     <a href="<c:url value='/signIn/signInForm.do' />"
                        style='font-size: 15px; padding-right: 30px;'>login</a>
                     <br>
                  </c:if>
                  <!-- LOGIN -->
                  <c:if test="${!empty sessionScope.id}">
                     <a href="<c:url value='/signOut/signOut.do' />"
                        style='font-size: 15px; padding-right: 30px;'>logout</a>
                     <br>
                  </c:if>
                  <br>

                  <!-- MAIN MENU -->
                  <a href="<c:url value='/map/parkingMap.do' />" style="padding: 30px">붕붕맵</a>
                  
                  <a href="<c:url value='/publicParkingList.do?pageNo=1'/>" style="padding: 30px">공영주차장</a> 
                  
                  <a href="<c:url value='/share/list.do'/>"  style="padding: 30px">공간나눔</a>
                  
                  <!-- MYPAGE / SETTING(ADMIN) -->
                  <c:if test="${empty sessionScope.admin}">
                     <a href="<c:url value='/account/showAccount.do'/>"
                        style="padding: 30px" class="user"> 마이페이지 </a>
                  </c:if>
                  <c:if test="${!empty sessionScope.admin}">
                     <a href="<c:url value='/admin/showAccountList.do'/>"
                        style="padding: 30px" class="user"> 관리자페이지 </a>
                  </c:if>

               </div>
            </div>
         </div>
         <hr>
         <div class="content">
<!-- *************************************************** 여기까지 ****************************************************************** -->
   <div>
      
      <c:if test="${empty sessionScope.admin}">
         <a href="<c:url value='/useList/showUseList.do'/>" class="team_sub_menu">이용내역</a>
         <a href="<c:url value='/shareList/showShareList.do'/>" class="team_sub_menu">나눔내역</a>
         <a href="<c:url value='/account/showAccount.do'/>" class="team_sub_menu"> 내정보 </a>
      </c:if>
      <c:if test="${!empty sessionScope.admin}">
         <a href="<c:url value='/admin/showAccountList.do'/>" class="team_sub_menu">전체 회원</a>
         <a href="<c:url value='/admin/showShareAccountList.do'/>" class="team_sub_menu">주차공간 나눔 회원</a>
      </c:if>
                     
      
   </div>
   <hr/>
   
<!-- *************************************************** Sub Menu Section ****************************************************************** -->
   <table class="table table-hover">
      <tr class="info" style="font-size:17px">
         <td> # </td>
         <td> 주차장이름 </td>
         <td> 요금 </td>
         <td> 평가 </td>
      </tr>
   
      <c:forEach var="use" items="${useList}" varStatus="status">
      <tr>
         <td>${status.count}</td> 
         <td>
            <%-- 사설 주차장일 경우 --%>
            <c:if test="${!empty use.shareParkingCode}">
               <a href="<c:url value='/share/shareParkingInfo.do?code=${use.shareParkingCode}'/>">${use.parkingName}</a>
            </c:if>
            <%-- 공영 주차장일 경우 --%>
            <c:if test="${!empty use.publicParkingCode}">
               <a href="<c:url value='/publicParkingListInfo.do?code=${use.publicParkingCode}'/>">${use.parkingName}</a>
            </c:if>
         </td>
         <td>${use.cost}</td>
         <td>
            <%-- 사설 주차장일 경우 --%>
            <c:if test="${!empty use.shareParkingCode}">
               <a href="<c:url value='/useList/likeUseList.do?useCode=${use.useCode}&lender=${use.lender}'/>">
                  <img src="${pageContext.request.contextPath}/resources/images/like.png" style="height:20px; margin-right:30px;" id="like${status.count}">
               </a>
               <a href="<c:url value='/useList/dislikeUseList.do?useCode=${use.useCode}&lender=${use.lender}'/>">
                  <img src="${pageContext.request.contextPath}/resources/images/dislike.png" style="height:20px;" id="dislike${status.count}">
               </a>
               
               ${use.sharingRating}
               
               <%-- 아직 추천 비추천이 눌러지지 않은 경우  --%>
               <c:if test="${0 eq use.sharingRating}">
                  <script>change_opacity(like${status.count}, dislike${status.count});</script>
               </c:if>
               
               <%-- 추천일 경우  --%>
               <c:if test="${1 eq use.sharingRating}">
                  <script>change_opacity(dislike${status.count});</script>
               </c:if>
               
               <%-- 비추천일 경우  --%>
               <c:if test="${-1 eq use.sharingRating}">
                  <script>change_opacity(like${status.count});</script>
               </c:if>
               
            </c:if>
            
            <%-- 공영 주차장일 경우 --%>
            <c:if test="${!empty use.publicParkingCode}">
            </c:if>
         </td>
      </tr>
      </c:forEach>
      
   </table>
   
<!-- *************************************************** 여기까지 ****************************************************************** -->

         </div>
         <hr>
         <div class="footer" style="clear: both">
            <div class="sitemap">
               <div class="stitle">site map</div>
               <div class="row" style="padding-left: 60px;">
                  <div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
                     <a href="<c:url value='/map/parkingMap.do' />" style="padding: 30px">붕붕맵</a>
                  </div>
                  
                  <div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
                     <a href="<c:url value='/publicParkingList.do?pageNo=1'/>" style="padding: 30px">공영주차장</a><br>
                  </div>
                  
                  <div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
                     <a href="<c:url value='/share/list.do'/>"  style="padding: 30px">공간나눔</a><br>
                  </div>
                  <div class="col-md-3 col-xs-3 col-sm-3 col-lg-3 sitemap">
                     <c:if test="${empty sessionScope.admin}">
                        <a href="<c:url value='/account/showAccount.do'/>"
                           style="padding: 30px"> MYPAGE </a>
                     </c:if>
                     <c:if test="${!empty sessionScope.admin}">
                        <a href="<c:url value='/admin/showAccountList.do'/>"
                           style="padding: 30px"> SETTING </a>
                     </c:if>
                  </div>
               </div>
            </div>

            <hr>
            <div class="copyright" style="text-align: center">copyright
               &copy; 2017 by BOONGBOONG2</div>
         </div>
      </div>
      <div class="col-md-2 col-xs-2 col-sm-2 col-lg-2"></div>
   </div>

</body>
</html>