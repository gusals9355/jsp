<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/css/boardList.css">
<h1>리스트</h1>

<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>작성일시</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr class="record" onclick="moveToDetail(${item.iboard});">
            <td>${item.iboard}</td>
            <td>${item.title}</td>
            <td>${item.writerNm}</td>
            <td>${item.regdt}</td>
        </tr>
    </c:forEach>
</table>
    <div>
        <c:forEach begin="1" end="${totalPage}" var="cnt">
            <c:choose>
                <c:when test="${cnt eq param.page || (empty param.page && cnt eq 1)}">
                    <span class="colorRed">${cnt}</span>
                </c:when>
                <c:otherwise>
                    <a href="list?page=${cnt}">${cnt}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>

    <div>
        <form action="list" method="get">
            <div>
                <select name="searchType">
                    <option value="1">제목+내용</option>
                    <option value="2">제목</option>
                    <option value="3">내용</option>
                    <option value="4">글쓴이</option>
                </select>
                <input type="search" name="searchText">
                <input type="submit" value="검색">
            </div>
        </form>
    </div>
<script src="/js/boardList.js"></script>