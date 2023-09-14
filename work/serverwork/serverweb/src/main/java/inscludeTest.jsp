<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp에서 include하기</h1>
	<h3>서블릿의 include와 동일하게 동작</h3>
	<h2>**************include***************</h2>
	<% System.out.println("includeTest실행"); %>
	<jsp:include page="/jspbasic/actiontag_sub.jsp">
		<jsp:param value="jbj" name="id"/>
	</jsp:include>
	<h2>**************include***************</h2>

</body>
</html>