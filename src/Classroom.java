class Classroom {
    private int classId;
    private String className;
    private Teacher teacher;
    private int studentCount;
    private int equipmentId;

    public Classroom(int classId, String className, Teacher teacher, int studentCount, int equipmentId) {
        this.classId = classId;
        this.className = className;
        this.teacher = teacher; 
        this.studentCount = studentCount;
        this.equipmentId = equipmentId;
    }

    public void classDetails() {
        System.out.println("Class ID: " + classId);
        System.out.println("Class Name: " + className);
        
        if (teacher != null) {
            System.out.println("Teacher Info");
            teacher.employeeDetails(); 
        } else {
            System.out.println("Teacher: Not Assigned");
        }

        System.out.println("Student Count: " + studentCount);
        System.out.println("Equipment ID: " + equipmentId);
    }
}
//Taher Ramzi -451000573