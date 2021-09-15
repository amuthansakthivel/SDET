package com.utils.fixtures;

import java.util.List;

public class Employee {

    private int id;
    private boolean isFTE;
    private String fname;
    private Address address;
    private List<String> roles;

    public Employee(int id, boolean isFTE, String fname, Address address, List<String> roles) {
        this.id = id;
        this.isFTE = isFTE;
        this.fname = fname;
        this.address = address;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public boolean isFTE() {
        return isFTE;
    }

    public String getFname() {
        return fname;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", isFTE=" + isFTE +
                ", fname='" + fname + '\'' +
                ", address=" + address +
                ", roles=" + roles +
                '}';
    }
}
