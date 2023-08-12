package com.example.analysisandrecommendationsystem.controller.enrollment;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;
import com.example.analysisandrecommendationsystem.service.impl.EnrollmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/enrolllistbyname")
public class EnrollListByNameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        List<EnrollmentInfo> list = enrollmentService.getEnrollListByName(name);
        req.getSession().setAttribute("schoolEnrollList",list);
        resp.sendRedirect("/jsp/universityenroll.jsp");
    }
}
