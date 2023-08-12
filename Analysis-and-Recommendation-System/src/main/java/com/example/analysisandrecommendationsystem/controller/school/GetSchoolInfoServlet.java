package com.example.analysisandrecommendationsystem.controller.school;

import com.example.analysisandrecommendationsystem.entity.Hotspot;
import com.example.analysisandrecommendationsystem.entity.School;
import com.example.analysisandrecommendationsystem.service.SchoolService;
import com.example.analysisandrecommendationsystem.service.impl.SchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getschoolInfo")
public class GetSchoolInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("school");
        request.getSession().removeAttribute("majorList");
        request.getSession().removeAttribute("hotspotList");
        String name = request.getParameter("name");
        SchoolService service = new SchoolServiceImpl();
        School school = new School();
        List<String> majorlist = new ArrayList<>();
        List<Hotspot> hotspotList = new ArrayList<>();
        school = service.getSchoolInfo(name);
        majorlist = service.getSchoolMajorlist(name);
        hotspotList = service.getHotSpotList(name);
        System.out.println("gp"+school.getGoAbroadRatio());
        request.getSession().setAttribute("school",school);
        request.getSession().setAttribute("majorlist",majorlist);
        request.getSession().setAttribute("hotspotList",hotspotList);
        response.sendRedirect("/jsp/universityinfo.jsp");
    }
}
