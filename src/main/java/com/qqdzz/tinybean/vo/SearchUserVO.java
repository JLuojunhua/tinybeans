package com.qqdzz.tinybean.vo;

public class SearchUserVO {
    private Integer UserId;
    private String userPhoto;
    private String userName;

    public SearchUserVO() {
    }

    public SearchUserVO(Integer userId, String userPhoto, String userName) {
        UserId = userId;
        this.userPhoto = userPhoto;
        this.userName = userName;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
