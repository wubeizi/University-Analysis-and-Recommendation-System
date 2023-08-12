package com.example.analysisandrecommendationsystem.service;

import com.example.analysisandrecommendationsystem.entity.MajorInfo;

import java.util.List;

public interface MajorService {
    List<MajorInfo> getMajorList();

    MajorInfo getMajorInfo(String major);

    void insertMajorInfo(String major);

    void deleteMajor(String major);
}
