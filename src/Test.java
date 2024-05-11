public class Test {
    public static final int SALARY_BOUND = 4000;
    public static final int RATE_PERCENT = 13;

    public static Employee[] initArrEmployees() {
        Employee[] arrEmployee = new Employee[10];
        arrEmployee[0] = new Employee("Ellen White", 1, 2931);
        arrEmployee[1] = new Employee("John Black", 1, 3720);
        arrEmployee[2] = new Employee("Susan Brown", 4, 6800);
        arrEmployee[3] = new Employee("Larry Hagman", 2, 1250);
        arrEmployee[4] = new Employee("Stanley Miller", 4, 3400);
        arrEmployee[5] = new Employee("Philipp Roberts", 3, 6220);
        arrEmployee[6] = new Employee("Neil Green", 4, 5000);
        arrEmployee[7] = new Employee("Anna Williams", 4, 4000);
        arrEmployee[8] = new Employee("Lucinda Watson", 5, 5000);
        arrEmployee[9] = new Employee("Mick Jones", 5, 1567);
        return arrEmployee;
    }
}
