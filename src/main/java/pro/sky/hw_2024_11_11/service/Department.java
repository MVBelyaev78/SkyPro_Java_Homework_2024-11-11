package pro.sky.hw_2024_11_11.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Department {
    private final List<Employee> arrEmployee;

    public Department(List<Employee> arrEmployee) {
        this.arrEmployee = arrEmployee;
    }

    public List<Employee> getArrEmployee() {
        return arrEmployee;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return arrEmployee
                .equals(((Department) object)
                        .getArrEmployee());
    }

    public int hashCode() {
        return Objects.hash(arrEmployee);
    }

    public List<Employee> getEmployeeList() {
        return arrEmployee
                .stream()
                .sorted(Comparator.comparing(Employee::getCodeDepartment).thenComparing(Employee::getFullName))
                .toList();
    }

    public List<Employee> getEmployeeList(int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment)
                .sorted(Comparator.comparing(Employee::getFullName))
                .toList();
    }

    public List<Employee> getLowestPaidEmployee() {
        List<Employee> result = new LinkedList<>();
        final OptionalInt resultOptional = arrEmployee
                .stream()
                .mapToInt(Employee::getSalary)
                .min();
        if (resultOptional.isPresent()) {
            result = arrEmployee
                    .stream()
                    .filter(e -> e.getSalary() == resultOptional.getAsInt())
                    .sorted(Comparator.comparing(Employee::getCodeDepartment).thenComparing(Employee::getFullName))
                    .toList();
        }
        return result;
    }

    public List<Employee> getLowestPaidEmployee(int codeDepartment) {
        List<Employee> result = new LinkedList<>();
        final OptionalInt resultOptional = arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment)
                .mapToInt(Employee::getSalary)
                .min();
        if (resultOptional.isPresent()) {
            result = arrEmployee
                    .stream()
                    .filter(e -> e.getCodeDepartment() == codeDepartment
                            && e.getSalary() == resultOptional.getAsInt())
                    .sorted(Comparator.comparing(Employee::getFullName))
                    .toList();
        }
        return result;
    }

    public List<Employee> getHighestPaidEmployee() {
        List<Employee> result = new LinkedList<>();
        final OptionalInt resultOptional = arrEmployee
                .stream()
                .mapToInt(Employee::getSalary)
                .max();
        if (resultOptional.isPresent()) {
            result = arrEmployee
                    .stream()
                    .filter(e -> e.getSalary() == resultOptional.getAsInt())
                    .sorted(Comparator.comparing(Employee::getCodeDepartment).thenComparing(Employee::getFullName))
                    .toList();
        }
        return result;
    }

    public List<Employee> getHighestPaidEmployee(int codeDepartment) {
        List<Employee> result = new LinkedList<>();
        final OptionalInt resultOptional = arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment)
                .mapToInt(Employee::getSalary)
                .max();
        if (resultOptional.isPresent()) {
            result = arrEmployee
                    .stream()
                    .filter(e -> e.getCodeDepartment() == codeDepartment
                            && e.getSalary() == resultOptional.getAsInt())
                    .sorted(Comparator.comparing(Employee::getFullName))
                    .toList();
        }
        return result;
    }
}
