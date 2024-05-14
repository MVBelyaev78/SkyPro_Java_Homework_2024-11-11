public class Test {
    public static final int SALARY_BOUND = 4000;

    public static Employee[] initArrEmployees() {
        Employee[] arrEmployee = new Employee[10];
        arrEmployee[0] = Employee.valueOf("Ellen White", 1, 2931);
        arrEmployee[1] = Employee.valueOf("John Black", 1, 3720);
        arrEmployee[2] = Employee.valueOf("Susan Brown", 4, 6800);
        arrEmployee[3] = Employee.valueOf("Larry Hagman", 2, 1250);
        arrEmployee[4] = Employee.valueOf("Stanley Miller", 4, 3400);
        arrEmployee[5] = Employee.valueOf("Philipp Roberts", 3, 6220);
        arrEmployee[6] = Employee.valueOf("Neil Green", 4, 5000);
        arrEmployee[7] = Employee.valueOf("Anna Williams", 4, 4000);
        arrEmployee[8] = Employee.valueOf("Lucinda Watson", 5, 5000);
        arrEmployee[9] = Employee.valueOf("Mick Jones", 5, 1567);
        return arrEmployee;
    }

    public static void runSuiteAllDepartments01(EmployeeBook employeeBook) {
        runPrintAllEmployees(employeeBook);
        runPrintSumSalaries(employeeBook);
        runPrintLowestPaidEmployee(employeeBook);
        runPrintHighestPaidEmployee(employeeBook);
        runPrintAverageSalaries(employeeBook);
        runPrintFullNamesList(employeeBook);
        printCurrentSequenceIdValue();
        runPrintEmployeesLessSalary(employeeBook);
        runPrintEmployeesMoreOrEqualSalary(employeeBook);
    }

    public static void runSuiteAllDepartments02(EmployeeBook employeeBook) {
        runAddNewEmployee(employeeBook, "Gordon Tennison", 3, 5600);
        runDeleteEmployee(employeeBook, 7);
        runAddNewEmployee(employeeBook, "Gordon Tennison", 3, 5600);
        runPrintAllEmployees(employeeBook);
        runSelectEmployee(employeeBook, 1);
        runSelectEmployee(employeeBook, 4);
        runSelectEmployee(employeeBook, 1_000_000);
    }

    public static void runSuiteConcreteDepartment(EmployeeBook employeeBook, int codeDepartment) {
        System.out.println("--------------------------------------------------------------\n");
        Test.runPrintAllEmployees(employeeBook, codeDepartment);
        Test.runPrintSumSalaries(employeeBook, codeDepartment);
        Test.runPrintLowestPaidEmployee(employeeBook, codeDepartment);
        Test.runPrintHighestPaidEmployee(employeeBook, codeDepartment);
        Test.runPrintAverageSalaries(employeeBook, codeDepartment);
        Test.runPrintEmployeesLessSalary(employeeBook, codeDepartment);
        Test.runPrintEmployeesMoreOrEqualSalary(employeeBook, codeDepartment);
        Test.runIndexSalaries(employeeBook, codeDepartment);
    }

    private static void runPrintAllEmployees(EmployeeBook employeeBook) {
        employeeBook.printAllEmployees();
        System.out.println();
    }

    private static void runPrintAllEmployees(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Department code is %s\n\n", codeDepartment);
        employeeBook.printAllEmployees(codeDepartment, false);
        System.out.println();
    }

    private static void runPrintSumSalaries(EmployeeBook employeeBook) {
        System.out.printf("Salaries sum is %s\n", employeeBook.getSumSalaries());
    }

    private static void runPrintSumSalaries(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Salaries sum is %s\n", employeeBook.getSumSalaries(codeDepartment));
    }

    private static void runPrintLowestPaidEmployee(EmployeeBook employeeBook) {
        System.out.print("Lowest paid employee is ");
        employeeBook.printLowestPaidEmployee();
    }

    private static void runPrintLowestPaidEmployee(EmployeeBook employeeBook, int codeDepartment) {
        System.out.print("Lowest paid employee is ");
        employeeBook.printLowestPaidEmployee(codeDepartment, false);
    }

    private static void runPrintHighestPaidEmployee(EmployeeBook employeeBook) {
        System.out.print("Highest paid employee is ");
        employeeBook.printHighestPaidEmployee();
    }

    private static void runPrintHighestPaidEmployee(EmployeeBook employeeBook, int codeDepartment) {
        System.out.print("Highest paid employee is ");
        employeeBook.printHighestPaidEmployee(codeDepartment, false);
    }

    private static void runPrintAverageSalaries(EmployeeBook employeeBook) {
        System.out.printf("Average of salaries is %s\n", String.format("%.2f",
                employeeBook.getAverageSalaries()));
        System.out.println();
    }

    private static void runPrintAverageSalaries(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Average of salaries is %s\n",
                String.format("%.2f", employeeBook.getAverageSalaries(codeDepartment)));
        System.out.println();
    }

    private static void runPrintFullNamesList(EmployeeBook employeeBook) {
        System.out.println("Full names of all employees:");
        employeeBook.printFullNamesList();
        System.out.println();
    }

    private static void printCurrentSequenceIdValue() {
        System.out.printf("Current value of sequence of id is %s\n", Employee.getCurrentSequenceIdValue());
        System.out.println();
    }

    private static void runPrintEmployeesLessSalary(EmployeeBook employeeBook) {
        System.out.printf("Employees with salary less than %s\n", SALARY_BOUND);
        employeeBook.printEmployeesLessSalary(SALARY_BOUND);
        System.out.println();
    }

    private static void runPrintEmployeesLessSalary(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Employees with salary less than %s\n", SALARY_BOUND);
        employeeBook.printEmployeesLessSalary(SALARY_BOUND, codeDepartment, false);
        System.out.println();
    }

    private static void runPrintEmployeesMoreOrEqualSalary(EmployeeBook employeeBook) {
        System.out.printf("Employees with salary equal or more than %s\n", SALARY_BOUND);
        employeeBook.printEmployeesMoreOrEqualSalary(SALARY_BOUND);
        System.out.println();
    }

    private static void runPrintEmployeesMoreOrEqualSalary(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Employees with salary equal or more than %s\n", SALARY_BOUND);
        employeeBook.printEmployeesMoreOrEqualSalary(SALARY_BOUND, codeDepartment, false);
        System.out.println();
    }

    private static void runIndexSalaries(EmployeeBook employeeBook, int codeDepartment) {
        System.out.println("Indexed salaries");
        employeeBook.indexSalaries(13, codeDepartment);
        employeeBook.printAllEmployees(codeDepartment, false);
        System.out.println();
    }

    private static void runAddNewEmployee(EmployeeBook employeeBook, String fullName, int codeDepartment, int salary) {
        System.out.printf("Result of adding a new employee: %s\n",
                employeeBook.addNewEmployee(fullName, codeDepartment, salary) ? "added successfully" : "not added");
    }

    private static void runDeleteEmployee(EmployeeBook employeeBook, int id) {
        System.out.printf("Result of deleting an employee: %s\n",
                employeeBook.deleteEmployee(id) ? "deleted successfully" : "not deleted");
    }

    private static void runSelectEmployee(EmployeeBook employeeBook, int id) {
        Employee employee = employeeBook.findEmployeeById(id);
        if (employee != null) {
            System.out.printf("Employee id=%s:\n", id);
            employee.printEmployeeData();
        } else {
            System.out.printf("Employee id=%s doesn't exist\n", id);
        }
        System.out.println();
    }
}
