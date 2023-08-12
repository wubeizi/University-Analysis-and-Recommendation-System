package com.example.analysisandrecommendationsystem.controller.hotspot;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Hotspot;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;
import com.example.analysisandrecommendationsystem.service.HotspotService;
import com.example.analysisandrecommendationsystem.service.impl.EnrollmentServiceImpl;
import com.example.analysisandrecommendationsystem.service.impl.HotspotServiceImpl;
import com.example.analysisandrecommendationsystem.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/inserthotspot")
public class InsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String word = req.getParameter("word");
        String hts = req.getParameter("heatRatio");

        Utils utils = new Utils();
        float heatRatio = utils.stringtoFloat(hts);

        HotspotService service = new HotspotServiceImpl();
        Hotspot test = service.getHotspotInfo(name,word);
        if(test.getName()!=null && !test.getName().equals("")){
            String errormessage = "插入失败，已有主键实体";
            req.setAttribute("errorMessage",errormessage);
            req.getRequestDispatcher("/jsp/addnewhotspot.jsp").forward(req,resp);
        }else {
            service.insertHotspotInfo(name,word,heatRatio);

            List<Hotspot> list = service.getHotspotList();
            if (!list.isEmpty()) {
                req.getSession().setAttribute("hotspotList", list);
                resp.sendRedirect("/jsp/managehotspot.jsp");
            }
        }
    }
}
