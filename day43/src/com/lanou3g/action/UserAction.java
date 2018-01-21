package com.lanou3g.action;

import com.lanou3g.bean.Employee;
import com.lanou3g.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport {
    private Employee employee;

    public String alter() {
        String eid = ServletActionContext.getRequest().getParameter("eid");
        int e = Integer.parseInt(eid);

        ServletActionContext.getRequest().setAttribute("eid", eid);
        Employee h = HibernateUtil.handle(session -> {
            Employee employee = session.get(Employee.class, e);
            return employee;
        });
        ActionContext.getContext().put("h", h);

        return SUCCESS;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
