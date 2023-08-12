package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.Schmaj;

import java.util.List;

public interface MajorschDao {
    List<Schmaj> getMajorschList();

    Schmaj getMajorschInfo(String name, String major);

    void deleteMajorsch(String name, String major);

    void insertMajorsch(String name, String major);
}
