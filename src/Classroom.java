class Classroom {
    private int studentCount;
    private String className;
    private int classEquipmentId;
    private int benchCount;
    private int fanCount;
    private int lightCount;

    public Classroom(int studentCount, String className, int classEquipmentId, int benchCount, int fanCount, int lightCount) {
        this.studentCount = studentCount;
        this.className = className;
        this.classEquipmentId = classEquipmentId;
        this.benchCount = benchCount;
        this.fanCount = fanCount;
        this.lightCount = lightCount;
    }

    public void classDetails() {
        System.out.println("Class Name: " + className);
        System.out.println("Student Count: " + studentCount);
        System.out.println("Class Equipment ID: " + classEquipmentId);
        System.out.println("Bench Count: " + benchCount);
        System.out.println("Fan Count: " + fanCount);
        System.out.println("Light Count: " + lightCount);
    }
}