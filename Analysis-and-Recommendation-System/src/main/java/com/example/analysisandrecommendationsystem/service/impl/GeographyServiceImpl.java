package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.GeographyDao;
import com.example.analysisandrecommendationsystem.dao.impl.GeographyDaoImpl;
import com.example.analysisandrecommendationsystem.entity.Geography;
import com.example.analysisandrecommendationsystem.service.GeographyService;

import java.util.List;

public class GeographyServiceImpl implements GeographyService {

    private GeographyDao geographyDao = new GeographyDaoImpl();
    @Override
    public List<Geography> geoList() {
        return geographyDao.geoList();
    }

    @Override
    public Geography getGeoInfo(String name, String address) {
        return geographyDao.getGeoInfo(name, address);
    }

    @Override
    public void updateInfo(String name, String address) {
        geographyDao.updateInfo(name,address);
    }

    @Override
    public void deleteInfo(String name, String address) {
        geographyDao.deleteInfo(name,address);
    }

    @Override
    public void insertInfo(String name, String address) {
        geographyDao.insertInfo(name,address);
    }
}
