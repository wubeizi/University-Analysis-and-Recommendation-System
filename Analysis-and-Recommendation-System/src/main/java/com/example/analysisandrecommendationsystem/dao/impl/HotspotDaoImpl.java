package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.HotspotDao;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Hotspot;
import com.example.analysisandrecommendationsystem.service.HotspotService;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotspotDaoImpl implements HotspotDao {

    private static final String LIST = "select * from hotspot";
    private static final String INFO = "select * from hotspot where `name` = ? and word = ?";
    private static final String DELETE = "delete from hotspot where `name` = ? and word = ?";
    private static final String UPDATE = "update hotspot set heatRatio = ? where `name` = ? and word = ?";
    private static final String INSERT = "insert into hotspot(`name`,word,heatRatio) values (?, ?, ?)";
    @Override
    public List<Hotspot> getHotspotList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Hotspot> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Hotspot hotspot = new Hotspot();
                hotspot.setName(resultSet.getString("name"));
                hotspot.setWord(resultSet.getString("word"));
                hotspot.setHeatRatio(resultSet.getFloat("heatRatio"));
                list.add(hotspot);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public Hotspot getHotsotInfo(String name, String word) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Hotspot hotspot = new Hotspot();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INFO);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,word);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                hotspot.setName(resultSet.getString("name"));
                hotspot.setWord(resultSet.getString("word"));
                hotspot.setHeatRatio(resultSet.getFloat("heatRatio"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return hotspot;
    }

    @Override
    public void deleteHotspot(String name, String word) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,word);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void updateHotspotInfo(String name, String word, float heatRatio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setFloat(1,heatRatio);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,word);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void insertHotspotInfo(String name, String word, float heatRatio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,word);
            preparedStatement.setFloat(3,heatRatio);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }
}
