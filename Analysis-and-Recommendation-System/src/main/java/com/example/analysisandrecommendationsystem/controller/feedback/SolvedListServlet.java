package com.example.analysisandrecommendationsystem.controller.feedback;

import com.example.analysisandrecommendationsystem.entity.Feedback;
import com.example.analysisandrecommendationsystem.service.FeedbackService;
import com.example.analysisandrecommendationsystem.service.impl.FeedbackServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/solvedlist")
public class SolvedListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackService service = new FeedbackServiceImpl();
        List<Feedback> list = service.getSolvedList();
        if(!list.isEmpty()){
            req.getSession().setAttribute("solvedList",list);
        }
        resp.sendRedirect("/jsp/feedbackso.jsp");
    }
}
