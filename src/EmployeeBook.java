import java.util.Arrays;

public class EmployeeBook {
    private Employee[] arrEmployee;
    private static boolean printCodeDepartment;
    private static int printedCodeDepartment;
    private static int salaryLowerBound;
    private static int salaryUpperBound;

    public EmployeeBook(Employee[] arrEmployee) {
        this.arrEmployee = arrEmployee;
        selectPrintCodeDepartment();
        initPrintedCodeDepartment();
        initSalaryLowerBound();
        initSalaryUpperBound();
    }


    public Employee[] getArrEmployee() {
        return arrEmployee;
    }

    public static boolean isPrintCodeDepartment() {
        return printCodeDepartment;
    }

    public static void selectPrintCodeDepartment() {
        printCodeDepartment = true;
    }

    public static void unselectPrintCodeDepartment() {
        printCodeDepartment = false;
    }

    public static void initPrintedCodeDepartment() {
        printedCodeDepartment = 0;
    }

    public static int getPrintedCodeDepartment() {
        return printedCodeDepartment;
    }

    public static void setPrintedCodeDepartment(int printedCodeDepartment) {
        EmployeeBook.printedCodeDepartment = printedCodeDepartment;
    }

    public static int getSalaryLowerBound() {
        return salaryLowerBound;
    }

    public static void setSalaryLowerBound(int salaryLowerBound) {
        EmployeeBook.salaryLowerBound = salaryLowerBound;
    }

    public static void initSalaryLowerBound() {
        salaryLowerBound = Integer.MAX_VALUE;
    }

    public static int getSalaryUpperBound() {
        return salaryUpperBound;
    }

    public static void setSalaryUpperBound(int salaryUpperBound) {
        EmployeeBook.salaryUpperBound = salaryUpperBound;
    }

    public static void initSalaryUpperBound() {
        salaryUpperBound = 0;
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
        StringBuilder result = new StringBuilder();
        for (Employee e : getArrEmployee()) {
            if (e.checkCodeDepartment(getPrintedCodeDepartment()) &&
                    e.checkSalaryLowerBound(getSalaryLowerBound()) &&
                    e.checkSalaryUpperBound(getSalaryUpperBound())) {
                result.append(String.format("%s\n", e));
            }
        }
        return result.toString();
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

}
