package com.example.analysisandrecommendationsystem.controller.hotspot;

import com.example.analysisandrecommendationsystem.entity.Hotspot;
import com.example.analysisandrecommendationsystem.service.HotspotService;
import com.example.analysisandrecommendationsystem.service.impl.HotspotServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hotspotlist")
public class ListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotspotService service = new HotspotServiceImpl();
        List<Hotspot> list = service.getHotspotList();
        if(!list.isEmpty()){
            req.getSession().setAttribute("hotspotList",list);
            resp.sendRedirect("/jsp/managehotspot.jsp");
        }
    }
}
