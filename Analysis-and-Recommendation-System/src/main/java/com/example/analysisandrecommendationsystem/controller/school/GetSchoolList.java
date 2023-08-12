package com.example.analysisandrecommendationsystem.controller.school;

import com.example.analysisandrecommendationsystem.entity.School;
import com.example.analysisandrecommendationsystem.service.SchoolService;
import com.example.analysisandrecommendationsystem.service.impl.SchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getschoollist")
public class GetSchoolList extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SchoolService service = new SchoolServiceImpl();
        List<School> list = service.getSchoolList();
        if(!list.isEmpty()){
            request.getSession().setAttribute("schoolList",list);
            System.out.println(list);
            response.sendRedirect("/jsp/manageschool.jsp");
        }
    }
}
