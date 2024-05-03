public class Employee {
    private static int sequenceId = 1;
    private static final int MIN_CODE_DEPARTMENT = 1;
    private static final int MAX_CODE_DEPARTMENT = 5;
    private final int id;
    private final String fullName;
    private int codeDepartment;
    private int salary;

    public static int getCurrentSequenceIdValue() {
        return sequenceId;
    }

    public static int getNextSequenceIdValue() {
        return sequenceId++;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCodeDepartment() {
        return codeDepartment;
    }

    public int getSalary() {
        return salary;
    }

    public void setCodeDepartment(int codeDepartment) {
        if (codeDepartment < MIN_CODE_DEPARTMENT || codeDepartment > MAX_CODE_DEPARTMENT) {
            throw new IllegalArgumentException(String.format("Department code must be between %s and %s",
                    MIN_CODE_DEPARTMENT,
                    MAX_CODE_DEPARTMENT));
        }
        this.codeDepartment = codeDepartment;
    }

    public void setSalary(int salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary can't be non-positive");
        }
        this.salary = salary;
    }

    public Employee(String fullName, int codeDepartment, int salary) {
        this.id = getNextSequenceIdValue();
        this.fullName = fullName;
        this.codeDepartment = codeDepartment;
        this.salary = salary;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Employee that = (Employee) object;
        boolean result = getFullName().equals(that.getFullName());
        result = result && getCodeDepartment() == that.getCodeDepartment();
        result = result && getSalary() == that.getSalary();
        return result;
    }

    public int hashCode() {
        int result = getFullName() == null ? 0 : getFullName().hashCode();
        result = 31 * result + getCodeDepartment();
        result = 31 * result + getSalary();
        return result;
    }

    public String toString() {
        return String.format("(%s) \"%s\": department code is %s, salary is %s",
                getId(),
                getFullName(),
                getCodeDepartment(),
                getSalary());
    }
}
