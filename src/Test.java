import java.util.List;

public class Test {
    private static final int SALARY_BOUND = 4000;
    private final EmployeeBook employeeBook = new EmployeeBook();

    public Test() {
    }

    public void addInitialEmployeeBook() {
        addNewEmployee("Ellen White", 1, 2931);
        addNewEmployee("John Black", 1, 3720);
        addNewEmployee("John Silver", 1, 3720);
        addNewEmployee("Thomas Johnson", 1, 2500);
        addNewEmployee("Sarah Fill", 1, 2000);
        addNewEmployee("Gordon Lloyd", 1, 2000);
        addNewEmployee("Susan Brown", 2, 6800);
        addNewEmployee("Larry Hagman", 2, 1250);
        addNewEmployee("Stanley Miller", 4, 3400);
        addNewEmployee("Philipp Roberts", 4, 6800);
        addNewEmployee("Neil Green", 4, 5000);
        addNewEmployee("Anna Williams", 4, 4000);
        addNewEmployee("Lucinda Watson", 5, 5000);
        addNewEmployee("Mick Jones", 5, 2300);
        addNewEmployee("Steve Romney", 5, 1250);
    }

    public void runUnitedSuite() {
        if (runPrintAllEmployees()) {
            runSuit01();
            runSuit02();
            runSuite03();
        }
    }

    public void runSuit01() {
        runPrintSumSalaries();
        runPrintAverageSalaries();
        System.out.println();
        runPrintLowestPaidEmployee();
        runPrintHighestPaidEmployee();
        System.out.println();
        runPrintFullNamesList();
        printCurrentSequenceIdValue();
        runPrintEmployeesLessSalary();
        runPrintEmployeesMoreOrEqualSalary();
    }
    public void runSuit02() {
        for (int d = Employee.MIN_CODE_DEPARTMENT; d <= Employee.MAX_CODE_DEPARTMENT; d++) {
            runSuiteConcreteDepartment(d);
        }
    }

    public void runSuite03() {
        System.out.println();
        runAddEmployee("Gordon Tennison", 2, 3900);
        runAddEmployee("Stewart Olson", 3, 5600);
        runRemoveEmployee(1);
        runRemoveEmployee(2);
        runRemoveEmployee(666);
        System.out.println();
        if (runPrintAllEmployees())
        {
            runFindEmployee(1);
            runFindEmployee(4);
            runFindEmployee(1_000_000);
        }
    }

    private void runSuiteConcreteDepartment(int codeDepartment) {
        System.out.println("--------------------------------------------------------------\n");
        System.out.printf("Department code is %s\n\n", codeDepartment);
        if (runPrintAllEmployees(codeDepartment))
        {
            runPrintSumSalaries(codeDepartment);
            runPrintAverageSalaries(codeDepartment);
            runPrintLowestPaidEmployee(codeDepartment);
            runPrintHighestPaidEmployee(codeDepartment);
            runPrintEmployeesLessSalary(codeDepartment);
            runPrintEmployeesMoreOrEqualSalary(codeDepartment);
            runIndexSalaries(codeDepartment);
        }
    }

    private boolean runPrintAllEmployees() {
        boolean result = false;
        final List<Employee> list = employeeBook.getEmployeeList();
        if (!list.isEmpty()) {
            list.forEach(e -> System.out.println(e.getFullEmployeeData()));
            result = true;
        }
        System.out.println();
        return result;
    }

    private boolean runPrintAllEmployees(int codeDepartment) {
        boolean result = false;
        final List<Employee> list = employeeBook.getEmployeeList(codeDepartment);
        if (!list.isEmpty()) {
            list.forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
            result = true;
        }
        System.out.println();
        return result;
    }

    private void runPrintSumSalaries() {
        System.out.printf("Salaries sum is %s\n", employeeBook.getSumSalaries());
    }

    private void runPrintSumSalaries(int codeDepartment) {
        System.out.printf("Salaries sum is %s\n", employeeBook.getSumSalaries(codeDepartment));
    }

    private void runPrintAverageSalaries() {
        System.out.printf("Average of salaries is %s\n", String.format("%.2f",
                employeeBook.getAverageSalaries()));
    }

    private void runPrintLowestPaidEmployee() {
        System.out.println("Lowest paid employees");
        employeeBook
                .getLowestPaidEmployee()
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private void runPrintLowestPaidEmployee(int codeDepartment) {
        System.out.println("Lowest paid employees");
        employeeBook
                .getLowestPaidEmployee(codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private void runPrintHighestPaidEmployee() {
        System.out.println("Highest paid employees");
        employeeBook
                .getHighestPaidEmployee()
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
    }

    private void runPrintHighestPaidEmployee(int codeDepartment) {
        System.out.println("Highest paid employees");
        employeeBook
                .getHighestPaidEmployee(codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private void runPrintAverageSalaries(int codeDepartment) {
        System.out.printf("Average of salaries is %s\n",
                String.format("%.2f", employeeBook.getAverageSalaries(codeDepartment)));
        System.out.println();
    }

    private void runPrintFullNamesList() {
        System.out.println("Full names of all employees");
        employeeBook
                .getEmployeeFullNames()
                .forEach(System.out::println);
        System.out.println();
    }

    private void printCurrentSequenceIdValue() {
        System.out.printf("Current value of sequence of id is %s\n", Employee.getCurrentSequenceIdValue());
        System.out.println();
    }

    private void runPrintEmployeesLessSalary() {
        System.out.printf("Employees with salary less than %s\n", SALARY_BOUND);
        employeeBook
                .getEmployeeLessSalary(SALARY_BOUND)
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private void runPrintEmployeesLessSalary(int codeDepartment) {
        System.out.printf("Employees with salary less than %s\n", SALARY_BOUND);
        employeeBook
                .getEmployeeLessSalary(SALARY_BOUND, codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private void runPrintEmployeesMoreOrEqualSalary() {
        System.out.printf("Employees with salary equal or more than %s\n", SALARY_BOUND);
        employeeBook
                .getEmployeeMoreOrEqualSalary(SALARY_BOUND)
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private void runPrintEmployeesMoreOrEqualSalary(int codeDepartment) {
        System.out.printf("Employees with salary equal or more than %s\n", SALARY_BOUND);
        employeeBook
                .getEmployeeMoreOrEqualSalary(SALARY_BOUND, codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private void runIndexSalaries(int codeDepartment) {
        double ratePercent = 13.7;
        System.out.println("Indexed salaries");
        employeeBook.indexSalaries(ratePercent, codeDepartment);
        employeeBook
                .getEmployeeList(codeDepartment)
                .forEach(e -> System.out.println(e.getEmployeeDataExceptDepartment()));
        System.out.println();
    }

    private void runAddEmployee(String fullName, int codeDepartment, int salary) {
        System.out.printf("Result of adding a new employee: %s\n",
                addNewEmployee(fullName, codeDepartment, salary)
                        ? "added successfully"
                        : "not added");
    }

    private void runRemoveEmployee(int id) {
        System.out.printf("Result of deleting an employee id=%s: %s\n",
                id,
                employeeBook.remove(id)
                        ? "deleted successfully"
                        : "not deleted");
    }

    private void runFindEmployee(int id) {
        System.out.printf("Employees id=%s\n", id);
        employeeBook
                .findEmployeeById(id)
                .forEach(e -> System.out.println(e.getFullEmployeeData()));
        System.out.println();
    }

    private boolean addNewEmployee(String fullName, int codeDepartment, int salary) {
        return employeeBook.add(Employee.valueOf(fullName, codeDepartment, salary));
    }
}
