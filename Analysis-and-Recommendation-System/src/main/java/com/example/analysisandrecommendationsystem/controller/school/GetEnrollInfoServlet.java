//package com.example.analysisandrecommendationsystem.controller.school;
//
//import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
//import com.example.analysisandrecommendationsystem.service.SchoolService;
//import com.example.analysisandrecommendationsystem.service.impl.SchoolServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/getenrollinfo")
//public class GetEnrollInfoServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String province = request.getParameter("province");
//        String name = request.getParameter("name");
//        SchoolService service = new SchoolServiceImpl();
//        EnrollmentInfo enrollmentInfo = service.getEnrollInfo(name, province);
//        if(enrollmentInfo.getName() != null && !enrollmentInfo.getName().equals("") && enrollmentInfo.getProvince() != null && !enrollmentInfo.getProvince().equals("")){
//            request.setAttribute("enrollmentInfo",enrollmentInfo);
////            跳转到某个页面
////            request.getRequestDispatcher("")
//        }
//    }
//}
