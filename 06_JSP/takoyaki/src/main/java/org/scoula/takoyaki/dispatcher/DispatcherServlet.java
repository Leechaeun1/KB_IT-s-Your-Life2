package org.scoula.takoyaki.dispatcher;

import org.scoula.takoyaki.command.Command;
import org.scoula.takoyaki.controller.OrderController;
import org.scoula.takoyaki.model.Menu;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DispatcherServlet extends HttpServlet {
    Map<String, Command> getMap;
    Map<String, Command> postMap;

    String prefix = "/views/";
    String suffix = ".jsp";

    public void init(){
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);

        ServletContext ctx = getServletContext();

        if (ctx.getAttribute("menuList") == null) {
            List<Menu> menuList = new ArrayList<>();
            menuList.add(new Menu("오리지널 타코야끼", 3000));
            menuList.add(new Menu("치즈 타코야끼", 3500));
            menuList.add(new Menu("불닭 타코야끼", 4000));
            menuList.add(new Menu("와사비 타코야끼", 3800));
            menuList.add(new Menu("날치알 타코야끼", 4200));
            menuList.add(new Menu("옥수수콘 타코야끼", 3700));
            menuList.add(new Menu("문어풀장 타코야끼", 4500));
            menuList.add(new Menu("고르곤졸라 타코야끼", 4800));
            menuList.add(new Menu("트러플오일 타코야끼", 5200));
            menuList.add(new Menu("초코소스 타코야끼 (디저트)", 3900));
            ctx.setAttribute("menuList", menuList);
        }

        if (ctx.getAttribute("inventory") == null) {
            ctx.setAttribute("inventory", 5);
        }
        if (ctx.getAttribute("revenue") == null) {
            ctx.setAttribute("revenue", 0);
        }
    }

    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap){
        getMap.put("/order/new", new OrderController());
    }
}
