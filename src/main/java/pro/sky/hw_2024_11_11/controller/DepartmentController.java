package pro.sky.hw_2024_11_11.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.hw_2024_11_11.service.Department;
import pro.sky.hw_2024_11_11.service.Employee;
import pro.sky.hw_2024_11_11.service.TestDepartment;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final Department department = new Department(TestDepartment.createData());

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return department.getEmployeeList();
    }

    @GetMapping("/all")
    public Iterable<Employee> getEmployeeListB() {
        return department.getEmployeeList();
    }
}
