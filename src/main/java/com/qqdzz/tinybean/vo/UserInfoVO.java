package com.qqdzz.tinybean.vo;

public class UserInfoVO {
    private String name;
    private String sex;
    private String phone;
    private String tag;

    public UserInfoVO() {
    }

    public UserInfoVO(String name, String sex, String phone, String tag) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
