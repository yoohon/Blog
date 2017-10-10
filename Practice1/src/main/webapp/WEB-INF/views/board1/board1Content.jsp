<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>board1</title>
</head>
<body>
        <table border="1" style="width:600px">
            <caption>게시판</caption>
            <colgroup>
                <col width='15%' />
                <col width='*%' />
            </colgroup>
            <tbody>
                <tr>
                    <td>작성자</td> 
                    <td><c:out value="${boardInfo.brdwriter}"/></td> 
                </tr>
                <tr>
                    <td>제목</td> 
                    <td><c:out value="${boardInfo.brdtitle}"/></td> 
                </tr>
                <tr>
                    <td>내용</td> 
                    <td><c:out value="${boardInfo.brdmemo}"/></td> 
                </tr>
            </tbody>
        </table>    
        <a href="#" onclick="history.back(-1)">돌아가기</a>
                <c:url var="link1" value="board1Delete">
                    <c:param name="brdno" value="${boardInfo.brdno}" />
                </c:url>
                <c:url var="link2" value="board1Update">
                    <c:param name="brdno" value="${boardInfo.brdno}" />
                </c:url>        
        <a href="${link1}">삭제</a>
        <a href="${link2}">수정</a>
</body>
</html>