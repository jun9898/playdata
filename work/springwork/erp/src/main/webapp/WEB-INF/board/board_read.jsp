<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<title>인사관리시스템</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	// 자바스크립트에서 자바데이터 (db에서 조회한 값, 컨트롤러에서 넘어온 값, 자바변수...) 를 가져오기
	$(document).ready(function(){
		// 변수에 서버에서 받아온 board 객체의 getCategory() 메소드를 호출한 결과를 저장
		// EL로 간단하게 셋팅 가능
		var data = "${board.category}";
		// alert(data);
		// select 태그에 값을 반영
		$("#category").val(data).attr("selected","selected");
		
	});

	

</script>
</head>
<body>

	<form class="form-horizontal" 
		action="" 
		method="post" >

		
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">번호</label>
			</div>
			<div class="col-md-8">
				${board.board_no }
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">게시글종류</label>
			</div>
			<div class="col-md-3">
 				<select name="category" class="form-control" 
							id="category" disabled="disabled">
					<option value="경조사" >경조사</option>
					<option value="사내소식">사내소식</option>
					<option value="게시판">게시판(익명)</option>
				</select>
		
<%-- 				${board.category }
 --%>			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">작성자</label>
			</div>
			<div class="col-md-8">
				${board.id }
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">제목</label>
			</div>
			<div class="col-md-8">
				${board.title }
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">첨부파일</label>
			</div>
			<div class="col-md-8">
			<!-- 디비에 저장된 파일명을 출력  -->
				<c:forEach var="file" items="${boardfiledtolist}">
					<h5><a>${file.originalFilename }</a></h5>
					<img src="/erp/upload/${file.storeFilename}" width="300"/>
				</c:forEach>
			</div>
		</div>
		
		
		
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">작성날짜</label>
			</div>
			<div class="col-md-8">
				${board.write_date }
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="text" class="control-label">내용</label>
			</div>
			<div class="col-md-8"
				style="width: 500px; height: 400px; border: solid 1px;">
				${board.content }
				
				</div>
		</div>

		<div class="form-group">
			<div class="col-md-10 text-center">
				<input type="button" class="btn btn-lg btn-primary" 
				value="수정" onclick="location.href='/erp/board/read?board_no=${board.board_no}&cmd=modify'">

				<button type="button" class="btn btn-danger btn-lg"
					onclick="location.href='/erp/board/list?category=all'">
					<i class="fa fa-fw fa-close"></i> 목록
				</button>
				<button type="button" class="btn btn-danger btn-lg"
					onclick="location.href='/erp/board/delete?board_no=${board.board_no }'">
					<i class="fa fa-fw fa-close"></i> 삭제
				</button>
			</div>
		</div>
	</form>

</body>
</html>