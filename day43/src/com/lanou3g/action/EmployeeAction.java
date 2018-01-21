package com.lanou3g.action;

import com.lanou3g.bean.Employee;
import com.lanou3g.dao.EmployeeDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class EmployeeAction extends ActionSupport {

    private Employee employee;
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String information() {
        List<Employee> employees = new EmployeeDao().queryAll();
        ServletActionContext.getRequest().setAttribute("list", employees);
        return SUCCESS;
    }



}
