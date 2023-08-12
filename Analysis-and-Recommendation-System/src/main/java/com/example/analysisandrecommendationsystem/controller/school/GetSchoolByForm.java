package com.example.analysisandrecommendationsystem.controller.school;

import com.example.analysisandrecommendationsystem.entity.CollegeApplicationItem;
import com.example.analysisandrecommendationsystem.service.SchoolService;
import com.example.analysisandrecommendationsystem.service.impl.SchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getschollform")
public class GetSchoolByForm extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String province = request.getParameter("province");
        String type = request.getParameter("type");
        String scoreString = request.getParameter("score");
//        System.out.println(province+" "+type+" "+scoreString);
        if(province.equals("all")){
            province = null;
        }if(type.equals("all")){
            type = null;
        }

        int score = Integer.parseInt(scoreString);
        SchoolService service = new SchoolServiceImpl();
        List<CollegeApplicationItem> list = service.getSchoolByForm(province, type, score);
//        System.out.println(list);
        if(!list.isEmpty() && list!=null){
            System.out.println(list.get(0).getName());
            request.setAttribute("applicationitem",list);

        }else {
            String errorMessage = "未找到相关推荐学校";
            System.out.println(errorMessage);
            request.setAttribute("errorMessage",errorMessage);
        }
        request.getRequestDispatcher("/jsp/education.jsp").forward(request,response);
    }
}
