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

@WebServlet("/updatead")
public class UpdateAdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String name = request.getParameter("school");

        AdvertiseService advertiseService = new AdvertiseServiceImpl();
        advertiseService.updateAdInfo(title,content,name);
        List<Advertisement> list = advertiseService.list();
        if(!list.isEmpty()){
            request.getSession().setAttribute("advertisementList",list);
        }
        request.getRequestDispatcher("/jsp/main.jsp").forward(request,response);
    }
}
