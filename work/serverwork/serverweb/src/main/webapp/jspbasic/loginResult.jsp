<%@page import="oracle.net.aso.i"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과(request내장객체 연습)</h1>
	<hr/>
	<%
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		if (id.equals("java")){
	%>
		<h1><%=id %>님 로그인 성공</h1>
	<%
		} else {
			response.sendRedirect("./loginjsp.jsp");
		}
	%>
</body>
</html>