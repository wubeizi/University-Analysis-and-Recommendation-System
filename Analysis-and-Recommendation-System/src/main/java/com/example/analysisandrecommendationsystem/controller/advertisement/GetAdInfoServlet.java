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

@WebServlet("/getadinfo")
public class GetAdInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        System.out.println(title);
        AdvertiseService advertiseService = new AdvertiseServiceImpl();
        Advertisement advertisement = advertiseService.getAdInfo(title);
//        System.out.println(advertisement);
        if(advertisement.getTitle()!=null && !advertisement.getTitle().equals("")){
//            System.out.println("you");
            request.getSession().setAttribute("advertisement",advertisement);
            response.sendRedirect("/jsp/editad.jsp");
        }
    }
}
