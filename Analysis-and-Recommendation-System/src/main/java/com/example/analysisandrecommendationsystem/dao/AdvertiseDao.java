package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.Advertisement;

import java.util.List;

public interface AdvertiseDao {
    List<Advertisement> list();

    Advertisement getAdInfo(String title);

    void updateAdInfo(String title, String content, String name);

    void deleteAdInfo(String title, String name);

    void insertAd(String name, String title, String contenttext);
}
