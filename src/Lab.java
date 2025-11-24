class Lab {
    private int labId;
    private int inchargeId;
    private String labName;

    private LabEquipment labEquipment;

    public Lab(int labId, int inchargeId, String labName, int equipmentId, double cost, String equipmentName, int equipmentCount) {
        this.labId = labId;
        this.inchargeId = inchargeId;
        this.labName = labName;
        this.labEquipment = new LabEquipment(equipmentId, cost, equipmentName, equipmentCount);
    }

    public void labDetails() {
        System.out.println("--- Lab Details ---");
        System.out.println("Lab ID: " + labId);
        System.out.println("Lab Name: " + labName);
        System.out.println("Incharge ID: " + inchargeId);
        this.labEquipment.equipmentDetails();
    }

    public boolean isOccupied() {
        return false;
    }

    public void payFine() {
        System.out.println("Fine details processed for Lab: " + labName);
    }
}
//Develop by Ibrahim Sarran 451000513