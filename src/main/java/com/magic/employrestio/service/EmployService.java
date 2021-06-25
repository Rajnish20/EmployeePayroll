package com.magic.employrestio.service;

import com.magic.employrestio.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployService {

    private List<Employee> employeeList;

    public EmployService(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>(employeeList);
    }

    public long countEntries() {
        return this.employeeList.size();
    }
}
