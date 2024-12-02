package pro.sky.hw_2024_11_11.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.hw_2024_11_11.service.Department;
import pro.sky.hw_2024_11_11.service.Employee;
import pro.sky.hw_2024_11_11.service.TestDepartment;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final Department department = new Department(TestDepartment.createData());

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return department.getEmployeeList();
    }

    @GetMapping("/all")
    public Iterable<Employee> getEmployeeList(
            @RequestParam(value = "departmentId", required = false) Optional<Integer> departmentId) {
        return departmentId
                .map(department::getEmployeeList)
                .orElseGet(department::getEmployeeList);
    }

    @GetMapping("/min-salary")
    public List<Employee> getLowestPaidEmployee(
            @RequestParam(value = "departmentId", required = false) Optional<Integer> departmentId) {
        return departmentId
                .map(department::getLowestPaidEmployee)
                .orElseGet(department::getLowestPaidEmployee);
    }

    @GetMapping("/max-salary")
    public List<Employee> getHighestPaidEmployee(
            @RequestParam(value = "departmentId", required = false) Optional<Integer> departmentId) {
        return departmentId
                .map(department::getHighestPaidEmployee)
                .orElseGet(department::getHighestPaidEmployee);
    }
}
