<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<% Blob image = null;
Connection con = null;
byte[ ] imgData = null ;
Statement stmt = null;
ResultSet rs = null;
// String id = request.getParameter("parameter");
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("jdbc:oracle:thin:@202.20.119.117:1521:orcl","boongboong2","qndqnd2");
stmt = con.createStatement();
rs = stmt.executeQuery("select img from img_table where p = 2;");

//jsp 에는 이미 내장객체로 out이 사용되고 있기 때문에 
//[출처] JSP 파일 다운로드 소스 |작성자 엘런 튜링

//jsp의 InputStream으로 별도 작업을 할 경우 out 객체를 초기화한다.


 
out.clear();
out=pageContext.pushBody();
 
if (rs.next()) {
image = rs.getBlob(1);
imgData = image.getBytes(1,(int)image.length());
} else {
out.println("Display Blob Example");
out.println("image not found for given id>");
return;
}
 
// display the image
response.setContentType("image/gif");
OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();
o.close();
} catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());
return;
} finally {
try {
rs.close();
stmt.close();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
%>