<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp에서 forward하기</h1>
	<h3>서블릿의 forward와 동일하게 동작</h3>
	<% System.out.println("forwardTest실행"); %>
	<jsp:forward page="/jspbasic/actiontag_sub.jsp"/>

</body>
</html>