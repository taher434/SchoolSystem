abstract class Employee {
    protected int employeeId;
    protected String employeeName;
    protected double salary;
    protected int departmentId;

    public Employee(int employeeId, String employeeName, double salary, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public void employeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Salary: " + salary);
        System.out.println("Department ID: " + departmentId);
    }

    public void receiveSalary() {
        System.out.println("Employee: " + employeeName + " has received a salary of: " + salary);
    }

    public void checkIn() {
        System.out.println("Employee: " + employeeName + " has checked in.");
    }
}