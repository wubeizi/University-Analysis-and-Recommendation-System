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

@WebServlet("/deleteenroll")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String province = req.getParameter("province");
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        enrollmentService.deleteEnroll(name,province);

        List<EnrollmentInfo> list = enrollmentService.getEnrollList();
        if(!list.isEmpty()){
            req.getSession().setAttribute("enrollList",list);
            resp.sendRedirect("/jsp/manageenrollment.jsp");
        }
    }
}
