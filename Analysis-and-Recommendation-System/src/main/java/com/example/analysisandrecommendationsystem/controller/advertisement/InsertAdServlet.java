package com.example.analysisandrecommendationsystem.controller.advertisement;

import com.example.analysisandrecommendationsystem.entity.Advertisement;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.service.AdvertiseService;
import com.example.analysisandrecommendationsystem.service.impl.AdvertiseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/insertad")
public class InsertAdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String contenttext = req.getParameter("content");
        AdvertiseService service = new AdvertiseServiceImpl();

        Advertisement test = service.getAdInfo(title);
        if(test.getName()!=null && !test.getName().equals("")){
            String errormessage = "插入失败，已有主键实体";
            req.setAttribute("errorMessage",errormessage);
            req.getRequestDispatcher("/jsp/addnewenroll.jsp").forward(req,resp);
        }else {
            service.insertAd(name,title,contenttext);
            List<Advertisement> list = service.list();
            if(!list.isEmpty()){
                req.getSession().setAttribute("advertisementList",list);
            }
            req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
        }

    }
}
