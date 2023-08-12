package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.AdvertiseDao;
import com.example.analysisandrecommendationsystem.dao.impl.AdvertiseDaoImpl;
import com.example.analysisandrecommendationsystem.entity.Advertisement;
import com.example.analysisandrecommendationsystem.service.AdvertiseService;

import java.util.List;

public class AdvertiseServiceImpl implements AdvertiseService {

    private AdvertiseDao advertiseDao = new AdvertiseDaoImpl();
    @Override
    public List<Advertisement> list() {
        return advertiseDao.list();
    }

    @Override
    public Advertisement getAdInfo(String title) {
        return advertiseDao.getAdInfo(title);
    }

    @Override
    public void updateAdInfo(String title, String content, String name) {
        advertiseDao.updateAdInfo(title,content,name);
    }

    @Override
    public void deleteAdInfo(String title, String name) {
        advertiseDao.deleteAdInfo(title, name);
    }

    @Override
    public void insertAd(String name, String title, String contenttext) {
        advertiseDao.insertAd(name,title,contenttext);
    }
}
