// Build by Ibrahim Sarran
abstract class Student {
    protected int studentId;
    protected String studentName;
    protected int classId;
    protected String section;
    protected int busId;

    public Student(int studentId, String studentName, int classId, String section, int busId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
        this.section = section;
        this.busId = busId;
    }

    public abstract void payFees();

    public void studentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Class ID: " + classId);
        System.out.println("Section: " + section);
        System.out.println("Bus ID: " + busId);
    }
}


//Ibrahim Sarran -  451000513