package org.scoula.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// "/xxx" 또는 "/yyy"로 요청시에 이 서블릿이 실행됨
@WebServlet(name="MyServlet", urlPatterns = {"/xxx","/yyy"})
public class MyServlet extends HttpServlet {
    // GET 방식 요청 처리
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet 요청");
        
        // 클라이언트에게 HTML 응답 출력
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello Servlet</h1>");
    }
}
