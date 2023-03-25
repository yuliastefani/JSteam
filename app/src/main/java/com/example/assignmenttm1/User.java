package com.example.assignmenttm1;

public class User {

    private String userName;
    private String userEmail;
    private String userPass;
    private String userRegion;
    private Integer userPhone;

    public User(String userName, String userEmail, String userPass, String userRegion, Integer userPhone) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userRegion = userRegion;
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }
}
