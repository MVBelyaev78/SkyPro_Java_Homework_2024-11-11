import java.util.Objects;
import java.util.List;
import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.OptionalDouble;

public class EmployeeBook {
    private final List<Employee> arrEmployee = new LinkedList<>();

    public EmployeeBook() {
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
                .equals(((EmployeeBook) object)
                        .getArrEmployee());
    }

    public int hashCode() {
        return Objects.hash(arrEmployee);
    }

    public boolean add(Employee employee) {
        boolean result = false;
        if (employee != null) {
            arrEmployee.add(employee);
            return true;
        }
        return result;
    }

    public boolean remove(int id) {
        final int sizeBefore = arrEmployee.size();
        arrEmployee
                .removeAll(arrEmployee
                        .stream()
                        .filter(e -> e.getId() == id)
                        .toList());
        return sizeBefore > arrEmployee.size();
    }

    public List<Employee> getEmployeeList() {
        return arrEmployee;
    }

    public List<Employee> getEmployeeList(int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment)
                .toList();
    }

    public int getSumSalaries() {
        return arrEmployee
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getSumSalaries(int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment)
                .mapToInt(Employee::getSalary)
                .sum();
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
                    .toList();
        }
        return result;
    }

    public double getAverageSalaries() {
        double result = 0;
        OptionalDouble resultOptional = arrEmployee
                .stream()
                .mapToDouble(Employee::getSalary)
                .average();
        if (resultOptional.isPresent()) {
            result = resultOptional.getAsDouble();
        }
        return result;
    }

    public double getAverageSalaries(int codeDepartment) {
        double result = 0;
        OptionalDouble resultOptional = arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment)
                .mapToDouble(Employee::getSalary)
                .average();
        if (resultOptional.isPresent()) {
            result = resultOptional.getAsDouble();
        }
        return result;
    }

    public List<String> getEmployeeFullNames() {
        return arrEmployee
                .stream()
                .map(Employee::getFullName)
                .toList();
    }

    public void indexSalaries(double ratePercent, int codeDepartment) {
        arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment)
                .forEach(e -> e.indexSalary(ratePercent));
    }

    public List<Employee> getEmployeeLessSalary(int salary) {
        return arrEmployee
                .stream()
                .filter(e -> e.getSalary() < salary)
                .toList();
    }

    public List<Employee> getEmployeeLessSalary(int salary, int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment && e.getSalary() < salary)
                .toList();
    }

    public List<Employee> getEmployeeMoreOrEqualSalary(int salary) {
        return arrEmployee
                .stream()
                .filter(e -> e.getSalary() >= salary)
                .toList();
    }

    public List<Employee> getEmployeeMoreOrEqualSalary(int salary, int codeDepartment) {
        return arrEmployee
                .stream()
                .filter(e -> e.getCodeDepartment() == codeDepartment && e.getSalary() >= salary)
                .toList();
    }

    public List<Employee> findEmployeeById(int id) {
        return arrEmployee
                .stream()
                .filter(e -> e.getId() == id)
                .toList();
    }
}
