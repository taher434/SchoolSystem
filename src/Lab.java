class Lab {
    private int labId;
    private int inchargeId;
    private String labName;
    private int equipmentId;

    public Lab(int labId, int inchargeId, String labName, int equipmentId) {
        this.labId = labId;
        this.inchargeId = inchargeId;
        this.labName = labName;
        this.equipmentId = equipmentId;
    }

    public void labDetails() {
        System.out.println("Lab ID: " + labId);
        System.out.println("Lab Name: " + labName);
        System.out.println("Incharge ID: " + inchargeId);
        System.out.println("Equipment ID: " + equipmentId);
    }

    public boolean isOccupied() {
        return false; 
    }

    public void payFine() {
        System.out.println("Fine details processed for Lab: " + labName);
    }
}
//Develop by Ibrahim Sarran 451000513
