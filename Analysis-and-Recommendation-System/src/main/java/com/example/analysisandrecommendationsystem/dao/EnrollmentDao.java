package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;

import java.util.List;

public interface EnrollmentDao {
    List<EnrollmentInfo> getEnrollList();

    EnrollmentInfo getEnrollInfo(String name, String province);

    void updateEnrollInfo(String name, String province, int s20, int s21, int s22, int e20, int e21, int e22);

    void deleteEnroll(String name, String province);

    void insertEnrollInfo(String name, String province, int s20, int s21, int s22, int e20, int e21, int e22);

    List<EnrollmentInfo> getEnrollListByName(String name);
}
