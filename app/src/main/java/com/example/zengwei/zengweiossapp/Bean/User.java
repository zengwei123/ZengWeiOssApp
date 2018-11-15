package com.example.zengwei.zengweiossapp.Bean;

/**
 * Created by zengwei on 2018/11/13.
 */

public class User {
    private String UserName;
    private String PassWord;

    public User(String userName, String passWord) {
        UserName = userName;
        PassWord = passWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
