<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<h1>리스트</h1>
	<div>
		<a href="/write">글쓰기</a>
		<form action="/search" method="get">
		<input type="text" name="search" >
		<input type="submit" value="검색">
		</form>
	</div>
	
	<table border="1">
		<tr>
			<th>글 번호
			<th>글 제목
			<th>조회수
		<div>
		<tr>
			<td><c:out value="${search.no }"/>
			<td><a href="/detail?no=${search.no }">${search.title }</a>
			<td><c:out value="${search.content }"/>
		</tr>
		</div>
	</table>
</body>
</html>