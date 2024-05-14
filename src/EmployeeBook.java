import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class EmployeeBook {
    private static final int ALL_CODE_DEPARTMENTS = -1;
    private final List<Employee> arrEmployee;

    public EmployeeBook() {
        arrEmployee = new LinkedList<>();
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
        return arrEmployee.equals(((EmployeeBook) object).getArrEmployee());
    }

    public int hashCode() {
        return Objects.hash(getArrEmployee());
    }

    public void add(Employee employee) {
        if (employee != null) {
            arrEmployee.add(employee);
        }
    }

    public void remove(Employee employee) {
        arrEmployee.remove(employee);
    }

    public List<Employee> getArrEmployeeByDepartment(int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment || codeDepartment == ALL_CODE_DEPARTMENTS)
                .toList();
    }

    public int getSumSalaries() {
        return getSumSalaries(0);
    }

    public int getSumSalaries(int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment ||
                        codeDepartment == ALL_CODE_DEPARTMENTS)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Employee getLowestPaidEmployee() {
        return getLowestPaidEmployee(ALL_CODE_DEPARTMENTS);
    }

    public Employee getLowestPaidEmployee(int codeDepartment) {
        Employee result = null;
        for (Employee e : arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment || codeDepartment == ALL_CODE_DEPARTMENTS)
                .toList()) {
            if (result == null || e.getSalary() < result.getSalary()) {
                result = e;
            }
        }
        return result;
    }

    public Employee getHighestPaidEmployee() {
        return getHighestPaidEmployee(ALL_CODE_DEPARTMENTS);
    }

    public Employee getHighestPaidEmployee(int codeDepartment) {
        Employee result = null;
        for (Employee e : arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment || codeDepartment == ALL_CODE_DEPARTMENTS)
                .toList()) {
            if (result == null || e.getSalary() > result.getSalary()) {
                result = e;
            }
        }
        return result;
    }

    public double getAverageSalaries() {
        return getAverageSalaries(ALL_CODE_DEPARTMENTS);
    }

    public double getAverageSalaries(int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment || codeDepartment == ALL_CODE_DEPARTMENTS)
                .mapToInt(Employee::getSalary)
                .average()
                .getAsDouble();
    }

    public void indexSalaries(int ratePercent, int codeDepartment) {
        if (ratePercent <= 0) {
            throw new IllegalArgumentException("Rate can't be non-positive");
        }
        for (Employee e : arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment || codeDepartment == ALL_CODE_DEPARTMENTS)
                .toList()) {
            e.setSalary((int) Math.ceil(e.getSalary() * (1d + ratePercent / 100d)));
        }
    }

    public List<Employee> getEmployeeBookLessSalary(int salary) {
        return getEmployeeBookLessSalary(salary, ALL_CODE_DEPARTMENTS);
    }

    public List<Employee> getEmployeeBookLessSalary(int salary, int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment || codeDepartment == ALL_CODE_DEPARTMENTS)
                .filter(e -> e.getSalary() < salary)
                .toList();
    }

    public List<Employee> getEmployeeBookMoreOrEqualSalary(int salary) {
        return getEmployeeBookMoreOrEqualSalary(salary, ALL_CODE_DEPARTMENTS);
    }

    public List<Employee> getEmployeeBookMoreOrEqualSalary(int salary, int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment || codeDepartment == ALL_CODE_DEPARTMENTS)
                .filter(e -> e.getSalary() >= salary)
                .toList();
    }

    public boolean addNewEmployee(String fullName, int codeDepartment, int salary) {
        arrEmployee.add(Employee.valueOf(fullName, codeDepartment, salary));
        return true;
    }

    public boolean removeEmployee(int id) {
        return arrEmployee.remove(arrEmployee.stream().filter(e -> e.getId() == id));
    }

    public Employee findEmployeeById(int id) {
        return arrEmployee.stream().filter(e -> e.getId() == id).toList().getFirst();
    }
}
