package org.scoula.takoyaki;

import org.scoula.takoyaki.command.Command;
import org.scoula.takoyaki.controller.HomeController;
import org.scoula.takoyaki.controller.MenuController;
import org.scoula.takoyaki.dispatcher.DispatcherServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends DispatcherServlet {
    HomeController homeController = new HomeController();
    MenuController menuController = new MenuController();

    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    Map<String, Command> getMap;
    Map<String, Command> postMap;


    @Override
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        getMap.put("/", HomeController::getIndex);
        getMap.put("/menu/list", MenuController::getList);
        getMap.put("/menu/add", MenuController::getAddForm);
        getMap.put("/order/new", MenuController::getNew);
        getMap.put("/order/result", MenuController::getResult);
        postMap.put("/menu/list", MenuController::postList);
        postMap.put("/menu/add", MenuController::postAdd);
        postMap.put("/order/new", MenuController::postNew);
        postMap.put("/order/result", MenuController::postResult);
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = getCommand(req);
        if (command != null) {
            execute(command, req, resp);
        } else {
            // 404 에러 처리
            String view = prefix + 404 + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void execute(Command command, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String viewName = command.execute(req, resp);
        if (viewName.startsWith("redirect:")) {
            resp.sendRedirect(viewName.substring("redirect:".length()));
        } else {
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req, resp);
        }
    }

    private String getCommandName(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest req) {
        String commandName = getCommandName(req);

        Command command;
        if (req.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }
        return command;
    }
}

