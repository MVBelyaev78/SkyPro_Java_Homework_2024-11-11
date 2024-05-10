public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(Test.initArrEmployees());
        System.out.printf("%s\n", employeeBook);
        System.out.printf("Salaries sum is %s\n\n", employeeBook.getSumSalaries());
        System.out.printf("Lowest paid employee is %s\n", employeeBook.getLowestPaidEmployee());
        System.out.printf("Highest paid employee is %s\n\n", employeeBook.getHighestPaidEmployee());
        System.out.printf("Average of salaries is %s\n",
                String.format("%.2f", employeeBook.getAverageSalaries()));
        System.out.println();
        System.out.println("Full names of all employees:");
        employeeBook.printFullNamesList();
        System.out.println();
        System.out.printf("Current value of sequence of id is %s\n", Employee.getCurrentSequenceIdValue());
        System.out.println();
        EmployeeBook.setSalaryUpperBound(Test.SALARY_BOUND);
        System.out.printf("Employees with salary less than %s\n%s\n", Test.SALARY_BOUND, employeeBook);
        EmployeeBook.initSalaryUpperBound();
        EmployeeBook.setSalaryLowerBound(Test.SALARY_BOUND);
        System.out.printf("Employees with salary equal or more than %s\n%s\n", Test.SALARY_BOUND, employeeBook);
        EmployeeBook.initSalaryLowerBound();
        EmployeeBook.unselectPrintCodeDepartment();
        for (int d = Employee.MIN_CODE_DEPARTMENT; d <= Employee.MAX_CODE_DEPARTMENT; d++) {
            EmployeeBook.setPrintedCodeDepartment(d);
            System.out.println("--------------------------------------------------------------\n");
            System.out.printf("Department code is %s\n\n", d);
            System.out.println(employeeBook);
            System.out.printf("Salaries sum is %s\n\n", employeeBook.getSumSalaries(d));
            System.out.printf("Lowest paid employee is %s\n", employeeBook.getLowestPaidEmployee(d));
            System.out.printf("Highest paid employee is %s\n\n", employeeBook.getHighestPaidEmployee(d));
            System.out.printf("Average of salaries is %s\n\n",
                    String.format("%.2f", employeeBook.getAverageSalaries(d)));
            EmployeeBook.setSalaryUpperBound(Test.SALARY_BOUND);
            System.out.printf("Employees with salary less than %s\n%s\n", Test.SALARY_BOUND, employeeBook);
            EmployeeBook.initSalaryUpperBound();
            EmployeeBook.setSalaryLowerBound(Test.SALARY_BOUND);
            System.out.printf("Employees with salary equal or more than %s\n%s\n", Test.SALARY_BOUND, employeeBook);
            EmployeeBook.initSalaryLowerBound();
            System.out.println("Indexed salaries");
            employeeBook.indexSalaries(Test.RATE_PERCENT, d);
            System.out.printf("%s\n", employeeBook);
            EmployeeBook.initPrintedCodeDepartment();
        }
        EmployeeBook.selectPrintCodeDepartment();
    }

}
