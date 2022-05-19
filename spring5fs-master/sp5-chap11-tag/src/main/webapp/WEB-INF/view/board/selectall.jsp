<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Gugi&family=Sunflower:wght@700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style type="text/css">
	* {
		font-family: 'Sunflower', sans-serif;;
	}
	table tr td a {
		text-decoration: none;
		transition: font-size .35s ease-in-out;
	}
	table tr td a:hover {
		font-size: 2rem;
	}
	table tr td a:visited {
		color: black;
	}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script type="text/javascript">
	
</script>
<title>hello</title>
</head>
<body>
	<%@ include file="nav.jsp" %>

	<div class="container">
		<div
			style="position: relative; background-color: #eee; margin-top: 1rem">
			<h1>selectall.jsp</h1>
		</div>
		<div>
			<table class="table">
				<tr>
					<th>순번</th>
					<th>제목</th>
					<th>작성날짜</th>
				</tr>
				<c:forEach var="aaa" items="${list}">
					<tr>
						<td>${aaa.id}</td>
						<td><a href="view?id=${aaa.id}">${aaa.title}</a></td>
						<td><fmt:parseDate value='${aaa.wdate}' var='day'
								pattern='yyyymmdd' /> <fmt:formatDate value="${day}"
								pattern="yyyy년 MM월 dd일" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="mb-3 d-flex justify-content-end">
			<a href="insert" class="btn btn-outline-primary " href="insert.jsp">글쓰기</a>
		</div>
		<div class="d-flex justify-content-center">
			<!-- 중앙으로 -->
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:if test="${param.pagenum==1}">
						<li class="page-item disabled">
							<a class="page-link" href="?pagenum=${param.pagenum -1}">Previous</a>
						</li>	
					</c:if>
					<c:if test="${param.pagenum!=1}">
						<li class="page-item">
							<a class="page-link" href="?pagenum=${param.pagenum -1}">Previous</a>
						</li>	
					</c:if>
					<c:forEach begin="1" end="${pagecnt}" var="i">
						<c:if test="${param.pagenum eq i}">
							<li class="page-item active">
								<a class="page-link" href="?pagenum=${i}">${i}</a>
							</li>
						</c:if>
						<c:if test="${param.pagenum ne i}">
							<li class="page-item">
								<a class="page-link" href="?pagenum=${i}">${i}</a>
							</li>
						</c:if>
					</c:forEach>
					<c:if test="${param.pagenum eq pagecnt }">
						<li class="page-item disabled">
							<a class="page-link" href="?pagenum=${param.pagenum +1}">Next</a>
						</li>
					</c:if>
					<c:if test="${param.pagenum ne pagecnt }">
						<li class="page-item">
							<a class="page-link" href="?pagenum=${param.pagenum +1}">Next</a>
						</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<hr>
	<div class="container">copyright &copy; 대구 박길동님이 다 만듬. All Rights
		Reserved.</div>
</body>
</html>