<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%System.out.println();
		//자바코드를 쓸 수 있는 영역
		//=> jsp문서에서 작성하는 모든 태그나 자바코드는 서블릿으로 변환될 떄 _jspService메소드의 내부 코드가 작성된다.
		out.print("<img src='/serverweb/ilovecoding.jpg'/>");
		out.println("<h2>가입을 환영합니다.</h2>");
	%>

</body>
</html>