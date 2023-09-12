<%@page import="basic.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>요청 재지정으로 실행되는 jsp - 회원 insert 수행 완료</h2>

	<%
		int data = (int) request.getAttribute("mydata");
	%>
	<h2><%= data%>행 삽입 성공.</h2>

</body>
</html>