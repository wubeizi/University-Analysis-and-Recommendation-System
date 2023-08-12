package com.example.analysisandrecommendationsystem.controller.user;

import com.example.analysisandrecommendationsystem.entity.User;
import com.example.analysisandrecommendationsystem.service.UserService;
import com.example.analysisandrecommendationsystem.service.impl.UserServiceImpl;
import com.example.analysisandrecommendationsystem.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/modifyuserinfo")
@MultipartConfig
public class ModifyUserInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        登录后，获取user实例
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        String username = user.getUsername();

        UserService userService = new UserServiceImpl();

        // 获取提交来的信息
        Part avatarPart = request.getPart("avatar");
//        String ava = request.getParameter("avatar");

        System.out.println(avatarPart);
//        System.out.println(ava);

        // 生成唯一的文件名
        String fileName = UUID.randomUUID().toString() + "-" + avatarPart.getSubmittedFileName();

        // 指定保存路径
        String uploadDir = request.getServletContext().getRealPath("/upload/");


        // 保存文件
        avatarPart.write(uploadDir + fileName);

        // 构造URL
        String fileUrl = "../upload/" + fileName;

        String birthdayString = request.getParameter("birthday");
        String genderString = request.getParameter("gender");
        String password = request.getParameter("password");

        Date birthday = null;
        Utils utils = new Utils();
        try {
            birthday = utils.stringtoDate(birthdayString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String gender;
        if(genderString.equals("female")){
            gender = "女";
        }else{
            gender = "男";
        }


        userService.modifyUserInfo(fileUrl,birthday,gender,password,username);

        user = userService.login(username,password);
        request.getSession().setAttribute("user", user);

        response.sendRedirect("/jsp/my.jsp");
    }

}
