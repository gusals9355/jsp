<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="com.koreait.board.*" %>  
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
	
	<div>
		<table border="1">
			<tr>
				<th>번호
				<th>제목
			<%
			List<BoardVO> list = (List)request.getAttribute("data");
			%>
			<% for(int i=0; i<list.size(); i++) {
				BoardVO vo = list.get(i);
			%>
			<tr>
				<td><%=i %>
				<td><a href="/detail?no=<%=i%>"><%=vo.getTitle() %></a>
			<% }%>
		<!-- 
			get방식으로 서버한테 값 전달할때는 쿼리 스트링으로 전달
			post방식으로 서버한테 값 전달할때는 form 태그로!!
		 -->
		</table>
	</div>
</body>
</html>