package com.example.analysisandrecommendationsystem.controller.user;

import com.example.analysisandrecommendationsystem.service.UserService;
import com.example.analysisandrecommendationsystem.service.impl.UserServiceImpl;
import com.example.analysisandrecommendationsystem.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

@WebServlet("/getpassword")
public class GetPassword extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String birthdayString = request.getParameter("birthday");
        String sexString = request.getParameter("sex");
        String sex;
        System.out.println(sexString);
        if(sexString.equals("male")){
            sex = "男";
        }else {
            sex = "女";
        }

        Date birthday = null;
        Utils utils = new Utils();

        try {
            birthday = utils.stringtoDate(birthdayString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        UserService service = new UserServiceImpl();
        System.out.println(name+" "+birthday+" "+sex);
        String password = service.getPassword(name,birthday,sex);
//        System.out.println(password);

        if(password!=null && !password.equals("")){
            request.setAttribute("password",password);
        }else {
            request.setAttribute("password","未找到，请检查输入信息！");
        }
        request.getRequestDispatcher("/jsp/forgotpassword.jsp").forward(request,response);
    }
}
