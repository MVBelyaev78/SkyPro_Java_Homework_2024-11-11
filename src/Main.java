public class Main {

    public static void main(String[] args) {
        Employee[] arrEmployee = Test.initArrEmployees();
        printAllEmployees(arrEmployee);
        System.out.println();
        System.out.printf("Salaries sum is %s\n", getSumSalaries(arrEmployee));
        System.out.printf("Lowest paid employee is %s\n", getLowestPaidEmployee(arrEmployee));
        System.out.printf("Highest paid employee is %s\n", getHighestPaidEmployee(arrEmployee));
        System.out.printf("Average of salaries is %s\n",
                String.format("%.2f", getAverageSalaries(arrEmployee)));
        System.out.println();
        System.out.println("Full names of all employees:");
        printFullNamesList(arrEmployee);
        System.out.println();
        System.out.printf("Current value of sequence of id is %s\n", Employee.getCurrentSequenceIdValue());
        System.out.println();
        System.out.printf("Employees with salary less than %s\n", Test.SALARY_BOUND);
        printEmployeesLessSalary(arrEmployee, Test.SALARY_BOUND);
        System.out.println();
        System.out.printf("Employees with salary equal or more than %s\n", Test.SALARY_BOUND);
        printEmployeesMoreOrEqualSalary(arrEmployee, Test.SALARY_BOUND);
        System.out.println();
        Employee.unselectPrintCodeDepartment();
        for (int d = Employee.MIN_CODE_DEPARTMENT; d <= Employee.MAX_CODE_DEPARTMENT; d++) {
            System.out.printf("Department code is %s\n", d);
            printAllEmployees(arrEmployee, d);
            System.out.printf("Salaries sum is %s\n", getSumSalaries(arrEmployee, d));
            System.out.printf("Lowest paid employee is %s\n", getLowestPaidEmployee(arrEmployee, d));
            System.out.printf("Highest paid employee is %s\n", getHighestPaidEmployee(arrEmployee, d));
            System.out.printf("Average of salaries is %s\n",
                    String.format("%.2f", getAverageSalaries(arrEmployee, d)));
            System.out.printf("Employees with salary less than %s\n", Test.SALARY_BOUND);
            printEmployeesLessSalary(arrEmployee, Test.SALARY_BOUND, d);
            System.out.printf("Employees with salary equal or more than %s\n", Test.SALARY_BOUND);
            printEmployeesMoreOrEqualSalary(arrEmployee, Test.SALARY_BOUND, d);
            System.out.println("Indexed salaries");
            indexSalaries(arrEmployee, 13, d);
            printAllEmployees(arrEmployee, d);
            System.out.println();
        }
        Employee.selectPrintCodeDepartment();
    }

    public static void printAllEmployees(Employee[] arrEmployee) {
        printAllEmployees(arrEmployee, 0);
    }

    public static void printAllEmployees(Employee[] arrEmployee, int codeDepartment) {
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment)) {
                System.out.println(e);
            }
        }
    }

    public static int getSumSalaries(Employee[] arrEmployee) {
        return getSumSalaries(arrEmployee, 0);
    }

    public static int getSumSalaries(Employee[] arrEmployee, int codeDepartment) {
        int result = 0;
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment)) {
                result += e.getSalary();
            }
        }
        return result;
    }

    public static Employee getLowestPaidEmployee(Employee[] arrEmployee) {
        return getLowestPaidEmployee(arrEmployee, 0);
    }

    public static Employee getLowestPaidEmployee(Employee[] arrEmployee, int codeDepartment) {
        Employee lowestPaidEmployee = null;
        int currentSalary = 0;
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment) &&
                    (lowestPaidEmployee == null || e.getSalary() < currentSalary)) {
                currentSalary = e.getSalary();
                lowestPaidEmployee = e;
            }
        }
        return lowestPaidEmployee;
    }

    public static Employee getHighestPaidEmployee(Employee[] arrEmployee) {
        return getHighestPaidEmployee(arrEmployee, 0);
    }

    public static Employee getHighestPaidEmployee(Employee[] arrEmployee, int codeDepartment) {
        Employee highestPaidEmployee = null;
        int currentSalary = 0;
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment) &&
                    (highestPaidEmployee == null || e.getSalary() > currentSalary)) {
                currentSalary = e.getSalary();
                highestPaidEmployee = e;
            }
        }
        return highestPaidEmployee;
    }

    public static double getAverageSalaries(Employee[] arrEmployee) {
        return getAverageSalaries(arrEmployee, 0);
    }

    public static double getAverageSalaries(Employee[] arrEmployee, int codeDepartment) {
        int countEmployees = 0;
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment)) {
                countEmployees++;
            }
        }
        return countEmployees != 0 ? (double) getSumSalaries(arrEmployee, codeDepartment) / countEmployees : 0d;
    }

    public static void indexSalaries(Employee[] arrEmployee, int ratePercent) {
        indexSalaries(arrEmployee, ratePercent, 0);
    }

    public static void indexSalaries(Employee[] arrEmployee, int ratePercent, int codeDepartment) {
        if (ratePercent <= 0) {
            throw new IllegalArgumentException("Rate can't be non-positive");
        }
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment)) {
                e.setSalary(Math.round(e.getSalary() * (1f + ratePercent / 100f)));
            }
        }
    }

    public static void printFullNamesList(Employee[] arrEmployee) {
        printFullNamesList(arrEmployee, 0);
    }

    public static void printFullNamesList(Employee[] arrEmployee, int codeDepartment) {
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment)) {
                System.out.println(e.getFullName());
            }
        }
    }

    public static void printEmployeesLessSalary(Employee[] arrEmployee, int salary) {
        printEmployeesLessSalary(arrEmployee, salary, 0);
    }

    public static void printEmployeesLessSalary(Employee[] arrEmployee, int salary, int codeDepartment) {
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment) && e.getSalary() < salary) {
                System.out.println(e);
            }
        }
    }

    public static void printEmployeesMoreOrEqualSalary(Employee[] arrEmployee, int salary) {
        printEmployeesMoreOrEqualSalary(arrEmployee, salary, 0);
    }

    public static void printEmployeesMoreOrEqualSalary(Employee[] arrEmployee, int salary, int codeDepartment) {
        for (Employee e : arrEmployee) {
            if (e.checkCodeDepartment(codeDepartment) && e.getSalary() >= salary) {
                System.out.println(e);
            }
        }
    }
}
