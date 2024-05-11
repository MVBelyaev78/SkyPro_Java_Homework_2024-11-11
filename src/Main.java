public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(Test.initArrEmployees());
        employeeBook.printAllEmployees();
        System.out.println();
        System.out.printf("Salaries sum is %s\n\n", employeeBook.getSumSalaries());
        System.out.printf("Lowest paid employee is %s\n", employeeBook.getLowestPaidEmployee().getEmployeeData());
        System.out.printf("Highest paid employee is %s\n\n", employeeBook.getHighestPaidEmployee().getEmployeeData());
        System.out.printf("Average of salaries is %s\n",
                String.format("%.2f", employeeBook.getAverageSalaries()));
        System.out.println();
        System.out.println("Full names of all employees:");
        employeeBook.printFullNamesList();
        System.out.println();
        System.out.printf("Current value of sequence of id is %s\n", Employee.getCurrentSequenceIdValue());
        System.out.println();
        System.out.printf("Employees with salary less than %s\n", Test.SALARY_BOUND);
        employeeBook.printEmployeesLessSalary(Test.SALARY_BOUND);
        System.out.println();
        System.out.printf("Employees with salary equal or more than %s\n", Test.SALARY_BOUND);
        employeeBook.printEmployeesMoreOrEqualSalary(Test.SALARY_BOUND);
        System.out.println();
        for (int d = Employee.MIN_CODE_DEPARTMENT; d <= Employee.MAX_CODE_DEPARTMENT; d++) {
            System.out.println("--------------------------------------------------------------\n");
            System.out.printf("Department code is %s\n\n", d);
            employeeBook.printAllEmployees(d, false);
            System.out.println();
            System.out.printf("Salaries sum is %s\n", employeeBook.getSumSalaries(d));
            System.out.println();
            System.out.printf("Lowest paid employee is %s\n", employeeBook.getLowestPaidEmployee(d).getEmployeeData(false));
            System.out.printf("Highest paid employee is %s\n", employeeBook.getHighestPaidEmployee(d).getEmployeeData(false));
            System.out.println();
            System.out.printf("Average of salaries is %s\n",
                    String.format("%.2f", employeeBook.getAverageSalaries(d)));
            System.out.println();
            System.out.printf("Employees with salary less than %s\n", Test.SALARY_BOUND);
            employeeBook.printEmployeesLessSalary(Test.SALARY_BOUND, d, false);
            System.out.println();
            System.out.printf("Employees with salary equal or more than %s\n", Test.SALARY_BOUND);
            employeeBook.printEmployeesMoreOrEqualSalary(Test.SALARY_BOUND, d, false);
            System.out.println();
            System.out.println("Indexed salaries");
            employeeBook.indexSalaries(Test.RATE_PERCENT, d);
            employeeBook.printAllEmployees(d, false);
            System.out.println();
        }
    }
}
