package com.ch.entity;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String signintime;

    private String signout;

    private String addpower;

    private String isinput;

    private String isoutput;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getSignintime() {
        return signintime;
    }

    public void setSignintime(String signintime) {
        this.signintime = signintime;
    }

    public String getSignout() {
        return signout;
    }

    public void setSignout(String signout) {
        this.signout = signout;
    }

    public String getAddpower() {
        return addpower;
    }

    public void setAddpower(String addpower) {
        this.addpower = addpower;
    }

    public String getIsinput() {
        return isinput;
    }

    public void setIsinput(String isinput) {
        this.isinput = isinput;
    }

    public String getIsoutput() {
        return isoutput;
    }

    public void setIsoutput(String isoutput) {
        this.isoutput = isoutput;
    }
}