package com.example.analysisandrecommendationsystem.entity;

import java.sql.Date;

public class User {

    private String username;
    private String password;
    private Date birthday;
    private String sex;
    private String userimgurl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserimgurl() {
        return userimgurl;
    }

    public void setUserimgurl(String userimgurl) {
        this.userimgurl = userimgurl;
    }

    @Override
    public String toString() {
        return "User{username="+getUsername()+", password="+getPassword()+", birthday="+getBirthday()+", sex="+getSex();
    }
}
