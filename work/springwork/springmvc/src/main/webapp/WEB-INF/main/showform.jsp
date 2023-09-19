<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공유된 데이터</h1>
	<hr/>
	<h2>결과 : ${postdto}</h2>
	<hr/>
	<h2>아이디 : ${postdto.userId }</h2>
	<h2>이름 : ${postdto.userName }</h2>
	<h2>패스워드 : ${postdto.passwd }</h2>
	<h2>닉네임 : ${postdto.nickname }</h2>
	<h2>성별 : ${postdto.gender }</h2>
	<h2>직업 : ${postdto.job }</h2>
	<h2>아이템 : ${postdto.item }</h2>
</body>
</html>