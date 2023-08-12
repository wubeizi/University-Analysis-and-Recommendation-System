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
import java.util.List;

@WebServlet("/deletemajorsch")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String major = req.getParameter("major");
        MajorschService majorschService = new MajorschServiceImpl();
        majorschService.deleteMajorsch(name,major);

        List<Schmaj> list = majorschService.getMajorschList();
        if(!list.isEmpty()){
            req.getSession().setAttribute("majorschList",list);
            resp.sendRedirect("/jsp/managemajorsch.jsp");
        }
    }
}
