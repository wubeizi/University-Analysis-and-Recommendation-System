package com.example.analysisandrecommendationsystem.controller.geography;

import com.example.analysisandrecommendationsystem.entity.Geography;
import com.example.analysisandrecommendationsystem.service.GeographyService;
import com.example.analysisandrecommendationsystem.service.impl.GeographyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/geolist")
public class ListServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GeographyService geographyService = new GeographyServiceImpl();
        List<Geography> list = geographyService.geoList();
        if(!list.isEmpty()){
            req.getSession().setAttribute("geoList",list);
            resp.sendRedirect("/jsp/managegeography.jsp");
        }
    }
}
