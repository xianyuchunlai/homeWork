package com.lanou3g.bookstore.user.service.exception;

public class LoginPassWordNotMath extends Exception{
    @Override
    public String getMessage() {
        return "密码不匹配";
    }
}
