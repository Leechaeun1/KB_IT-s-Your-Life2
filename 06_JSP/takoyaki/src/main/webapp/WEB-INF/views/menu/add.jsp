<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>🧂 새 타코야끼 메뉴 추가</h1>
<br />
<form action="/menu/add" method="post">
이름: <input type="text" name="name" required><br />
가격: <input type="text" name="price" required>
<input type="submit" value="추가">
</form>
<a href="list">← 메뉴판으로 돌아가기</a>
</body>
</html>
