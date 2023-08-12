package com.example.analysisandrecommendationsystem.controller.enrollment;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Geography;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;
import com.example.analysisandrecommendationsystem.service.GeographyService;
import com.example.analysisandrecommendationsystem.service.impl.EnrollmentServiceImpl;
import com.example.analysisandrecommendationsystem.service.impl.GeographyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getenrollinfo")
public class GetEnrollInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String province = req.getParameter("province");
//        System.out.println(name+" "+province);
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        EnrollmentInfo enrollmentInfo = enrollmentService.getEnrollInfo(name, province);
        System.out.println(enrollmentInfo.getName());
        if(enrollmentInfo.getName()!=null && enrollmentInfo.getProvince()!=null && !enrollmentInfo.getName().equals("") && !enrollmentInfo.getProvince().equals("")){
            req.getSession().setAttribute("enrollInfo",enrollmentInfo);
            resp.sendRedirect("/jsp/editenroll.jsp");
        }
    }
}
