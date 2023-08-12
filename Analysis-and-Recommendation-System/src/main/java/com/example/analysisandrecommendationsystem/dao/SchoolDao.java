package com.example.analysisandrecommendationsystem.dao;

import com.example.analysisandrecommendationsystem.entity.CollegeApplicationItem;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Hotspot;
import com.example.analysisandrecommendationsystem.entity.School;

import java.util.List;

public interface SchoolDao {
    List<String> searchByName(String keyword);

    List<String> search985();

    List<String> search211();

    EnrollmentInfo getEnrollInfo(String name, String province);

    List<CollegeApplicationItem> getSchoolByForm(String province, String type, int score);

    School getSchoolInfo(String name);

    List<String> getSchoolMajorList(String name);

    List<School> getSchoolList();

    void deleteSchool(String name);

    void updateSchoolInfo(String name, String rank, String type, String heat, String telephone, String introduction, float em, float go, float en, float se, String location, String logo);

    void insertSchool(String name, String rank, String type, String heat, String telephone, String introduction, float em, float go, float en, float se, String location, String logo);

    List<Hotspot> getHotSpotList(String name);
}
