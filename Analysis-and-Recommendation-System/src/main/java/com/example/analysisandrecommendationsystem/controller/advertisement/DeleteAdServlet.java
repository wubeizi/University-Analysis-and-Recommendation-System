package com.example.analysisandrecommendationsystem.controller.advertisement;

import com.example.analysisandrecommendationsystem.entity.Advertisement;
import com.example.analysisandrecommendationsystem.service.AdvertiseService;
import com.example.analysisandrecommendationsystem.service.impl.AdvertiseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteadinfo")
public class DeleteAdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        AdvertiseService advertiseService = new AdvertiseServiceImpl();
        advertiseService.deleteAdInfo(title,name);
        List<Advertisement> list = advertiseService.list();
        request.getSession().setAttribute("advertisementList",list);
        response.sendRedirect("/jsp/main.jsp");

    }
}
