<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
	border: solid 1px;
	}
</style>
</head>
<body>
<h1>for 실행결과</h1>
<hr/>
<table style="border: solid 1px;">
<% for (int i=1; i<10; i++) { %>
	<tr>
	<% for (int j=1; j<10; j++) { %>
		<% if (i != j) {%>
			<td> <%= i + "*" + j + "=" + i*j %> </td>
		<% } else {%>
			<td>
				<img src="../ilovecoding.jpg" width= 100px;>
			</td>
		<% } %>
	<% } %>
	</tr>
<% } %>
</table>
</body>
</html>