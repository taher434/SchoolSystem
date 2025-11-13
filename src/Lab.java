import java.util.ArrayList;

class Lab {
    private String labName;
    private int labEquipmentCount;
    private ArrayList<String> labEquipment;
    private int benchCount;
    private int fanCount;
    private int lightCount;

    public Lab(String labName, int labEquipmentCount, ArrayList<String> labEquipment, int benchCount, int fanCount, int lightCount) {
        this.labName = labName;
        this.labEquipmentCount = labEquipmentCount;
        this.labEquipment = labEquipment;
        this.benchCount = benchCount;
        this.fanCount = fanCount;
        this.lightCount = lightCount;
    }

    public void labDetails() {
        System.out.println("Lab Name: " + labName);
        System.out.println("Lab Equipment Count : " + labEquipmentCount);
        for (String equipment : labEquipment) {
            System.out.println("Equipment: " + equipment);
        }
        System.out.println("Bench Count: " + benchCount);
        System.out.println("Fan Count: " + fanCount);
        System.out.println("Light Count: " + lightCount);
    }

    public boolean isOccupied() {
        // For demonstration purposes, returning false
        return false;
    }

    public void payFine(int studentId, double amount) {
        System.out.println("Student with ID: " + studentId + " has paid a fine of: " + amount);
    }
}
//Develop by Ibrahim Sarran and his uncle taher 
