package com.lanou3g.dao;

import com.lanou3g.bean.Employee;
import com.lanou3g.util.HibernateUtil;
import org.hibernate.Criteria;

import java.util.List;

import static com.lanou3g.util.HibernateUtil.handle;

public class EmployeeDao {

    public List<Employee> queryAll() {
        List<Employee> h =
                HibernateUtil.handle(session -> {
                    Criteria criteria = session.createCriteria(Employee.class);
                    List<Employee> list = criteria.list();
                    return list;
                });
        return h;
    }
}
