package com.lanou3g.action;

import com.lanou3g.bean.User;
import com.lanou3g.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class LoginAction extends ActionSupport {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login() {
        User user01 = new UserDao().get();
        String password = user01.getPassword();

        String name = user01.getUsername();
        if (name.equals(user.getUsername()) && password.equals(user.getPassword())) {
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("username", user01.getUsername());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
