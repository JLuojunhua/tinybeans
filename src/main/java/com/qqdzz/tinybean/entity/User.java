package com.qqdzz.tinybean.entity;

public class User {

    private Integer id;
    private String userName;
    private Integer isRoot;
    private String icon;
    private String userPassword;
    private String userSex;
    private String userPhoneNum;
    private String userLikeCategories;

    public User() {
    }

    public User(Integer id, String userName, Integer isRoot, String icon, String userPassword, String userSex, String userPhoneNum, String userLikeCategories) {
        this.id = id;
        this.userName = userName;
        this.isRoot = isRoot;
        this.icon = icon;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userPhoneNum = userPhoneNum;
        this.userLikeCategories = userLikeCategories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Integer isRoot) {
        this.isRoot = isRoot;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserLikeCategories() {
        return userLikeCategories;
    }

    public void setUserLikeCategories(String userLikeCategories) {
        this.userLikeCategories = userLikeCategories;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", isRoot=" + isRoot +
                ", icon='" + icon + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhoneNum='" + userPhoneNum + '\'' +
                ", userLikeCategories='" + userLikeCategories + '\'' +
                '}';
    }
}
