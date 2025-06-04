<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
  // 세션 무효화(세션 데이터 제거)
  session.invalidate();
  response.sendRedirect("loginForm.html");
%>