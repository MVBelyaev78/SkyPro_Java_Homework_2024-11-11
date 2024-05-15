public class Main {

    public static void main(String[] args) {
        Test test = new Test();
        test.addInitialEmployeeBook();
        test.runSuiteAllDepartments01();
        for (int d = Employee.MIN_CODE_DEPARTMENT; d <= Employee.MAX_CODE_DEPARTMENT; d++) {
            test.runSuiteConcreteDepartment(d);
        }
        test.runSuiteAllDepartments02();
    }
}
