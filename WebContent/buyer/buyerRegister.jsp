<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구매자 머니 충전</title>
</head>
<body>
<h3>${error}</h3>
<form action="/fruit/buyerRegister.do" method="post">
Money : <input type="text" name="money"><br>
<input type="submit" value="register">
</form><br>
<a href="/fruit/buyer/buyerMenu.jsp">Go back</a>
</body>
</html>