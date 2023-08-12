package com.example.analysisandrecommendationsystem.controller.majorsch;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Schmaj;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;
import com.example.analysisandrecommendationsystem.service.MajorschService;
import com.example.analysisandrecommendationsystem.service.impl.EnrollmentServiceImpl;
import com.example.analysisandrecommendationsystem.service.impl.MajorschServiceImpl;
import com.example.analysisandrecommendationsystem.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/insertmajorsch")
public class InsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String major = req.getParameter("major");

        MajorschService majorschService = new MajorschServiceImpl();
        Schmaj test = majorschService.getMajorschInfo(name,major);

        if(test.getName()!=null && !test.getName().equals("")){
            String errormessage = "插入失败，已有主键实体";
            req.setAttribute("errorMessage",errormessage);
            req.getRequestDispatcher("/jsp/addnewmajorsch.jsp").forward(req,resp);
        }else {
            majorschService.insertMajorsch(name, major);

            List<Schmaj> list = majorschService.getMajorschList();
            if (!list.isEmpty()) {
                req.getSession().setAttribute("majorschList", list);
                resp.sendRedirect("/jsp/managemajorsch.jsp");
            }
        }
    }
}
