
<%@page import="com.edu.vo.Seller"%>
<%@page import="com.edu.service.Service"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>과일 구매하기</title>
</head>
<body>
	<%
		Service service = Service.getInstanse();
		ArrayList<Seller> list = service.sellerList();
		if (!list.isEmpty()) {
	%>
	<table border="1">
		<tr>
			<th>Seller Id</th>
			<th>AppleCount</th>
			<th>ApplePrice</th>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
					Seller s = list.get(i);
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=String.valueOf(s.getAppleCount())%></td>
			<td><%=String.valueOf(s.getApplePrice())%></td>
		</tr>
		<%
			}
			} else {
				out.print("<h3>등록된 정보가 없습니다.<h3>");
			}
		%>
	</table>
	<br>
	<br>
	<h3>${error}</h3>
	<form action="/fruit/buyerBuyFruit.do" method="post">
		SellerId : <input type="text" name="sellerId"><br>
		AppleCount : <input type="text" name="count"><br> <input
			type="submit" value="Buy">
	</form>
	<br>
	<a href="/fruit/buyer/buyerMenu.jsp">Go back</a>
</body>
</html>