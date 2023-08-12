package com.example.analysisandrecommendationsystem.controller.user;

import com.example.analysisandrecommendationsystem.entity.Administrator;
import com.example.analysisandrecommendationsystem.entity.User;
import com.example.analysisandrecommendationsystem.service.AdminService;
import com.example.analysisandrecommendationsystem.service.UserService;
import com.example.analysisandrecommendationsystem.service.impl.AdminServiceImpl;
import com.example.analysisandrecommendationsystem.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
//        System.out.println(role);
//        若role为null，则代表是用户登录，否则代表为管理员登录
        if(role != null && role.equals("admin")){

            AdminService adminService = new AdminServiceImpl();
            Administrator administrator = adminService.login(name, password);
            if(administrator.getAdminname() != null && !administrator.getAdminname().equals("") && administrator.getPassword() != null && !administrator.getPassword().equals("")){
                request.getSession().setAttribute("admin",administrator);
//                System.out.println("管理员登录成功");
                request.getSession().setAttribute("isadmin",true);
                request.getRequestDispatcher("/adlist").forward(request,response);
            }else {
                request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            }
        }
        else {
            UserService userService = new UserServiceImpl();
            User user = userService.login(name, password);
            if (user.getUsername() != null && !user.getUsername().equals("") && user.getPassword() != null && !user.getPassword().equals("")) {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("isadmin",false);
                response.sendRedirect("/search985");
//                response.sendRedirect("/search211");
//                request.getRequestDispatcher("/adlist").forward(request,response);
//            调用其他的方法
//            request.getRequestDispatcher("/list").forward(request, response);
//            System.out.println("登陆成功");
//            System.out.println(user.getBirthday());
            } else {
                request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            }
        }
    }


}
