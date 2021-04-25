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

<h2>전체 게시글 보기</h2>
<table width="700" border="1">
	<tr height="40">
		<td colspan="5" align="right">
		<button onclick="location.href='BoardWriteForm.jsp'">글쓰기</button></td>
	</tr>
	<tr height="40">
		<td width="50" align="center"> 번호
		<td width="320" align="center"> 제목
		<td width="100" align="center"> 작성자
		<td width="150" align="center"> 작성일
		<td width="80" align="center"> 조회수
	</tr>

	<c:set var="number" value="${number }"></c:set>

	<c:forEach var="bean" items="${v}">
	<tr height="40">
		<td width="50" align="left"> ${number }
		<td width="320" align="left"> 
			<c:if test="${bean.re_step > 1 }">
				<c:forEach var="j" begin="1" end="${ (bean.re_step-1)*5 }">
					&nbsp;
				</c:forEach>
			</c:if>
			<a href="BoardInfoControl.do?num=${bean.num }"> ${bean.subject }</a>
		<td width="100" align="left"> ${bean.writer }
		<td width="150" align="left"> ${bean.reg_date }
		<td width="80" align="left"> ${bean.readCount }
	</tr>
	<c:set var="number" value="${number-1 }"></c:set>
	</c:forEach>
	
</table>

</body>
</html>