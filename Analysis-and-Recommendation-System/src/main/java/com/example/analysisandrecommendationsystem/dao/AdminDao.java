package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.Administrator;

public interface AdminDao {

    Administrator login(String name, String password);
}
