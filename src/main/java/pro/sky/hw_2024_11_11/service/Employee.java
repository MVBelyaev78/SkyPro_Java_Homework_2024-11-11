package pro.sky.hw_2024_11_11.service;

import java.util.Objects;

public class Employee {
    private static int sequenceId = 1;
    public static final int MIN_CODE_DEPARTMENT = 1;
    public static final int MAX_CODE_DEPARTMENT = 5;

    public static Employee valueOf(String fullName, int codeDepartment, int salary) throws IllegalArgumentException {
        Employee employee = new Employee(fullName);
        employee.setCodeDepartment(codeDepartment);
        employee.setSalary(salary);
        return employee;
    }

    public static int getCurrentSequenceIdValue() {
        return sequenceId;
    }

    private final int id;
    private final String fullName;
    private int codeDepartment;
    private int salary;

    private Employee(String fullName) {
        this.id = sequenceId++;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCodeDepartment() {
        return codeDepartment;
    }

    public int getSalary() {
        return salary;
    }

    public void setCodeDepartment(int codeDepartment) {
        if (codeDepartment < MIN_CODE_DEPARTMENT || codeDepartment > MAX_CODE_DEPARTMENT) {
            throw new IllegalArgumentException(String.format("Department code must be between %s and %s",
                    MIN_CODE_DEPARTMENT,
                    MAX_CODE_DEPARTMENT));
        }
        this.codeDepartment = codeDepartment;
    }

    public void setSalary(int salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary can't be non-positive");
        }
        this.salary = salary;
    }


    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Employee that = (Employee) object;
        return id == that.getId() &&
                fullName.equals(that.getFullName()) &&
                codeDepartment == that.getCodeDepartment() &&
                salary == that.getSalary();
    }

    public int hashCode() {
        return Objects.hash(id, fullName, codeDepartment, salary);
    }

    public void indexSalary(double ratePercent) {
        if (ratePercent < 0d) {
            throw new IllegalArgumentException("Percent rate can't be negative");
        }
        if (ratePercent > 0d) {
            salary = (int) Math.ceil(salary * (1d + ratePercent / 100d));
        }
    }

    public String getEmployeeDataExceptDepartment() {
        return getEmployeeData(false);
    }

    public String getFullEmployeeData() {
        return getEmployeeData(true);
    }

    private String getEmployeeData(boolean printCodeDepartment) {
        String result;
        if (printCodeDepartment) {
            result = String.format("(%s) \"%s\": department code is %s, salary is %s",
                    id,
                    fullName,
                    codeDepartment,
                    salary);
        } else {
            result = String.format("(%s) \"%s\": salary is %s", id, fullName, salary);
        }
        return result;
    }
}
