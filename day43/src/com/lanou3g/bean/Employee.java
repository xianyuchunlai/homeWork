package com.lanou3g.bean;

public class Employee {
    private int eid;
    private String name;
    private int age;
    private String department;
    private int time;
    private String home;
    private int phone;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (eid != employee.eid) return false;
        if (age != employee.age) return false;
        if (time != employee.time) return false;
        if (phone != employee.phone) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        if (home != null ? !home.equals(employee.home) : employee.home != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + time;
        result = 31 * result + (home != null ? home.hashCode() : 0);
        result = 31 * result + phone;
        return result;
    }
}
