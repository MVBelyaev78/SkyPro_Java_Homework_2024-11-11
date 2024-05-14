public class Test {
    private static final int SALARY_BOUND = 4000;

    public static EmployeeBook initArrEmployees() {
        EmployeeBook employeeBook = new EmployeeBook();
        addNewEmployee(employeeBook, "Ellen White", 1, 2931);
        addNewEmployee(employeeBook, "John Black", 1, 3720);
        addNewEmployee(employeeBook, "John Silver", 1, 3720);
        addNewEmployee(employeeBook, "Thomas Johnson", 1, 2500);
        addNewEmployee(employeeBook, "Sarah Fill", 1, 2000);
        addNewEmployee(employeeBook, "Gordon Lloyd", 1, 2000);
        addNewEmployee(employeeBook, "Susan Brown", 2, 6800);
        addNewEmployee(employeeBook, "Larry Hagman", 2, 1250);
        addNewEmployee(employeeBook, "Stanley Miller", 4, 3400);
        addNewEmployee(employeeBook, "Philipp Roberts", 3, 6800);
        addNewEmployee(employeeBook, "Neil Green", 4, 5000);
        addNewEmployee(employeeBook, "Anna Williams", 4, 4000);
        addNewEmployee(employeeBook, "Lucinda Watson", 5, 5000);
        addNewEmployee(employeeBook, "Mick Jones", 5, 2300);
        addNewEmployee(employeeBook, "Steve Romney", 5, 1250);
        return employeeBook;
    }

    public static void runSuiteAllDepartments01(EmployeeBook employeeBook) {
        runPrintAllEmployees(employeeBook);
        runPrintSumSalaries(employeeBook);
        runPrintAverageSalaries(employeeBook);
        System.out.println();
        runPrintLowestPaidEmployee(employeeBook);
        runPrintHighestPaidEmployee(employeeBook);
        System.out.println();
        runPrintFullNamesList(employeeBook);
        printCurrentSequenceIdValue();
        runPrintEmployeesLessSalary(employeeBook);
        runPrintEmployeesMoreOrEqualSalary(employeeBook);
    }

    public static void runSuiteAllDepartments02(EmployeeBook employeeBook) {
        System.out.println();
        runAddEmployee(employeeBook, "Gordon Tennison", 2, 3900);
        runAddEmployee(employeeBook, "Stewart Olson", 3, 5600);
        runRemoveEmployee(employeeBook, 3);
        runRemoveEmployee(employeeBook, 7);
        runRemoveEmployee(employeeBook, 666);
        System.out.println();
        runPrintAllEmployees(employeeBook);
        runFindEmployee(employeeBook, 1);
        runFindEmployee(employeeBook, 4);
        runFindEmployee(employeeBook, 1_000_000);
    }

    public static void runSuiteConcreteDepartment(EmployeeBook employeeBook, int codeDepartment) {
        System.out.println("--------------------------------------------------------------\n");
        Test.runPrintAllEmployees(employeeBook, codeDepartment);
        Test.runPrintSumSalaries(employeeBook, codeDepartment);
        Test.runPrintAverageSalaries(employeeBook, codeDepartment);
        Test.runPrintLowestPaidEmployee(employeeBook, codeDepartment);
        Test.runPrintHighestPaidEmployee(employeeBook, codeDepartment);
        Test.runPrintEmployeesLessSalary(employeeBook, codeDepartment);
        Test.runPrintEmployeesMoreOrEqualSalary(employeeBook, codeDepartment);
        Test.runIndexSalaries(employeeBook, codeDepartment);
    }

    private static void runPrintAllEmployees(EmployeeBook employeeBook) {
        //runPrintAllEmployees(employeeBook, EmployeeBook.ALL_CODE_DEPARTMENTS);
        employeeBook
                .getEmployeeList()
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private static void runPrintAllEmployees(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Department code is %s\n\n", codeDepartment);
        employeeBook
                .getEmployeeList(codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private static void runPrintSumSalaries(EmployeeBook employeeBook) {
        System.out.printf("Salaries sum is %s\n", employeeBook.getSumSalaries());
    }

    private static void runPrintSumSalaries(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Salaries sum is %s\n", employeeBook.getSumSalaries(codeDepartment));
    }

    private static void runPrintAverageSalaries(EmployeeBook employeeBook) {
        System.out.printf("Average of salaries is %s\n", String.format("%.2f",
                employeeBook.getAverageSalaries()));
    }

    private static void runPrintLowestPaidEmployee(EmployeeBook employeeBook) {
        System.out.println("Lowest paid employees");
        employeeBook
                .getLowestPaidEmployee()
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private static void runPrintLowestPaidEmployee(EmployeeBook employeeBook, int codeDepartment) {
        System.out.println("Lowest paid employees");
        employeeBook
                .getLowestPaidEmployee(codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private static void runPrintHighestPaidEmployee(EmployeeBook employeeBook) {
        System.out.println("Highest paid employees");
        employeeBook
                .getHighestPaidEmployee()
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
    }

    private static void runPrintHighestPaidEmployee(EmployeeBook employeeBook, int codeDepartment) {
        System.out.println("Highest paid employees");
        employeeBook
                .getHighestPaidEmployee(codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private static void runPrintAverageSalaries(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Average of salaries is %s\n",
                String.format("%.2f", employeeBook.getAverageSalaries(codeDepartment)));
        System.out.println();
    }

    private static void runPrintFullNamesList(EmployeeBook employeeBook) {
        System.out.println("Full names of all employees");
        employeeBook
                .getEmployeeFullNames()
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printCurrentSequenceIdValue() {
        System.out.printf("Current value of sequence of id is %s\n", Employee.getCurrentSequenceIdValue());
        System.out.println();
    }

    private static void runPrintEmployeesLessSalary(EmployeeBook employeeBook) {
        System.out.printf("Employees with salary less than %s\n", SALARY_BOUND);
        employeeBook
                .getEmployeeLessSalary(SALARY_BOUND)
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private static void runPrintEmployeesLessSalary(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Employees with salary less than %s\n", SALARY_BOUND);
        employeeBook
                .getEmployeeLessSalary(SALARY_BOUND, codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private static void runPrintEmployeesMoreOrEqualSalary(EmployeeBook employeeBook) {
        System.out.printf("Employees with salary equal or more than %s\n", SALARY_BOUND);
        employeeBook
                .getEmployeeMoreOrEqualSalary(SALARY_BOUND)
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private static void runPrintEmployeesMoreOrEqualSalary(EmployeeBook employeeBook, int codeDepartment) {
        System.out.printf("Employees with salary equal or more than %s\n", SALARY_BOUND);
        employeeBook
                .getEmployeeMoreOrEqualSalary(SALARY_BOUND, codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private static void runIndexSalaries(EmployeeBook employeeBook, int codeDepartment) {
        System.out.println("Indexed salaries");
        employeeBook.indexSalaries(13, codeDepartment);
        employeeBook
                .getEmployeeList(codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private static void runAddEmployee(EmployeeBook employeeBook, String fullName, int codeDepartment, int salary) {
        System.out.printf("Result of adding a new employee: %s\n",
                employeeBook.add(Employee.valueOf(fullName, codeDepartment, salary))
                        ? "added successfully"
                        : "not added");
    }

    private static void runRemoveEmployee(EmployeeBook employeeBook, int id) {
        System.out.printf("Result of deleting an employee id=%s: %s\n",
                id,
                employeeBook.remove(id)
                        ? "deleted successfully"
                        : "not deleted");
    }

    private static void runFindEmployee(EmployeeBook employeeBook, int id) {
        System.out.printf("Employees id=%s\n", id);
        employeeBook
                .findEmployeeById(id)
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private static void addNewEmployee(EmployeeBook employeeBook, String fullName, int codeDepartment, int salary)
            throws IllegalArgumentException {
        employeeBook.add(Employee.valueOf(fullName, codeDepartment, salary));
    }
}
