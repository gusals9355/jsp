<%@page import="com.koreait.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	BoardVO vo = (BoardVO)request.getAttribute("data"); 
%>

	<h2>디테일 </h2>
	<div>
		<form action="/del" method="post">
			<input type="hidden" name="no" value="${param.no }">
			<input type="submit" value="삭제">
		</form>
			<a href="/mod?no=${param.no }"><button>수정</button> </a>
	</div>
	<div>제목 : <%=vo.getTitle() %></div>
	<div>내용 : <%=vo.getCtnt() %></div>
	<input type="button" value="list로 이동" onclick="location.href='/list'">
	
</body>
</html>