import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class EmployeeBook {
    private final List<Employee> arrEmployee = new LinkedList<>();

    private EmployeeBook() {
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

    public void addEmployee(Employee employee) {
        if (employee != null) {
            arrEmployee.add(employee);
        }
    }
    /*public void printAllEmployees() {
        printAllEmployees(0, true);
    }

    public void printAllEmployees(int codeDepartment, boolean printCodeDepartment) {
        for (Employee e : getArrEmployee()) {
            if (e != null) {
                e.printEmployeeData(codeDepartment, printCodeDepartment);
            }
        }
    }*/

    public int getSumSalaries() {
        return getSumSalaries(0);
    }

    public int getSumSalaries(int codeDepartment) {
        int result = 0;
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment)) {
                result += e.getSalary();
            }
        }*/
        return result;
    }

    /*public void printLowestPaidEmployee() {
        printLowestPaidEmployee(0, true);
    }

    public void printLowestPaidEmployee(int codeDepartment, boolean printCodeDepartment) {
        Employee lowestPaidEmployee = null;
        int currentSalary = 0;
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment) &&
                    (lowestPaidEmployee == null || e.getSalary() < currentSalary)) {
                currentSalary = e.getSalary();
                lowestPaidEmployee = e;
            }
        }
        if (lowestPaidEmployee != null) {
            lowestPaidEmployee.printEmployeeData(codeDepartment, printCodeDepartment);
        }
    }

    public void printHighestPaidEmployee() {
        printHighestPaidEmployee(0, true);
    }

    public void printHighestPaidEmployee(int codeDepartment, boolean printCodeDepartment) {
        Employee highestPaidEmployee = null;
        int currentSalary = 0;
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment) &&
                    (highestPaidEmployee == null || e.getSalary() > currentSalary)) {
                currentSalary = e.getSalary();
                highestPaidEmployee = e;
            }
        }
        if (highestPaidEmployee != null) {
            highestPaidEmployee.printEmployeeData(codeDepartment, printCodeDepartment);
        }
    }*/

    public double getAverageSalaries() {
        return getAverageSalaries(0);
    }

    public double getAverageSalaries(int codeDepartment) {
        int countEmployees = 0;
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment)) {
                countEmployees++;
            }
        }
        return countEmployees != 0 ? (double) getSumSalaries(codeDepartment) / countEmployees : 0d;
    }

    public void indexSalaries(int ratePercent, int codeDepartment) {
        if (ratePercent <= 0) {
            throw new IllegalArgumentException("Rate can't be non-positive");
        }
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment)) {
                e.setSalary((int) Math.ceil(e.getSalary() * (1d + ratePercent / 100d)));
            }
        }
    }

    /*public void printFullNamesList() {
        printFullNamesList(0);
    }

    public void printFullNamesList(int codeDepartment) {
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment)) {
                System.out.println(e.getFullName());
            }
        }
    }

    public void printEmployeesLessSalary(int salary) {
        printEmployeesLessSalary(salary, 0, true);
    }

    public void printEmployeesLessSalary(int salary, int codeDepartment, boolean printCodeDepartment) {
        for (Employee e : getArrEmployee()) {
            if (e != null && e.getSalary() < salary) {
                e.printEmployeeData(codeDepartment, printCodeDepartment);
            }
        }
    }

    public void printEmployeesMoreOrEqualSalary(int salary) {
        printEmployeesMoreOrEqualSalary(salary, 0, true);
    }

    public void printEmployeesMoreOrEqualSalary(int salary, int codeDepartment, boolean printCodeDepartment) {
        for (Employee e : getArrEmployee()) {
            if (e != null && e.getSalary() >= salary) {
                e.printEmployeeData(codeDepartment, printCodeDepartment);
            }
        }
    }*/

    public boolean addNewEmployee(String fullName, int codeDepartment, int salary) {
        boolean result = false;
        for (int i = 0; i < arrEmployee.length; i++) {
            if (arrEmployee[i] == null) {
                arrEmployee[i] = Employee.valueOf(fullName, codeDepartment, salary);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean deleteEmployee(int id) {
        boolean result = false;
        for (int i = 0; i < arrEmployee.length; i++) {
            if (arrEmployee[i] != null && arrEmployee[i].getId() == id) {
                arrEmployee[i] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public Employee findEmployeeById(int id) {
        Employee result = null;
        for (Employee e : getArrEmployee()) {
            if (e != null && e.getId() == id) {
                result = e;
                break;
            }
        }
        return result;
    }

}
