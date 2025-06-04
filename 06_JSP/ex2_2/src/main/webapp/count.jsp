<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1>방문자수 설정하기 화면</h1>
<%! int count; %>
<%
    count++;
    // application 객체에 count 값 저장 (전역 저장소 역할)
    application.setAttribute("countValue",count);
%>
현재 방문자수: <%= count%>
</body>