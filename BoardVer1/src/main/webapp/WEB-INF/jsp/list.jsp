<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="com.koreait.board.*" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
	</div>
	<table border="1">
		<tr>
			<th>글 번호
			<th>글 제목
	<c:forEach var="vo" items="${data }" varStatus="status">
		<div>
		<tr>
			<td><c:out value="${status.count }"/>
			<td><a href="/detail?no=${status.count }"><c:out value="${vo.getTitle() }"/></a>
		</div>
	</c:forEach>
	</table>
</body>
</html>