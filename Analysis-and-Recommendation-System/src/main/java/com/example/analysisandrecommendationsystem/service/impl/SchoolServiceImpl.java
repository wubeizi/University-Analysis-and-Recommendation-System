package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.SchoolDao;
import com.example.analysisandrecommendationsystem.dao.impl.SchoolDaoImpl;
import com.example.analysisandrecommendationsystem.entity.CollegeApplicationItem;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.entity.Hotspot;
import com.example.analysisandrecommendationsystem.entity.School;
import com.example.analysisandrecommendationsystem.service.SchoolService;

import java.util.List;

public class SchoolServiceImpl implements SchoolService {

    private SchoolDao schoolDao = new SchoolDaoImpl();
    @Override
    public List<String> searchByName(String keyword) {
        return schoolDao.searchByName(keyword);
    }

    @Override
    public List<String> search985() {
        return schoolDao.search985();
    }

    @Override
    public List<String> search211() {
        return schoolDao.search211();
    }

    @Override
    public EnrollmentInfo getEnrollInfo(String name, String province) {
        return schoolDao.getEnrollInfo(name, province);
    }

    @Override
    public List<CollegeApplicationItem> getSchoolByForm(String province, String type, int score) {
        return schoolDao.getSchoolByForm(province, type, score);
    }

    @Override
    public School getSchoolInfo(String name) {
        return schoolDao.getSchoolInfo(name);
    }

    @Override
    public List<String> getSchoolMajorlist(String name) {
        return schoolDao.getSchoolMajorList(name);
    }

    @Override
    public List<School> getSchoolList() {
        return schoolDao.getSchoolList();
    }

    @Override
    public void deleteSchool(String name) {
        schoolDao.deleteSchool(name);
    }

    @Override
    public void updateSchoolInfo(String name, String rank, String type, String heat, String telephone, String introduction, float em, float go, float en, float se,String location,String logo) {
        schoolDao.updateSchoolInfo(name,rank,type,heat,telephone,introduction,em,go,en,se,location,logo);
    }

    @Override
    public void insertSchool(String name, String rank, String type, String heat, String telephone, String introduction, float em, float go, float en, float se, String location, String logo) {
        schoolDao.insertSchool(name,rank,type,heat,telephone,introduction,em,go,en,se,location,logo);
    }

    @Override
    public List<Hotspot> getHotSpotList(String name) {
        return schoolDao.getHotSpotList(name);
    }
}
