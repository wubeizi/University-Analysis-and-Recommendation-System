package com.example.analysisandrecommendationsystem.controller.school;

import com.example.analysisandrecommendationsystem.service.SchoolService;
import com.example.analysisandrecommendationsystem.service.impl.SchoolServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/searchBySchoolName")
public class SearchByNameServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String keyword = request.getParameter("keyword");
//        SchoolService service = new SchoolServiceImpl();
//        List<String> list = service.searchByName(keyword);
//        if (!list.isEmpty()){
//            request.setAttribute("searchSchoolList",list);
//            System.out.println(list);
//        }
//        request.getRequestDispatcher("/jsp/left.jsp").forward(request,response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        System.out.println(keyword);
        SchoolService service = new SchoolServiceImpl();
        List<String> list = service.searchByName(keyword);
        System.out.println(list);
        if (!list.isEmpty()){
            // 将List<String>转换为JSON字符串
            String json = new Gson().toJson (list);
            PrintWriter out = response.getWriter ();
            response.setContentType ( "application/json" );
            response.setCharacterEncoding ( "UTF-8" );
            response.getWriter().write(json);

        }

    }
}
