package org.scoula.takoyaki.controller;

import org.scoula.takoyaki.model.Menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MenuController {
    private static List<Menu> menuList = new ArrayList<>();

    //    static {
//        menuList.add(new Menu("🐙 오리지널 타코야끼", 3000));
//        menuList.add(new Menu("🧀 치즈 타코야끼", 3500));
//    }
    public static String getList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /menu/list");
        req.setAttribute("menuList", menuList);
        return "menu/list";
    }

    public static String getAddForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /menu/add");
        return "menu/add";
    }

    // 새 메뉴 추가 처리
    public static String postAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");

        int price = Integer.parseInt(req.getParameter("price"));

        menuList.add(new Menu(name, price));

        System.out.println("POST /menu/list");
        return "redirect:/menu/list";
    }


    public static String postList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("POST /menu/list");
        return "menu/list";
    }

    public static String getNew(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("GET /order/new");
        return "order/new";
    }

    public static String getResult(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("GET /order/result");
        return "order/result";
    }

    public static String postNew(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("POST /order/new");
        return "order/new";
    }

    public static String postResult(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("POST /order/result");
        return "order/result";
    }
}
