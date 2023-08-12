package com.example.analysisandrecommendationsystem.controller.school;

import com.example.analysisandrecommendationsystem.service.SchoolService;
import com.example.analysisandrecommendationsystem.service.impl.SchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search985")
public class Search985Name extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SchoolService service = new SchoolServiceImpl();
        List<String> list = service.search985();
        if (!list.isEmpty()){
            request.getSession().setAttribute("list985",list);
//            dispatcher到当前页面
//            System.out.println(list);
            response.sendRedirect("/search211");
        }
    }
}
