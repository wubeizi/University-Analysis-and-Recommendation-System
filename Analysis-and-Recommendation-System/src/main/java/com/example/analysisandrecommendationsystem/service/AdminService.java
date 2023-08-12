package com.example.analysisandrecommendationsystem.service;

import com.example.analysisandrecommendationsystem.entity.Administrator;

public interface AdminService {

    Administrator login(String name, String password);
}
