package com.magic.employrestio.entity;

public class Employee {
    public int id;
    public String name;
    public double salary;
    String gender;

    public Employee(int id, String name, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }
}
