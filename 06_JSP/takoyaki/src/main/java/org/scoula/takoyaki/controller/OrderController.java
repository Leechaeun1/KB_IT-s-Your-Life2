package org.scoula.takoyaki.controller;


import org.scoula.takoyaki.command.Command;
import org.scoula.takoyaki.model.Menu;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class OrderController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext context = req.getServletContext();
        List<Menu> menuList = (List<Menu>) context.getAttribute("menuList");

        if (menuList != null && !menuList.isEmpty()) {
            Random random = new Random();
            Menu randomMenu = menuList.get(random.nextInt(menuList.size()));
            req.setAttribute("menu", randomMenu);
        }

        return "order/new"; // views/order/new.jsp로 포워딩
    }
}