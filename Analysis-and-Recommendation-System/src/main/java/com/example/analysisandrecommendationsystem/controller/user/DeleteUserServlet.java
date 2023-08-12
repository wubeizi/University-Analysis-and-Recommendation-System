package com.example.analysisandrecommendationsystem.controller.user;


import com.example.analysisandrecommendationsystem.entity.User;
import com.example.analysisandrecommendationsystem.service.UserService;
import com.example.analysisandrecommendationsystem.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserService service = new UserServiceImpl();
        service.deleteUser(username);

        List<User> list = service.getUserList();
        if(!list.isEmpty()){
            req.getSession().setAttribute("userList",list);
            resp.sendRedirect("/jsp/manageuser.jsp");
        }
    }
}
