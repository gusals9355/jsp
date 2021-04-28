<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<style>
	table, th, td{
	border: 1px solid black;
	border-collapse: collapse; 
	}
</style>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<h1>리스트</h1>
	<div>
		<a href="/write">글쓰기</a>
	</div>
	<table border="1">
		<tr>
			<th>글 번호
			<th>글 제목
			<th>조회수
	<c:forEach var="vo" items="${data }">
		<div>
		<tr>
			<td><c:out value="${vo.getNo() }"/>
			<td><a href="/detail?no=${vo.getNo() }">${vo.getTitle() }</a>
			<td><c:out value="${vo.getReadCount() }"/>
		</div>
	</c:forEach>
	</table>
</body>
</html>