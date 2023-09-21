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

</head>
<body>

			<div >
				<h3>job목록</h3>
				<div style="padding-top: 30px">
					
					<table class="table">
						<thead>
							<tr>
								<th>job아이디</th>
								<th>job이름</th>
								<th>job카테고리</th>
								<th>메뉴path</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dept" items="${deptlist}">
								<tr>
									<td><a href="/erp/job/read?job_id=${dept.job_id }">${dept.job_id }</a></td>

									<td>${dept.job_name }</td>
									<td>${dept.job_category }</td>
									<td>${dept.menupath }</td>
								
									<td><a
										href="/erp/job/delete?job_id=${dept.job_id }">삭제</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			
			</div>
</body>
</html>
