<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>컨트롤러가 공유해준 데이터의 체크 (컨트롤러에서 공유한 user객체가 널인지 체크하기)</h2>
	<c:choose>
		<c:when test="${user==null }">
			<h3>널이다.</h3>
		</c:when>
		<c:otherwise>
			<h3>널이 아니다.</h3>
		</c:otherwise>
	</c:choose>
	
	<h2>c:choose가 if~else를 표현할 수 있다.</h2>
	<h3>age변수 20세 미만 : XXX님 청소년입니다., 20세 이상이면 XXX님 성인입니다.</h3>
	if문, else if문 -> c:when
	else -> c:otherwise
	<c:choose>
		<c:when test="${param.age<20 }">
			<h3>${param.name }님은 청소년입니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>${param.name }님은 성인입니다.</h3>
		</c:otherwise>
	</c:choose>
	<!-- grade가 A면 <h3>A등급</h3> -->
	<c:choose>
		<c:when test="${param.grade == 'A' || param.grade == 'a'}">
			<h3>A등급</h3>
		</c:when>
		<c:when test="${param.grade == 'B' }">
			<h3>B등급</h3>
		</c:when>
		<c:when test="${param.grade == 'C' }">
			<h3>C등급</h3>
		</c:when>
		<c:otherwise>
			<h3>기타</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>