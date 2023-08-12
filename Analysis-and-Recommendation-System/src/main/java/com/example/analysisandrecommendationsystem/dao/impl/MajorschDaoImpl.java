package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.MajorschDao;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Schmaj;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MajorschDaoImpl implements MajorschDao {
    private final static String LIST = "select * from schmaj";
    private final static String INFO = "select * from schmaj where `name` = ? and major = ?";
    private final static String DELETE = "delete from schmaj where `name`= ? and major = ?";
    private final static String INSERT = "insert into schmaj(`name`, major) values(?, ?)";
    @Override
    public List<Schmaj> getMajorschList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Schmaj> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Schmaj schmaj = new Schmaj();
                schmaj.setName(resultSet.getString("name"));
                schmaj.setMajor(resultSet.getString("major"));
                list.add(schmaj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public Schmaj getMajorschInfo(String name, String major) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Schmaj schmaj = new Schmaj();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INFO);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,major);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                schmaj.setName(resultSet.getString("name"));
                schmaj.setMajor(resultSet.getString("major"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return schmaj;
    }

    @Override
    public void deleteMajorsch(String name, String major) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,major);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void insertMajorsch(String name, String major) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,major);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }
}
