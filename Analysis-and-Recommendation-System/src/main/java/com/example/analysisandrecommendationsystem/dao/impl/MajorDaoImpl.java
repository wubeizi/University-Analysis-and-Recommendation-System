package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.MajorDao;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.MajorInfo;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MajorDaoImpl implements MajorDao {
    private final static String LIST = "select * from majorinfo";
    private final static String INFO = "select * from majorinfo where major = ?";
    private final static String INSERT = "insert into majorinfo(major) values(?)";
    private final static String DELETE = "delete from majorinfo where major = ?";
    @Override
    public List<MajorInfo> getMajorList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MajorInfo> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MajorInfo majorInfo = new MajorInfo();
                majorInfo.setMajor(resultSet.getString("major"));
                list.add(majorInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public MajorInfo getMajorInfo(String major) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        MajorInfo majorInfo = new MajorInfo();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INFO);
            preparedStatement.setString(1,major);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                majorInfo.setMajor(resultSet.getString("major"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return majorInfo;
    }

    @Override
    public void insertMajorInfo(String major) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,major);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void deleteMajor(String major) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1,major);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }
}
