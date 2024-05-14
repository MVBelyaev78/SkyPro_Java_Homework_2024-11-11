public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = Test.initArrEmployees();
        Test.runSuiteAllDepartments01(employeeBook);
        for (int d = Employee.MIN_CODE_DEPARTMENT; d <= Employee.MAX_CODE_DEPARTMENT; d++) {
            Test.runSuiteConcreteDepartment(employeeBook, d);
        }
        Test.runSuiteAllDepartments02(employeeBook);
    }
}
