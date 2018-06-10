<%@page import="com.edu.controller.HttpUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>과일 판매자 로그인창</title>
</head>
<body>
<%
if(session.getAttribute("sellerId")!=null) {
	HttpUtil.forward(request, response, "/seller/sellerMenu.jsp");
	return;
} else { %>	
<h3>${error}</h3>
<form action="/fruit/sellerLogin.do" method="post">
Login ID : <input type="text" name="id"><br>
password : <input type="password" name="password"> <br>
<input type="submit" value="Login"><br>
<a href="/fruit/seller/sellerJoin.jsp"><input type="button" value="Join"></a>
</form>
<%} %>
</body>
</html>