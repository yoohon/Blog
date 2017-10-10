<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board1List</title>
</head>
<body>
<a href="board1Form">글쓰기</a>
                    
	<table border="1" style="width:600px">
	    <caption>게시판</caption>
	    <colgroup>
	        <col width='8%' />
	        <col width='*%' />
	        <col width='15%' />
	        <col width='15%' />
	    </colgroup>
	    <thead>
	        <tr>
	        <th>번호</th> 
	        <th>제목</th>
	        <th>등록자</th>
	        <th>등록일</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach var="listview" items="${listview}" varStatus="status">    
	            <c:url var="link" value="board1Read">
	                <c:param name="brdno" value="${listview.brdno}" />
	            </c:url>        
	            <tr>
	                <td><c:out value="${listview.brdno}"/></td>
	                <td><a href="${link}"><c:out value="${listview.brdtitle}"/></a></td>
	                <td><c:out value="${listview.brdwriter}"/></td>
	                <td><c:out value="${listview.brddate}"/></td>
	           </tr>
	        </c:forEach>
	    </tbody>
	</table>    
</body>
</html>