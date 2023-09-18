<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h1>스프링이 공유해준 데이터</h1>
	
	<h2>7단 출력하기 : <%= request.getAttribute("msg") %></h2>
</body>
</html>