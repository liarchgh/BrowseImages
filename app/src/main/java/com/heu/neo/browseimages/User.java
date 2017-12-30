package com.heu.neo.browseimages;

/**
 * Created by neo on 2017/12/29.
 */

public class User {
    public String getNickname() {
        return nickname;
    }

    public int getGender() {
        return gender;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getSignature() {
        return signature;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    private String nickname;
    private int gender;
    private String accountnumber;
    private String province;
    private String city;
    private String signature;
}
