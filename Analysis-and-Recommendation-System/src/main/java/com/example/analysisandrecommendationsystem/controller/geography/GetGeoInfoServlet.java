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

@WebServlet("/getgeoinfo")
public class GetGeoInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        GeographyService service = new GeographyServiceImpl();
        Geography geography = service.getGeoInfo(name, address);
        if(geography.getName()!=null && geography.getAddress()!=null && !geography.getName().equals("") && !geography.getAddress().equals("")){
            req.getSession().setAttribute("geographyInfo",geography);
            resp.sendRedirect("/jsp/editgeo.jsp");
        }
    }
}
