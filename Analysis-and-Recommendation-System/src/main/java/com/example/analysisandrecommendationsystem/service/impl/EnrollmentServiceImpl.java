package com.example.analysisandrecommendationsystem.service.impl;

import com.example.analysisandrecommendationsystem.dao.EnrollmentDao;
import com.example.analysisandrecommendationsystem.dao.impl.EnrollmentDaoImpl;
import com.example.analysisandrecommendationsystem.entity.EnrollmentInfo;
import com.example.analysisandrecommendationsystem.service.EnrollmentService;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {
    private EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();
    @Override
    public List<EnrollmentInfo> getEnrollList() {
        return enrollmentDao.getEnrollList();
    }

    @Override
    public EnrollmentInfo getEnrollInfo(String name, String province) {
        return enrollmentDao.getEnrollInfo(name,province);
    }

    @Override
    public void updateEnrollInfo(String name, String province, int s20, int s21, int s22, int e20, int e21, int e22) {
        enrollmentDao.updateEnrollInfo(name,province,s20,s21,s22,e20,e21,e22);
    }

    @Override
    public void deleteEnroll(String name, String province) {
        enrollmentDao.deleteEnroll(name,province);
    }

    @Override
    public void insertEnrollInfo(String name, String province, int s20, int s21, int s22, int e20, int e21, int e22) {
        enrollmentDao.insertEnrollInfo(name,province,s20,s21,s22,e20,e21,e22);
    }

    @Override
    public List<EnrollmentInfo> getEnrollListByName(String name) {
        return enrollmentDao.getEnrollListByName(name);
    }
}
