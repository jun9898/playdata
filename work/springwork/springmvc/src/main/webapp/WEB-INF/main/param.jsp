<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><a href="/springmvc/paramtest?data=first&info=10">파라미터 추출하기</a></h3>
	<form method="post" action="/springmvc/paramtest">
		아이디 : <input type="text" name="id">	
		패스워드 : <input type="text" name="pass">	
		<input type="submit" value="스프링에서 파라미터 추출하기">	
	</form>
	<form method="post" action="/springmvc/paramtest2">
		아이디 : <input type="text" name="id">	
		패스워드 : <input type="text" name="pass">	
		<input type="submit" value="스프링에서 파라미터 추출하기">	
	</form>

</body>
</html>