<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>판매할 과일 등록</title>
</head>
<body>
<h3>${error}</h3>
<form action="/fruit/sellerRegister.do" method="post">
AppleCount : <input type="text" name="count"><br>
ApplePrice : <input type="text" name="price"><br>
<input type="submit" value="register">
</form><br>
<a href="/fruit/seller/sellerMenu.jsp">Go back</a>
</body>
</html>