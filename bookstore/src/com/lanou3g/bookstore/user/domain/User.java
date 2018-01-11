package com.lanou3g.bookstore.user.domain;

public class User {

    private String username;
    private String password;
    private String uid;
    private String email;
    private String code;
    private String state="0";

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", state='" + state + '\'' +
                '}';
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User() {

    }

    public User(String username, String password, String uid, String email, String code, String state) {

        this.username = username;
        this.password = password;
        this.uid = uid;
        this.email = email;
        this.code = code;
        this.state = state;
    }
}
