package com.magic.restio;

import com.google.gson.Gson;
import com.magic.employrestio.entity.Employee;
import com.magic.employrestio.service.EmployService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EmployRestIOTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }

    public Employee[] getEmployeeList() {
        Response response = RestAssured.get("/employee");
        System.out.println(response.asString());
        return new Gson().fromJson(response.asString(), Employee[].class);
    }

    public Response addEmployeeToJsonServer(Employee employee) {
        String empJson = new Gson().toJson(employee);
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(empJson);
        return request.post("/employee");
    }

    @Test
    public void givenEmployeeDataInJsonServer_WhenRetrieved_ShouldMatchTheCount() {
        Employee[] employees = getEmployeeList();
        EmployService employService;
        employService = new EmployService(Arrays.asList(employees));
        long entries = employService.countEntries();
        Assertions.assertEquals(1, entries);
    }

}
