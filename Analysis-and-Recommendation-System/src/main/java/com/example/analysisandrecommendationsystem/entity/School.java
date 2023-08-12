package com.example.analysisandrecommendationsystem.entity;

public class School {
    private String name;
    private String rank;
    private String type;
    private String heat;
    private String telephone;
    private String introduction;
    private float employmentRatio;
    private float goAbroadRatio;
    private float enrollmentRatio;
    private float sexRatio;
    private String location;
    private String logo;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


    public float getEmploymentRatio() {
        return employmentRatio;
    }

    public void setEmploymentRatio(float employmentRatio) {
        this.employmentRatio = employmentRatio;
    }

    public float getGoAbroadRatio() {
        return goAbroadRatio;
    }

    public void setGoAbroadRatio(float goAbroadRatio) {
        this.goAbroadRatio = goAbroadRatio;
    }

    public float getEnrollmentRatio() {
        return enrollmentRatio;
    }

    public void setEnrollmentRatio(float enrollmentRatio) {
        this.enrollmentRatio = enrollmentRatio;
    }

    public float getSexRatio() {
        return sexRatio;
    }

    public void setSexRatio(float sexRatio) {
        this.sexRatio = sexRatio;
    }
}
