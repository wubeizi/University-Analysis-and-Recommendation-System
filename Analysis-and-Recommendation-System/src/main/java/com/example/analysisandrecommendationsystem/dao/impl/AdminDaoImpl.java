package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.AdminDao;
import com.example.analysisandrecommendationsystem.entity.Administrator;
import com.example.analysisandrecommendationsystem.entity.User;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDaoImpl implements AdminDao {

    private final static String LOGIN = "select * from administrator where adminname = ? and password = ?";

    @Override
    public Administrator login(String name, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Administrator administrator = new Administrator();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                administrator.setAdminname(resultSet.getString("adminname"));
                administrator.setPassword(resultSet.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return administrator;
    }
}
