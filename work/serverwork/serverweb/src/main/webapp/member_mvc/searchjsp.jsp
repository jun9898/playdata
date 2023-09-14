<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../top.jsp"/>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="/layout/emp_menu.jsp"/>
			</div>
			<div class="col-lg-10">
			<form method="post" action="/serverweb/mvc/search.do">
				<h1>주소로 검색</h1>
				<hr/>
					검색어 : <input type="text" name="search">
					<input type="submit" value="검색">
			</form>
 			</div>
		</div>
	</div>

</body>
</html>