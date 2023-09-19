<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 
   		외부에서 제공되는 라이브러리를 JSP에서 사용하기 위해서 taglib 지시자를 이용 
   		- 스프링태그, tiles태그, jstl태그
   -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
</head>
<body>	
<!-- 
	JSTL (Java server page Standard Tag Library) - 자바 표준 태그 라이브러리
	- 기본 자바코드를 태그로 사용할 수 있도록 지원
	- EL과 같이 사용
	- JSTL을 사용하기 위해서 태그 라이브러리를 추가(taglib 지시자)
	- c:XXX의 태그를 이용해서 작업
 -->
	<h3>c:if의 사용 - 자바의 if문과 같은</h3>
	1. 전송된 파라미터의 name을 체크하기 (name이 홍길동이면 "홍길동님 환영합니다." 메시지를 출력하기)
	<h3>${param.name }</h3>
	<h3>${param.addr }</h3>
	<c:if test="${param.name=='전병준' }">
		<h3>
		${param.name }님 환영합니다.
		</h3>

	
	</c:if>
</body>
</html>