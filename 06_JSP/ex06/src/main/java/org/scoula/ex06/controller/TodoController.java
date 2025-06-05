package org.scoula.ex06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// import static sun.jvm.hotspot.code.CompressedStream.L;

public class TodoController {
    public static String getList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<String> list = Arrays.asList("Todo 1", "Todo 2", "Todo 3");
        req.setAttribute("todoList", list);
        System.out.println("GET /todo/list");
        return "todo/list";
    }

    public static String getView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /todo/view");
        return "todo/view";
    }

    public static String getCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /todo/create");
        return "todo/create";
    }

    public static String postCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("POT /todo/create");
        return "redirect:todo/create";
    }

    public static String getUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /todo/update");
        return "todo/update";
    }

    public static String postUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /todo/update");
        return "redirect:todo/list";
    }

    public static String postDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /todo/delete");
        return "redirect:todo/list";
    }
}
