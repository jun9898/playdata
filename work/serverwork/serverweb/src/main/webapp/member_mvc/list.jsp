<%@page import="basic.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<MemberDTO> data = 
		(ArrayList<MemberDTO>)request.getAttribute("mydata"); 
	%>
	<h1> 회원목록 보기 </h1>
	<hr>

	<table border='1' width = '600'>
	<tr>
	<td>아이디</td><td>패스워드</td><td>성명</td><td>주소</td><td>가입일</td>
				 <td>포인트</td><td>기타정보</td><td>삭제</td>
	</tr>

	<% for (MemberDTO member : data) { %>
		<tr>
		<td><%= member.getId() %> </td>
		<td><%= member.getPass() %> </td>
		<td><%= member.getName() %> </td>
		<td><%= member.getAddr() %> </td>
		<td><%= member.getRegdate() %> </td>
		<td><%= member.getPoint() %> </td>
		<td><%= member.getInfo() %> </td>
		<td><a href="/serverweb/mvc/member/delete.do?id=<%=member.getId() %>">삭제</a> </td>
		</tr>
	<% } %>
	
	</table>

</body>
</html>