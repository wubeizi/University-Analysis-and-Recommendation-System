package com.example.analysisandrecommendationsystem.controller.enrollment;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;
import com.example.analysisandrecommendationsystem.service.impl.EnrollmentServiceImpl;
import com.example.analysisandrecommendationsystem.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateenroll")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String province = req.getParameter("province");
        String score2020String = req.getParameter("score2020");
        String score2021String = req.getParameter("score2021");
        String score2022String = req.getParameter("score2022");
        String enroll2020 = req.getParameter("enrollmentNumber2020");
        String enroll2021 = req.getParameter("enrollmentNumber2021");
        String enroll2022 = req.getParameter("enrollmentNumber2022");

        Utils utils = new Utils();
        int s20 = utils.stringtoInt(score2020String);
        int s21 = utils.stringtoInt(score2021String);
        int s22 = utils.stringtoInt(score2022String);
        int e20 = utils.stringtoInt(enroll2020);
        int e21 = utils.stringtoInt(enroll2021);
        int e22 = utils.stringtoInt(enroll2022);

        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        enrollmentService.updateEnrollInfo(name,province,s20,s21,s22,e20,e21,e22);

        List<EnrollmentInfo> list = enrollmentService.getEnrollList();
        if(!list.isEmpty()){
            req.getSession().setAttribute("enrollList",list);
            resp.sendRedirect("/jsp/manageenrollment.jsp");
        }

    }
}
