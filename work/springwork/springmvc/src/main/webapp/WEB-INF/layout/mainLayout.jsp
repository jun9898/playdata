<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- tiles의 설정 파일에 등록된 각 영역이 실제 어느 위치인지 지정하는 작업을 tiles에서 제공되는 태그를 이용해서 처리 -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- top영역 -->
	<tiles:insertAttribute name="top"></tiles:insertAttribute>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<!-- 왼쪽 sub메뉴  -->
				<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</div>
			<div class="col-lg-10">
				<!-- 실제 작업할때마다 교체될 작업페이지 -->
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
			</div>
		</div>
	</div>
</body>
</html>
​
