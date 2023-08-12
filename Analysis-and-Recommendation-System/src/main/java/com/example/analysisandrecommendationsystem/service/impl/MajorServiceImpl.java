package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.MajorDao;
import com.example.analysisandrecommendationsystem.dao.impl.MajorDaoImpl;
import com.example.analysisandrecommendationsystem.entity.MajorInfo;
import com.example.analysisandrecommendationsystem.service.MajorService;

import java.util.List;

public class MajorServiceImpl implements MajorService {
    private MajorDao majorDao = new MajorDaoImpl();
    @Override
    public List<MajorInfo> getMajorList() {
        return majorDao.getMajorList();
    }

    @Override
    public MajorInfo getMajorInfo(String major) {
        return majorDao.getMajorInfo(major);
    }

    @Override
    public void insertMajorInfo(String major) {
        majorDao.insertMajorInfo(major);
    }

    @Override
    public void deleteMajor(String major) {
        majorDao.deleteMajor(major);
    }
}
