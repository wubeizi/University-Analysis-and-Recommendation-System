package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.FeedbackDao;
import com.example.analysisandrecommendationsystem.entity.Advertisement;
import com.example.analysisandrecommendationsystem.entity.Feedback;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDaoImpl implements FeedbackDao {
    private final static String SOLIST="select * from feedback where status = '已解决'";
    private final static String UNLIST="select * from feedback where status = '未解决'";
    private final static String UPDATE = "update feedback set method = ? ,status = '已解决' where username = ? and feedback = ?";
    @Override
    public List<Feedback> getSolvedList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Feedback> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(SOLIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Feedback feedback = new Feedback();
                feedback.setUsername(resultSet.getString("username"));
                feedback.setFeedback(resultSet.getString("feedback"));
                feedback.setMethod(resultSet.getString("method"));
                feedback.setStatus(resultSet.getString("status"));
                list.add(feedback);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public List<Feedback> getUnsolvedList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Feedback> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(UNLIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Feedback feedback = new Feedback();
                feedback.setUsername(resultSet.getString("username"));
                feedback.setFeedback(resultSet.getString("feedback"));
                feedback.setMethod(resultSet.getString("method"));
                feedback.setStatus(resultSet.getString("status"));

                list.add(feedback);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public void updateFeedback(String username, String feedback, String method) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,method);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,feedback);

            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
        return;
    }
}
