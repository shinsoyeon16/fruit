<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>과일 판매자 회원 가입</title>
</head>
<body>
<h3>${error }</h3>
<form action="/fruit/sellerJoin.do" method="post">
Login ID : <input type="text" name="id"><br>
password : <input type="password" name="password"> <br>
<input type="submit" value="Join"><br>
</form>
</body>
</html>