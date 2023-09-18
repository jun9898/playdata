<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h1>스프링이 공유해준 데이터</h1>
	<hr/>
	<h2>jsp 코드로 출력하기 : <%= request.getAttribute("msg") %></h2>
	<h2>EL로 출력 : ${msg }</h2>
	<h3>EL은 공유한 이름을 명시하면 제일 먼저 page scope에서 공유명으로 공유된 객체를 찾는다.
		없으면 request scope에서 또 없으면 session scope에서 마지막으로 application scope에서 공유된 객체를 찾고
		모든 scope에서 공유된 객체를 찾지 못하면 출력하지 않는다.
	</h3>
</body>
</html>