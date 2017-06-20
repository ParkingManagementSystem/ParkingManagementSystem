<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>주소로 장소 표시하기</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/font.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/button.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/simpleBanner.css">

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
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBtSVe7WrcC0vso-ybCsgbQsFku9XzUjU8&sensor=false"></script>

<script type="text/javascript" src="js/simpleBanner.js"></script>


       
</head>
<body>
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


<script type="text/javascript"
   src="//apis.daum.net/maps/maps3.js?apikey=29a5a2a1d86c4f056e4b5148ff14186c&libraries=services"></script>
   
   
   주소:${greeting[16].addr} 가능 대수 비율:${greeting[16].percent}<br>
   주소:${greeting[17].addr} 가능 대수 비율:${greeting[17].percent}<br>
   주소:${greeting[18].addr} 가능 대수 비율:${greeting[18].percent}<br>
   주소:${greeting[19].addr} 가능 대수 비율:${greeting[19].percent}<br>
   주소:${greeting[20].addr} 가능 대수 비율:${greeting[20].percent}<br>
   <div id="map" style="width: 100%; height: 350px;"></div>
<p>
    <button onclick="zoomIn()">지도레벨 - 1</button>
    <button onclick="zoomOut()">지도레벨 + 1</button>
    <span id="maplevel"></span>
</p>

<script>
var contentArray = [];

var iConArray = [];

var markers = [];

var iterator = 0;

var markerArray = [];




   // infowindow contents 배열

   contentArray[0] = "Kay";

   contentArray[1] = "uhoons blog";

   
   //iConArray[1] = "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png";

   // 위경도 배열

   /*

    var markerArray = [ new google.maps.LatLng(40.3938,-3.7077)

    , new google.maps.LatLng(40.45038,-3.69803)

    , new google.maps.LatLng(40.45848,-3.69477)

    , new google.maps.LatLng(40.40672,-3.68327)

    , new google.maps.LatLng(40.43672,-3.62093)

    , new google.maps.LatLng(40.46725,-3.67443)

    , new google.maps.LatLng(40.43794,-3.67228)

    , new google.maps.LatLng(40.46212,-3.69166)

    , new google.maps.LatLng(40.41926,-3.70445)

    , new google.maps.LatLng(40.42533,-3.6844)

    ];

    */

   

   function initialize() {

      var mapOptions = {

         zoom : 11,

         mapTypeId : google.maps.MapTypeId.ROADMAP,

         center : new google.maps.LatLng(37.5665350, 126.9779690)

      };
      var map = new google.maps.Map(document.getElementById('map'), mapOptions);
      var icons = [];
      // marker icon 배열
      
      
      var geocoder = new google.maps.Geocoder();
      
      var positions = [];
      var marker;
      var i =0;
      <c:forEach items="${greeting}" var="item1">
          positions[i] = "${item1.addr}";
          icons[i] = "${item1.percent}";
          i++
      </c:forEach>
      console.log(positions[0]);

      
      for (var i = 0; i < positions.length; i++) {
      geocoder.geocode( { 'address': positions.shift()}, function(results, status) {
          //if (status == google.maps.GeocoderStatus.OK) {
             if(icons.shift() == 10){
                  iConArray[i] = "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png";
               }
               else if(icons.shift()> 9){
                  iConArray[i] = "http://maps.google.com/mapfiles/ms/micons/blue-dot.png";
                }
               else if(icons.shift()> 6){
                  iConArray[i] = "http://maps.google.com/mapfiles/ms/micons/green-dot.png";
                }
               else if(icons.shift()> 3){
                  iConArray[i] = "http://maps.google.com/mapfiles/ms/micons/ltblue-dot.png";
                }
               else if(icons.shift()> 1){
                  iConArray[i] = "http://maps.google.com/mapfiles/ms/micons/pink-dot.png";
                }
               else {
                  iConArray[i] = "http://maps.google.com/mapfiles/ms/micons/purple-dot.png";
                }
         //map.setCenter(results[0].geometry.location);
          markerArray[i] = results[0].geometry.location;
          marker = null;
          marker = new google.maps.Marker({
          map: map,
          title: positions[i], // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
          position: results[0].geometry.location,
          icon: iConArray[i]
           });
          markers.push(marker);
          google.maps.event.addListener(marker, "click", function() {infowindow.open(map,marker);});
          
         // } 

          });
      }
      
      markerArray = [];
      iConArray = [];
      // for (var i = 0; i < positions.length; i++) {
      // // 주소로 좌표를 검색합니다
      // geocoder.geocode(positions[i], function(results, status) {
//          // 정상적으로 검색이 완료됐으면 
//            if (status === google.maps.GeocoderStatus.OK) {
//               var lat = results[0].geometry.location.lat();
//               var lng = results[0].geometry.location.lng(); 

//              markerArray[i] = new google.maps.LatLng(lat, lng);
//           }
//          });
      // }
      //positions = document.getElementById("location").value;

//       for (var i = 0; i < positions.length; i++) {
//          // 주소로 좌표를 검색합니다
//          geocoder.geocode({'address': positions[i]}, function(results, status) {
//             // 정상적으로 검색이 완료됐으면 
//               if (status === google.maps.GeocoderStatus.OK) {
                
//                 markerArray[i] = results[i].geometry.location;
//              }
//             });
//       }
//       for (var i = 0; i < markerArray.length; i++) {

//          addMarker();

//       }

   }

   // 마커 추가

//    function addMarker() {

      
//       var marker = new google.maps.Marker({

//          position : markerArray[iterator],

//          map : map,

//          draggable : false


//       });

//       markers.push(marker);

//       var infowindow = new google.maps.InfoWindow({

//          content : contentArray[iterator]

//       });

//       google.maps.event.addListener(marker, 'click', function() {

//          infowindow.open(map, marker);

//       });

//       iterator++;

//    }

   google.maps.event.addDomListener(window, 'load', initialize);
//-->
</script>
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