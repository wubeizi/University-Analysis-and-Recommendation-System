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

@WebServlet("/adlist")
public class AdvertisementList extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取所有大学的广告内容
        AdvertiseService advertiseService = new AdvertiseServiceImpl();
        List<Advertisement> list = advertiseService.list();
        if(!list.isEmpty()){
            request.getSession().setAttribute("advertisementList",list);
        }
        request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
    }
}
