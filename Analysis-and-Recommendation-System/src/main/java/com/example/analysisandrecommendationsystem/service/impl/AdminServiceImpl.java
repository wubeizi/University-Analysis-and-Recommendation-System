package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.AdminDao;
import com.example.analysisandrecommendationsystem.dao.impl.AdminDaoImpl;
import com.example.analysisandrecommendationsystem.entity.Administrator;
import com.example.analysisandrecommendationsystem.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Administrator login(String name, String password) {
        return adminDao.login(name, password);
    }
}
