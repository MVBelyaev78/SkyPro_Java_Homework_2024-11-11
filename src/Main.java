public class Main {

    public static void main(String[] args) {
        final int salaryBound = 4000;
        Employee[] arrEmployee = initArrEmployees();
        editArrEmployees(arrEmployee);
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
        System.out.printf("Employees with salary less than %s\n", salaryBound);
        printEmployeesLessSalary(arrEmployee, salaryBound);
        System.out.println();
        System.out.printf("Employees with salary equal or more than %s\n", salaryBound);
        printEmployeesMoreOrEqualSalary(arrEmployee, salaryBound);
        System.out.println();
        Employee.setMarkerPrintCodeDepartment(false);
        for (int d = Employee.MIN_CODE_DEPARTMENT; d <= Employee.MAX_CODE_DEPARTMENT; d++) {
            System.out.printf("Department code is %s\n", d);
            printAllEmployees(arrEmployee, d);
            System.out.printf("Salaries sum is %s\n", getSumSalaries(arrEmployee, d));
            System.out.printf("Lowest paid employee is %s\n", getLowestPaidEmployee(arrEmployee, d));
            System.out.printf("Highest paid employee is %s\n", getHighestPaidEmployee(arrEmployee, d));
            System.out.printf("Average of salaries is %s\n",
                    String.format("%.2f", getAverageSalaries(arrEmployee, d)));
            System.out.printf("Employees with salary less than %s\n", salaryBound);
            printEmployeesLessSalary(arrEmployee, salaryBound, d);
            System.out.printf("Employees with salary equal or more than %s\n", salaryBound);
            printEmployeesMoreOrEqualSalary(arrEmployee, salaryBound, d);
            System.out.println("Indexed salaries");
            indexSalaries(arrEmployee, 13, d);
            printAllEmployees(arrEmployee, d);
            System.out.println();
        }
        Employee.setMarkerPrintCodeDepartment(true);
    }

    public static Employee[] initArrEmployees() {
        Employee[] arrEmployee = new Employee[10];
        arrEmployee[0] = new Employee("Ellen White", 1, 2931);
        arrEmployee[1] = new Employee("John Black", 1, 3720);
        arrEmployee[2] = new Employee("Susan Brown", 2, 6800);
        arrEmployee[3] = new Employee("Larry Hagman", 2, 1345);
        arrEmployee[4] = new Employee("Stanley Miller", 2, 5000);
        arrEmployee[5] = new Employee("Philipp Roberts", 3, 6220);
        arrEmployee[6] = new Employee("Neil Green", 4, 5000);
        arrEmployee[7] = new Employee("Anna Williams", 4, 4000);
        arrEmployee[8] = new Employee("Lucinda Watson", 5, 5000);
        arrEmployee[9] = new Employee("Mick Jones", 5, 1567);
        return arrEmployee;
    }

    public static void editArrEmployees(Employee[] arrEmployee) {
        arrEmployee[2].setCodeDepartment(4);
        arrEmployee[3].setSalary(1250);
        arrEmployee[4].setCodeDepartment(4);
        arrEmployee[4].setSalary(3400);
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
