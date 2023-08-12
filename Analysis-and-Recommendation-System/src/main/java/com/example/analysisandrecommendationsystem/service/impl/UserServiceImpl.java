package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.UserDao;
import com.example.analysisandrecommendationsystem.dao.impl.UserDaoImpl;
import com.example.analysisandrecommendationsystem.entity.User;
import com.example.analysisandrecommendationsystem.service.UserService;

import java.sql.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String name, String password) {
        return userDao.login(name, password);
    }

    @Override
    public boolean hasSameUsername(String username) {
        return userDao.hasSameUsername(username);
    }

    @Override
    public void register(String username, String password) {
        userDao.register(username, password);
    }

    @Override
    public void modifyUserInfo(String imgurl, Date birthday, String gender, String password, String username) {
        userDao.modifyUserInfo(imgurl,birthday,gender,password,username);
    }

    @Override
    public String getPassword(String name, Date birthday, String sex) {
        return userDao.getPassword(name,birthday,sex);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserInfo(String username) {
        return userDao.getUserInfo(username);
    }

    @Override
    public void deleteUser(String username) {
        userDao.deleteUser(username);
    }
}
