import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] arrEmployee;

    public EmployeeBook(Employee[] arrEmployee) {
        this.arrEmployee = arrEmployee.clone();
    }

    public Employee[] getArrEmployee() {
        return arrEmployee;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return Arrays.equals(getArrEmployee(), ((EmployeeBook) object).getArrEmployee());
    }

    public int hashCode() {
        return Arrays.hashCode(getArrEmployee());
    }

    public String toString() {
        throw new RuntimeException("EmployeeBook object can't be printed");
    }

    public void printAllEmployees() {
        printAllEmployees(0, true);
    }

    public void printAllEmployees(int codeDepartment, boolean printCodeDepartment) {
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment)) {
                System.out.println(e.getEmployeeData(printCodeDepartment));
            }
        }
    }

    public int getSumSalaries() {
        return getSumSalaries(0);
    }

    public int getSumSalaries(int codeDepartment) {
        int result = 0;
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment)) {
                result += e.getSalary();
            }
        }
        return result;
    }

    public Employee getLowestPaidEmployee() {
        return getLowestPaidEmployee(0);
    }

    public Employee getLowestPaidEmployee(int codeDepartment) {
        Employee lowestPaidEmployee = null;
        int currentSalary = 0;
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment) &&
                    (lowestPaidEmployee == null || e.getSalary() < currentSalary)) {
                currentSalary = e.getSalary();
                lowestPaidEmployee = e;
            }
        }
        return lowestPaidEmployee;
    }

    public Employee getHighestPaidEmployee() {
        return getHighestPaidEmployee(0);
    }

    public Employee getHighestPaidEmployee(int codeDepartment) {
        Employee highestPaidEmployee = null;
        int currentSalary = 0;
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(codeDepartment) &&
                    (highestPaidEmployee == null || e.getSalary() > currentSalary)) {
                currentSalary = e.getSalary();
                highestPaidEmployee = e;
            }
        }
        return highestPaidEmployee;
    }

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
                e.setSalary(Math.round(e.getSalary() * (1f + ratePercent / 100f)));
            }
        }
    }

    public void printFullNamesList() {
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
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment) && e.getSalary() < salary) {
                System.out.println(e.getEmployeeData(printCodeDepartment));
            }
        }
    }

    public void printEmployeesMoreOrEqualSalary(int salary) {
        printEmployeesMoreOrEqualSalary(salary, 0, true);
    }
    public void printEmployeesMoreOrEqualSalary(int salary, int codeDepartment, boolean printCodeDepartment) {
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment) && e.getSalary() >= salary) {
                System.out.println(e.getEmployeeData(printCodeDepartment));
            }
        }
    }
}
