package com.example.analysisandrecommendationsystem.controller.majorsch;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Schmaj;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;
import com.example.analysisandrecommendationsystem.service.MajorschService;
import com.example.analysisandrecommendationsystem.service.impl.EnrollmentServiceImpl;
import com.example.analysisandrecommendationsystem.service.impl.MajorschServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getmajorschinfo")
public class GetMajorschInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String major = req.getParameter("major");

        MajorschService majorschService = new MajorschServiceImpl();
        Schmaj schmaj = majorschService.getMajorschInfo(name, major);

        if(schmaj.getName()!=null && schmaj.getMajor()!=null && !schmaj.getName().equals("") && !schmaj.getMajor().equals("")){
            req.getSession().setAttribute("majorschInfo",schmaj);
//            resp.sendRedirect("/jsp/editenroll.jsp");
        }
    }
}
