package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.User;

import java.sql.Date;
import java.util.List;

public interface UserDao {

    void modifyUserInfo(String imgurl, Date birthday, String gender, String password, String username);

    User login(String name, String password);

    boolean hasSameUsername(String username);

    void register(String username, String password);

    String getPassword(String name, Date birthday, String sex);

    List<User> getUserList();

    User getUserInfo(String username);

    void deleteUser(String username);
}
