package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.FeedbackDao;
import com.example.analysisandrecommendationsystem.dao.impl.FeedbackDaoImpl;
import com.example.analysisandrecommendationsystem.entity.Feedback;
import com.example.analysisandrecommendationsystem.service.FeedbackService;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackDao feedbackDao = new FeedbackDaoImpl();
    @Override
    public List<Feedback> getSolvedList() {
        return feedbackDao.getSolvedList();
    }

    @Override
    public List<Feedback> getUnsolvedList() {
        return feedbackDao.getUnsolvedList();
    }

    @Override
    public void updateFeedback(String username, String feedback, String method) {
        feedbackDao.updateFeedback(username,feedback,method);
    }
}
