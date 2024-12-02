package pro.sky.hw_2024_11_11.service;

import java.util.LinkedList;
import java.util.List;

public class TestDepartment {
    public static List<Employee> createData() {
        return new LinkedList<>(List.of(
                Employee.valueOf("Ellen White", 1, 2931),
                Employee.valueOf("John Black", 1, 3720),
                Employee.valueOf("John Silver", 1, 3720),
                Employee.valueOf("Thomas Johnson", 1, 2500),
                Employee.valueOf("Sarah Fill", 1, 2000),
                Employee.valueOf("Gordon Lloyd", 1, 2000),
                Employee.valueOf("Susan Brown", 2, 6800),
                Employee.valueOf("Larry Hagman", 2, 1250),
                Employee.valueOf("Stanley Miller", 4, 3400),
                Employee.valueOf("Philipp Roberts", 4, 6800),
                Employee.valueOf("Neil Green", 4, 5000),
                Employee.valueOf("Anna Williams", 4, 4000),
                Employee.valueOf("Lucinda Watson", 5, 5000),
                Employee.valueOf("Mick Jones", 5, 2300),
                Employee.valueOf("Steve Romney", 5, 1250)
        ));
    }
}
