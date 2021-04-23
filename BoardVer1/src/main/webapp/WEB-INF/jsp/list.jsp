<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="com.koreait.board.*" %>    
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
	
	<div>
	
	<%
		List<BoardVO> list = (List)request.getAttribute("data");
	%>
	<% for(int i=0; i<list.size(); i++) {
		BoardVO vo = list.get(i);
	%>
		<div><%=i %>, <%=vo.getTitle() %>, <%=vo.getCtnt() %></div>
	<% }
	%>
	</div>
</body>
</html>