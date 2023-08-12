package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.MajorschDao;
import com.example.analysisandrecommendationsystem.dao.impl.MajorschDaoImpl;
import com.example.analysisandrecommendationsystem.entity.Schmaj;
import com.example.analysisandrecommendationsystem.service.MajorschService;

import java.util.List;

public class MajorschServiceImpl implements MajorschService {
    private MajorschDao majorschDao = new MajorschDaoImpl();
    @Override
    public List<Schmaj> getMajorschList() {
        return majorschDao.getMajorschList();
    }

    @Override
    public Schmaj getMajorschInfo(String name, String major) {
        return majorschDao.getMajorschInfo(name,major);
    }

    @Override
    public void deleteMajorsch(String name, String major) {
        majorschDao.deleteMajorsch(name,major);
    }

    @Override
    public void insertMajorsch(String name, String major) {
        majorschDao.insertMajorsch(name,major);
    }
}
