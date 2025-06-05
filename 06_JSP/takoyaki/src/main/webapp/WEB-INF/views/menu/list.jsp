<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>📝 오늘의 메뉴판</h1>
<ul>
    <c:forEach var="menu" items="${menuList}">
        <li>${menu.name} - ${menu.price}</li>
    </c:forEach>
</ul>
<a href="add">➕ 새 메뉴 추가</a><br/>
<a href="/">🏠 돌아가기</a>
</body>
</html>
