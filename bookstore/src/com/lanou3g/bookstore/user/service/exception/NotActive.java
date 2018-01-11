package com.lanou3g.bookstore.user.service.exception;

public class NotActive extends Exception{
    @Override
    public String getMessage() {
        return "未被激活";
    }
}
