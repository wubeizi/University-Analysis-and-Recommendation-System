package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.Geography;

import java.util.List;

public interface GeographyDao {
    List<Geography> geoList();

    Geography getGeoInfo(String name, String address);

    void updateInfo(String name, String address);

    void deleteInfo(String name, String address);

    void insertInfo(String name, String address);
}
