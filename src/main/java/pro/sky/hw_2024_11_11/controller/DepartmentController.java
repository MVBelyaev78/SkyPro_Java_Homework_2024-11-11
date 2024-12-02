package pro.sky.hw_2024_11_11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw_2024_11_11.service.Department;
import pro.sky.hw_2024_11_11.service.Employee;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final Department department;

    public DepartmentController(Department department) {
        this.department = department;
    }
    @GetMapping
    public Iterable<Employee> getEmployees() {
        return department.getEmployeeList();
    }
}
