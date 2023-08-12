package com.example.analysisandrecommendationsystem.controller.school;

import com.example.analysisandrecommendationsystem.service.SchoolService;
import com.example.analysisandrecommendationsystem.service.impl.SchoolServiceImpl;
import com.example.analysisandrecommendationsystem.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateschool")
public class UpdateSchoolServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utils utils = new Utils();
        String name = request.getParameter("name");
        String rank = request.getParameter("rank");
        String type = request.getParameter("type");
        String heat = request.getParameter("heat");
        String telephone = request.getParameter("telephone");
        String introduction = request.getParameter("introduction");
        String employmentRatio = request.getParameter("employmentRatio");
        String goAbroadRatio = request.getParameter("goAbroadRatio");
        String enrollmentRatio = request.getParameter("enrollmentRatio");
        String sexRatio = request.getParameter("sexRatio");
        String location = request.getParameter("location");
        String logo = request.getParameter("logo");

        float em = utils.stringtoFloat(employmentRatio);
        float go = utils.stringtoFloat(goAbroadRatio);
        float en = utils.stringtoFloat(enrollmentRatio);
        float se = utils.stringtoFloat(sexRatio);

        SchoolService service = new SchoolServiceImpl();
        service.updateSchoolInfo(name,rank,type,heat,telephone,introduction,em,go,en,se,location,logo);

        request.getRequestDispatcher("/getschoollist").forward(request,response);


    }
}
