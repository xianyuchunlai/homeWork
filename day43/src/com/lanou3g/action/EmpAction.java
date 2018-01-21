package com.lanou3g.action;

import com.lanou3g.bean.Employee;
import com.lanou3g.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String gogogo() {
        HibernateUtil.handle(session -> {
            Employee employee001 = session.get(Employee.class, this.employee.getEid());
            employee001.setEid(employee.getEid());
            employee001.setTime(employee.getTime());
            employee001.setDepartment(employee.getDepartment());
            employee001.setAge(employee.getAge());
            employee001.setHome(employee.getHome());
            employee001.setName(employee.getName());
            session.save(employee);
            return SUCCESS;

        });
        return SUCCESS;
    }
}


