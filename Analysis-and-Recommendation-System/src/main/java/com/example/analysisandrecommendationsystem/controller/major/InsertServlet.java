package com.example.analysisandrecommendationsystem.controller.major;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.MajorInfo;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;
import com.example.analysisandrecommendationsystem.service.MajorService;
import com.example.analysisandrecommendationsystem.service.impl.EnrollmentServiceImpl;
import com.example.analysisandrecommendationsystem.service.impl.MajorServiceImpl;
import com.example.analysisandrecommendationsystem.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/insertmajor")
public class InsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String major = req.getParameter("major");

        MajorService majorService = new MajorServiceImpl();
        MajorInfo test = majorService.getMajorInfo(major);
        if(test.getMajor()!=null && !test.getMajor().equals("")){
            String errormessage = "插入失败，已有主键实体";
            req.setAttribute("errorMessage",errormessage);
            req.getRequestDispatcher("/jsp/addnewmajor.jsp").forward(req,resp);
        }else {
            majorService.insertMajorInfo(major);

            List<MajorInfo> list = majorService.getMajorList();
            if (!list.isEmpty()) {
                req.getSession().setAttribute("majorList", list);
                resp.sendRedirect("/jsp/managemajor.jsp");
            }
        }
    }
}
