package com.lanou3g.bookstore.user.service.exception;

public class UserException extends Exception {

    @Override
    public String getMessage() {
        return  "账号已被注册";
    }
}
