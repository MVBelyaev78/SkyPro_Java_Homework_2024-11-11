public class Main {

    public static Employee[] initArrEmployees() {
        Employee[] arrEmployee = new Employee[10];
        arrEmployee[0] = new Employee("Ellen White", 1, 2931);
        arrEmployee[1] = new Employee("John Black", 1, 4720);
        arrEmployee[2] = new Employee("Susan Brown", 2, 6800);
        arrEmployee[3] = new Employee("Larry Hagman", 2, 1345);
        arrEmployee[4] = new Employee("Stanley Miller", 2, 5000);
        arrEmployee[5] = new Employee("Philipp Roberts", 3, 6220);
        arrEmployee[6] = new Employee("Neil Green", 4, 5000);
        arrEmployee[7] = new Employee("Anna Williams", 4, 3000);
        arrEmployee[8] = new Employee("Lucinda Watson", 5, 5000);
        arrEmployee[9] = new Employee("Mick Jones", 5, 1567);
        return arrEmployee;
    }

    public static void editArrEmployees(Employee[] arrEmployee) {
        arrEmployee[2].setCodeDepartment(4);
        arrEmployee[3].setSalary(1250);
        arrEmployee[4].setCodeDepartment(4);
        arrEmployee[4].setSalary(5400);
    }

    public static void printAllEmployees(Employee[] arrEmployee) {
        for (Employee e : arrEmployee) {
            System.out.println(e);
        }
    }

    public static int getSumSalaries(Employee[] arrEmployee) {
        int result = 0;
        for (Employee e : arrEmployee) {
            result += e.getSalary();
        }
        return result;
    }

    public static Employee getLowestPaidEmployee(Employee[] arrEmployee) {
        Employee lowestPaidEmployee = null;
        int currentSalary = 0;
        for (Employee e : arrEmployee) {
            if (lowestPaidEmployee == null || e.getSalary() < currentSalary) {
                currentSalary = e.getSalary();
                lowestPaidEmployee = e;
            }
        }
        return lowestPaidEmployee;
    }

    public static Employee getHighestPaidEmployee(Employee[] arrEmployee) {
        Employee highestPaidEmployee = null;
        int currentSalary = 0;
        for (Employee e : arrEmployee) {
            if (highestPaidEmployee == null || e.getSalary() > currentSalary) {
                currentSalary = e.getSalary();
                highestPaidEmployee = e;
            }
        }
        return highestPaidEmployee;
    }

    public static double getAverageSalaries(Employee[] arrEmployee) {
        return arrEmployee.length != 0 ? (double) getSumSalaries(arrEmployee) / arrEmployee.length : 0d;
    }

    public static void printFullNamesList(Employee[] arrEmployee) {
        for (Employee e : arrEmployee) {
            System.out.println(e.getFullName());
        }
    }

    public static void main(String[] args) {
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
    }
}