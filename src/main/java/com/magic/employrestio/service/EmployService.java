package com.magic.employrestio.service;

import com.magic.employrestio.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployService {

    private List<Employee> employeeList;

    public EmployService(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>(employeeList);
    }

    public void addEmployeeToList(Employee employee) {
        this.employeeList.add(employee);
    }

    public void updateEmployeeSalary(String name, double salary) {
        Employee employee = this.getEmployee(name);
        if (employee != null)
            employee.salary = salary;
    }

    public void deleteEmployee(String name) {
        this.employeeList.remove(this.getEmployee(name));
    }

    public Employee getEmployee(String name) {
        return this.employeeList.stream()
                .filter(employee -> employee.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    public long countEntries() {
        return this.employeeList.size();
    }
}
