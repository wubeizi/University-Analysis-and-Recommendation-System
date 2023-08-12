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
import java.util.List;

@WebServlet("/deletemajor")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String major = req.getParameter("major");
        MajorService majorService = new MajorServiceImpl();
        majorService.deleteMajor(major);

        List<MajorInfo> list = majorService.getMajorList();
        if(!list.isEmpty()){
            req.getSession().setAttribute("majorList",list);
            resp.sendRedirect("/jsp/managemajor.jsp");
        }
    }
}
