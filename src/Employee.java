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
    private Employee(String fullName) {
        this.id = sequenceId++;
        this.fullName = fullName;
    }
    private final int id;
    private final String fullName;
    private int codeDepartment;
    private int salary;
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

    public static int getCurrentSequenceIdValue() {
        return sequenceId;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Employee that = (Employee) object;
        return getId() == that.getId() &&
                getFullName().equals(that.getFullName()) &&
                getCodeDepartment() == that.getCodeDepartment() &&
                getSalary() == that.getSalary();
    }

    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getCodeDepartment(), getSalary());
    }

    public void printEmployeeData() {
        printEmployeeData(0, true);
    }

    public void printEmployeeData(int codeDepartment, boolean printCodeDepartment) {
        if (checkCodeDepartment(codeDepartment)) {
            System.out.println(getEmployeeData(printCodeDepartment));
        }
    }

    public boolean checkCodeDepartment(int codeDepartment) {
        return (codeDepartment == 0 || getCodeDepartment() == codeDepartment);
    }

    private String getEmployeeData(boolean printCodeDepartment) {
        String result;
        if (printCodeDepartment) {
            result = String.format("(%s) \"%s\": department code is %s, salary is %s",
                    getId(),
                    getFullName(),
                    getCodeDepartment(),
                    getSalary());
        } else {
            result = String.format("(%s) \"%s\": salary is %s", getId(), getFullName(), getSalary());
        }
        return result;
    }
}
