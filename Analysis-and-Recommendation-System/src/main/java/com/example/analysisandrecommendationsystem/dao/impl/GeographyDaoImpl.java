package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.GeographyDao;
import com.example.analysisandrecommendationsystem.entity.Advertisement;
import com.example.analysisandrecommendationsystem.entity.Geography;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeographyDaoImpl implements GeographyDao {
    private final static String LIST = "select * from geography";
    private final static String INFO = "select * from geography where `name` = ? and address = ?";
    private final static String UPDATE = "update geography set address = ? where name = ?";
    private final static String DELETE = "delete from geography where `name` = ? and address = ?";
    private final static String INSERT = "insert into geography(`name`, address) values(?, ?)";
    @Override
    public List<Geography> geoList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Geography> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Geography geography = new Geography();
                geography.setName(resultSet.getString("name"));
                geography.setAddress(resultSet.getString("address"));
                list.add(geography);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public Geography getGeoInfo(String name, String address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Geography geography = new Geography();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INFO);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                geography.setName(resultSet.getString("name"));
                geography.setAddress(resultSet.getString("address"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return geography;
    }

    @Override
    public void updateInfo(String name, String address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,address);
            preparedStatement.setString(2,name);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void deleteInfo(String name, String address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void insertInfo(String name, String address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }
}
