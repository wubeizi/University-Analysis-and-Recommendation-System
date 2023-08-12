package com.example.analysisandrecommendationsystem.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获得之前登录的时候设置的session
        HttpSession httpSession = request.getSession();
//        由于之前登陆的时候设置的名称为user，故移除user
        httpSession.removeAttribute("user");
        httpSession.removeAttribute("admin");
        httpSession.invalidate();
//        重定向到登陆页面
        response.sendRedirect("/jsp/login.jsp");

    }
}
