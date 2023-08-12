package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.EnrollmentDao;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Geography;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDaoImpl implements EnrollmentDao {
    private final static String LIST = "select * from enrollmentinfo";
    private final static String INFO = "select * from enrollmentinfo where `name` = ? and province = ?";
    private final static String UPDATE = "update enrollmentinfo set score2020 = ?, score2021=?, score2022 = ?, enrollmentNumber2020 = ?, enrollmentNumber2021 = ?, enrollmentNumber2022 = ? where `name` = ? and province = ?";
    private final static String DELETE = "delete from enrollmentinfo where `name` = ? and province = ?";
    private final static String INSERT = "insert into enrollmentinfo(score2020, score2021, score2022, enrollmentNumber2020, enrollmentNumber2021, enrollmentNumber2022, name, province) values(?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String LISTBYNAME = "select * from enrollmentinfo where `name` = ?";
    @Override
    public List<EnrollmentInfo> getEnrollList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EnrollmentInfo> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                EnrollmentInfo enrollmentInfo = new EnrollmentInfo();
                enrollmentInfo.setName(resultSet.getString("name"));
                enrollmentInfo.setProvince(resultSet.getString("province"));
                enrollmentInfo.setEnrollmentNumber2021(resultSet.getInt("enrollmentNumber2021"));
                enrollmentInfo.setEnrollmentNumber2022(resultSet.getInt("enrollmentNumber2022"));
                enrollmentInfo.setEnrollmentNumber2020(resultSet.getInt("enrollmentNumber2020"));
                enrollmentInfo.setScore2022(resultSet.getInt("score2022"));
                enrollmentInfo.setScore2021(resultSet.getInt("score2021"));
                enrollmentInfo.setScore2020(resultSet.getInt("score2020"));
                list.add(enrollmentInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public EnrollmentInfo getEnrollInfo(String name, String province) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        EnrollmentInfo enrollmentInfo = new EnrollmentInfo();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INFO);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,province);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                enrollmentInfo.setName(resultSet.getString("name"));
                enrollmentInfo.setProvince(resultSet.getString("province"));
                enrollmentInfo.setEnrollmentNumber2021(resultSet.getInt("enrollmentNumber2021"));
                enrollmentInfo.setEnrollmentNumber2022(resultSet.getInt("enrollmentNumber2022"));
                enrollmentInfo.setEnrollmentNumber2020(resultSet.getInt("enrollmentNumber2020"));
                enrollmentInfo.setScore2022(resultSet.getInt("score2022"));
                enrollmentInfo.setScore2021(resultSet.getInt("score2021"));
                enrollmentInfo.setScore2020(resultSet.getInt("score2020"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return enrollmentInfo;
    }

    @Override
    public void updateEnrollInfo(String name, String province, int s20, int s21, int s22, int e20, int e21, int e22) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1,s20);
            preparedStatement.setInt(2,s21);
            preparedStatement.setInt(3,s22);
            preparedStatement.setInt(4,e20);
            preparedStatement.setInt(5,e21);
            preparedStatement.setInt(6,e22);
            preparedStatement.setString(7,name);
            preparedStatement.setString(8,province);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void deleteEnroll(String name, String province) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,province);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void insertEnrollInfo(String name, String province, int s20, int s21, int s22, int e20, int e21, int e22) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,s20);
            preparedStatement.setInt(2,s21);
            preparedStatement.setInt(3,s22);
            preparedStatement.setInt(4,e20);
            preparedStatement.setInt(5,e21);
            preparedStatement.setInt(6,e22);
            preparedStatement.setString(7,name);
            preparedStatement.setString(8,province);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public List<EnrollmentInfo> getEnrollListByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EnrollmentInfo> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(LISTBYNAME);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                EnrollmentInfo enrollmentInfo = new EnrollmentInfo();
                enrollmentInfo.setName(resultSet.getString("name"));
                enrollmentInfo.setProvince(resultSet.getString("province"));
                enrollmentInfo.setEnrollmentNumber2021(resultSet.getInt("enrollmentNumber2021"));
                enrollmentInfo.setEnrollmentNumber2022(resultSet.getInt("enrollmentNumber2022"));
                enrollmentInfo.setEnrollmentNumber2020(resultSet.getInt("enrollmentNumber2020"));
                enrollmentInfo.setScore2022(resultSet.getInt("score2022"));
                enrollmentInfo.setScore2021(resultSet.getInt("score2021"));
                enrollmentInfo.setScore2020(resultSet.getInt("score2020"));
                list.add(enrollmentInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }
}
