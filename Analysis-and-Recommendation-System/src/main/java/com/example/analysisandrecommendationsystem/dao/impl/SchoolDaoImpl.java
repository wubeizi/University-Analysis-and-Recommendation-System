package com.example.analysisandrecommendationsystem.dao.impl;

import com.example.analysisandrecommendationsystem.dao.SchoolDao;
import com.example.analysisandrecommendationsystem.entity.CollegeApplicationItem;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Hotspot;
import com.example.analysisandrecommendationsystem.entity.School;
import com.example.analysisandrecommendationsystem.utils.C3P0Util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class SchoolDaoImpl implements SchoolDao {

    private final static String SEARCHBYNAME = "select * from school where name like ?";

    private final static String SEARCHBYRANK = "select * from school where `rank` = ?";

    private final static String GETENROLLMENTINFO = "select * from enrollmentinfo where name = ? and province = ?";

    private final static String GETSCHOOLBYFORM = "select * from school natural join enrollmentinfo where (province = ? or ? is null) and (type = ? or ? is null ) and ((score2022 < ?+5 and score2022 > ?-5)or ? is null )";

    private final static String GETSCHOOLINFO = "select * from school where name = ?";

    private final static String GETMAJORLIST = "select * from schmaj where name = ?";
    private final static String SCHOOLLIST = "select * from school";
    private final static String DELETESCHOOL = "delete from school where name = ?";
    private final static String UPDATESCHOOL = "update school set `rank` = ?, `type` = ?, heat = ?, telephone = ?, introduction = ?, employmentRatio = ?, goAbroadRatio = ?, enrollmentRatio = ?, sexRatio = ?, location = ?, logo = ? where name = ?";
    private final static String INSERT = "insert into school(`rank`,`type`,heat, telephone, introduction, employmentRatio, goAbroadRatio, enrollmentRatio, sexRatio, location, logo, `name`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String HOTSPOTLIST = "select * from hotspot where `name` = ?";
    @Override
    public List<String> searchByName(String keyword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(SEARCHBYNAME);
            preparedStatement.setString(1, "%"+keyword+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String schoolname = resultSet.getString("name");
                list.add(schoolname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public List<String> search985() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();
        String rank = "985";
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(SEARCHBYRANK);
            preparedStatement.setString(1, rank);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String schoolname = resultSet.getString("name");
                list.add(schoolname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public List<String> search211() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();
        String rank = "211";
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(SEARCHBYRANK);
            preparedStatement.setString(1, rank);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String schoolname = resultSet.getString("name");
                list.add(schoolname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
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
            preparedStatement = connection.prepareStatement(GETENROLLMENTINFO);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,province);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                enrollmentInfo.setName(resultSet.getString("name"));
                enrollmentInfo.setProvince(resultSet.getString("province"));
                enrollmentInfo.setScore2020(resultSet.getInt("score2020"));
                enrollmentInfo.setScore2021(resultSet.getInt("score2021"));
                enrollmentInfo.setScore2022(resultSet.getInt("score2022"));
                enrollmentInfo.setEnrollmentNumber2020(resultSet.getInt("enrollmentNumber2020"));
                enrollmentInfo.setEnrollmentNumber2021(resultSet.getInt("enrollmentNumber2021"));
                enrollmentInfo.setEnrollmentNumber2022(resultSet.getInt("enrollmentNumber2022"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return enrollmentInfo;
    }

    @Override
    public List<CollegeApplicationItem> getSchoolByForm(String province, String type, int score) {
//        "select * from school natural join enrollmentinfo where (province = ? or ? is null ) and (type = ? or ? is null ) and ((score2022 < ?+5 and score2022 > ?-5)or ? is null )";
        System.out.println(province+" "+type+" "+score);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CollegeApplicationItem> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(GETSCHOOLBYFORM);
            if(province == null){
                preparedStatement.setNull(1, Types.VARCHAR);
                preparedStatement.setNull(2,Types.VARCHAR);
            }else {
                preparedStatement.setString(1,province);
                preparedStatement.setString(2, province);
            }
            if(type == null){
                preparedStatement.setNull(3,Types.VARCHAR);
                preparedStatement.setNull(4,Types.VARCHAR);
            }else {
                preparedStatement.setString(3, type);
                preparedStatement.setString(4, type);
            }
            preparedStatement.setInt(5,score);
            preparedStatement.setInt(6,score);
            preparedStatement.setInt(7,score);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CollegeApplicationItem item = new CollegeApplicationItem();
                item.setName(resultSet.getString("name"));
                item.setType(resultSet.getString("type"));
                item.setLogo(resultSet.getString("logo"));
//                学校所在的省份
                item.setLocation(resultSet.getString("location"));
                item.setEnrollmentNumber2020(resultSet.getInt("enrollmentNumber2020"));
                item.setEnrollmentNumber2021(resultSet.getInt("enrollmentNumber2021"));
                item.setEnrollmentNumber2022(resultSet.getInt("enrollmentNumber2022"));
                item.setScore2020(resultSet.getInt("score2020"));
                item.setScore2021(resultSet.getInt("score2021"));
                item.setScore2022(resultSet.getInt("score2022"));
                list.add(item);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public School getSchoolInfo(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        School school = new School();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(GETSCHOOLINFO);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                school.setName(resultSet.getString("name"));
                school.setRank(resultSet.getString("rank"));
                school.setType(resultSet.getString("type"));
                school.setHeat(resultSet.getString("heat"));
                school.setTelephone(resultSet.getString("telephone"));
                school.setIntroduction(resultSet.getString("introduction"));
                school.setEmploymentRatio(resultSet.getFloat("employmentRatio"));
                school.setGoAbroadRatio(resultSet.getFloat("goAbroadRatio"));
                school.setEnrollmentRatio(resultSet.getFloat("enrollmentRatio"));
                school.setSexRatio(resultSet.getFloat("sexRatio"));
                school.setLocation(resultSet.getString("location"));
                school.setLogo(resultSet.getString("logo"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return school;
    }

    @Override
    public List<String> getSchoolMajorList(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(GETMAJORLIST);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String major = resultSet.getString("major");
                list.add(major);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public List<School> getSchoolList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<School> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(SCHOOLLIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                School school = new School();
                school.setName(resultSet.getString("name"));
                school.setRank(resultSet.getString("rank"));
                school.setType(resultSet.getString("heat"));
                school.setTelephone(resultSet.getString("telephone"));
                school.setIntroduction(resultSet.getString("introduction"));
                school.setEmploymentRatio(resultSet.getFloat("employmentRatio"));
                school.setGoAbroadRatio(resultSet.getFloat("goAbroadRatio"));
                school.setEnrollmentRatio(resultSet.getFloat("enrollmentRatio"));
                school.setSexRatio(resultSet.getFloat("sexRatio"));
                school.setLocation(resultSet.getString("location"));
                school.setLogo(resultSet.getString("logo"));
                list.add(school);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public void deleteSchool(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(DELETESCHOOL);
            preparedStatement.setString(1,name);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void updateSchoolInfo(String name, String rank, String type, String heat, String telephone, String introduction, float em, float go, float en, float se, String location, String logo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,rank);
            preparedStatement.setString(2,type);
            preparedStatement.setString(3,heat);
            preparedStatement.setString(4,telephone);
            preparedStatement.setString(5,introduction);
            preparedStatement.setFloat(6,em);
            preparedStatement.setFloat(7,go);
            preparedStatement.setFloat(8,en);
            preparedStatement.setFloat(9,se);
            preparedStatement.setString(10,location);
            preparedStatement.setString(11,logo);
            preparedStatement.setString(12,name);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public void insertSchool(String name, String rank, String type, String heat, String telephone, String introduction, float em, float go, float en, float se, String location, String logo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,rank);
            preparedStatement.setString(2,type);
            preparedStatement.setString(3,heat);
            preparedStatement.setString(4,telephone);
            preparedStatement.setString(5,introduction);
            preparedStatement.setFloat(6,em);
            preparedStatement.setFloat(7,go);
            preparedStatement.setFloat(8,en);
            preparedStatement.setFloat(9,se);
            preparedStatement.setString(10,location);
            preparedStatement.setString(11,logo);
            preparedStatement.setString(12,name);
            System.out.println(name);
            int line = preparedStatement.executeUpdate();
            System.out.println(line);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,preparedStatement,connection);
        }
    }

    @Override
    public List<Hotspot> getHotSpotList(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Hotspot> list = new ArrayList<>();
        try {
            connection = C3P0Util.getConnection();
            preparedStatement = connection.prepareStatement(HOTSPOTLIST);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Hotspot hotspot = new Hotspot();
                hotspot.setWord(resultSet.getString("word"));
                hotspot.setHeatRatio(resultSet.getFloat("heatRatio"));
                hotspot.setName(resultSet.getString("name"));
                list.add(hotspot);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,preparedStatement,connection);
        }
        return list;
    }
}
