package com.lanou3g.dao;

import com.lanou3g.bean.User;
import com.lanou3g.util.HibernateUtil;

public class UserDao {
    public User get() {
        User h = HibernateUtil.handle(session -> {
            User user = session.get(User.class, 1);
            return user;
        });
        return h;
    }
}







