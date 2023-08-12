package com.example.analysisandrecommendationsystem.controller.major;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.MajorInfo;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;
import com.example.analysisandrecommendationsystem.service.MajorService;
import com.example.analysisandrecommendationsystem.service.impl.EnrollmentServiceImpl;
import com.example.analysisandrecommendationsystem.service.impl.MajorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getmajorinfo")
public class GetMajorInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String major = req.getParameter("major");
        MajorService majorService = new MajorServiceImpl();
        MajorInfo majorInfo = majorService.getMajorInfo(major);
        if(majorInfo.getMajor()!=null  && !majorInfo.getMajor().equals("")){
            req.getSession().setAttribute("majorInfo",majorInfo);
            resp.sendRedirect("/jsp/editmajor.jsp");
        }
    }
}
