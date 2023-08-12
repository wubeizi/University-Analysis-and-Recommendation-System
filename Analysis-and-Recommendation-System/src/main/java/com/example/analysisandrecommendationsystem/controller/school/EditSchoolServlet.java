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

@WebServlet("/editschool")
public class EditSchoolServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        SchoolService service = new SchoolServiceImpl();
        School school = new School();
        school = service.getSchoolInfo(name);
        request.getSession().setAttribute("school",school);
        response.sendRedirect("/jsp/editschool.jsp");
    }
}
