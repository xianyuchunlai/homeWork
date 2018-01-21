package com.lanou3g.iterceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import javax.servlet.http.HttpSession;

public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        HttpSession session = (HttpSession) ActionContext.getContext().getSession();
        Object o = session.getAttribute("username");
        if (o == null) {
            return "login";
        }
        return actionInvocation.invoke();
    }

}
