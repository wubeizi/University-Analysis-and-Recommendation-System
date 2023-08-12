package com.example.analysisandrecommendationsystem.service;

import com.example.analysisandrecommendationsystem.entity.Schmaj;

import java.util.List;

public interface MajorschService {
    List<Schmaj> getMajorschList();

    Schmaj getMajorschInfo(String name, String major);

    void deleteMajorsch(String name, String major);

    void insertMajorsch(String name, String major);
}
