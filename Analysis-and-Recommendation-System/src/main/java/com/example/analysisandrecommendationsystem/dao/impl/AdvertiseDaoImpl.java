package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.AdvertiseDao;
import com.example.analysisandrecommendationsystem.entity.Advertisement;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdvertiseDaoImpl implements AdvertiseDao {
    private final static String LIST = "select * from advertisement";

    private final static String ADVERTISEMENT = "select * from advertisement where title = ?";

    private final static String UPDATE = "update advertisement set contenttext = ? where title = ? and name = ?";

    private final static String DELETE = "delete from advertisement where title = ? and name = ?";
    private final static String INSERT = "insert into advertisement(title, contenttext, `name`) values(?, ?, ?)";
    @Override
    public List<Advertisement> list() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Advertisement> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Advertisement advertisement = new Advertisement();
                advertisement.setTitle(resultSet.getString("title"));
                advertisement.setContenttext(resultSet.getString("contenttext"));
                advertisement.setName(resultSet.getString("name"));
                list.add(advertisement);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public Advertisement getAdInfo(String title) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Advertisement advertisement = new Advertisement();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(ADVERTISEMENT);
            preparedStatement.setString(1,title);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                advertisement.setTitle(resultSet.getString("title"));
                advertisement.setContenttext(resultSet.getString("contenttext"));
                advertisement.setName(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return advertisement;
    }

    @Override
    public void updateAdInfo(String title, String content, String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,content);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,name);
            boolean status = preparedStatement.execute();
            if(status){
                System.out.println("修改广告成功");
            }else {
                System.out.println("修改广告失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void deleteAdInfo(String title, String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,name);
            int linenum = preparedStatement.executeUpdate();
            if(linenum == 0){
                System.out.println("删除失败");
            }else {
                System.out.println("删除成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void insertAd(String name, String title, String contenttext) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,contenttext);
            preparedStatement.setString(3,name);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }
}
