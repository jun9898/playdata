<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">

var category = "${category}"; // 컨트롤러 요청하고 response될 때 공유해준 값을 가져와서 셋팅
	$(document).ready(function() {
		$("#category").val(category).attr("selected","selected");
		$("#category").change(function() {
			// select를 선택하면 컨트롤러가 실행되고 파라미터로 선택한 category의 value속성 값이 파라미터로 전달
			// alert($(this).val());
			location.href = "/erp/board/list?category=" + encodeURI($(this).val());
		})
	})

</script>
</head>
<body>
	<%

	%>

	<div style="padding-top: 30px">
		<div class="col-md-3" style="padding-bottom: 10px">
			구분:
			<form action="">
				<select name="category" id="category">
					<option value="all">전체게시물</option>
					<option value="경조사">경조사</option>
					<option value="사내소식">사내소식</option>
					<option value="게시판">게시판</option>
				</select>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardlist}">
					<tr>
						<td>${board.board_no }</td>
						<td><a href="/erp/board/read?board_no=${board.board_no }&cmd=view">${board.title }</a></td>
						<td>${board.id }</td>
						<td>${board.write_date }</td>
						<td><a href="/erp/board/delete?board_no=${board.board_no }">삭제</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<form action="/erp/board/search" method="post">
		<select name="tag">
			<option value="id">작성자</option>
			<option value="title">제목</option>
			<option value="content">본문</option>
			<option value="write_date">작성일</option>
		</select> <input type="text" name="search" /> <input type="submit" value="검색">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/erp/board/write" style="text-align: right;">글쓰기</a></li>
		</ul>
	</form>

</body>
</html>
