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

@WebServlet("/updatefeedback")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String feedback = req.getParameter("feedback");
        String method = req.getParameter("method");
        FeedbackService service = new FeedbackServiceImpl();
        service.updateFeedback(username,feedback,method);

        List<Feedback> list = service.getUnsolvedList();
        req.getSession().setAttribute("unsolvedList",list);
        req.getRequestDispatcher("/jsp/feedbackun.jsp").forward(req,resp);

    }
}
