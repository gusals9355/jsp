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
	
	.record{
		cursor: pointer;
	}
	.record:hover {
	background-color: aqua;
	
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
		<a href="/login">로그인</a>
		<a href="/join">회원가입</a>
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
	<c:forEach var="vo" items="${data }">
		<div>
		<tr class="record" onclick="moveToDetail(${vo.no })">
			<td><c:out value="${vo.getNo() }"/>
			<td><a href="/detail?no=${vo.getNo() }">${vo.getTitle() }</a>
			<td><c:out value="${vo.getReadCount() }"/>
		</tr>
		</div>
	</c:forEach>
	</table>
	
	<script>
		function moveToDetail(no){
			location.href='/detail?no='+no;
		}
	</script>
</body>
</html>