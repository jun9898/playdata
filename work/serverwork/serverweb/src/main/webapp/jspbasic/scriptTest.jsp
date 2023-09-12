<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp 문법</h1>
	<h3>1. 주석문</h3>
	<!-- html 주석문(클라이언트에 전송) -->
	<%-- jsp주석(클라이언트에 전송되지 않는다.) --%>
	<%
		// 자바주석
		/* 
		자바주석 (클라이언트에 전송되지 않는다)
		*/
	%>
	<h3>2. 스크립트 요소 - 스크립트 릿</h3>
	<%
		String str = new String("java");
	%>
	<h3>스크립트릿은 자바코드를 쓸 수 있고 여러 번 사용이 가능</h3>
	<hr/>
	<% if(str.length()>=5){ %>
		<h3>문자열 길이 정상</h3>
	<%} else { %>
		<h3 style="color : red;">문자열 길이 다시 처리하기</h3>
	<%}%>
	
	<h3>3. 스크립트 요소 - 표현식</h3>
	<h4><%= str %></h4>
	<h4><%= str.length() %></h4>
	<h4><%= "str" %></h4>
	<h4><%= 10 %></h4>
	<h4><%= 10.0 %></h4>
	<h4><%= false %></h4>
	<h4><%= 10%3 %></h4>
	<h4><%= new Date().toString() %></h4>

	<h3>4. 스크립트 요소 - 선언문</h3>
	<%
		int num = 1000; // _jspService메소드의 지역변수로 정의
	%>
	<%!
		int num = 1000000; // member변수로 정의
	%>
	<%!
		public void test(){
			System.out.println("test");
		}
	%>


</body>
</html>