package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.MajorInfo;

import java.util.List;

public interface MajorDao {
    List<MajorInfo> getMajorList();

    MajorInfo getMajorInfo(String major);

    void insertMajorInfo(String major);

    void deleteMajor(String major);
}
