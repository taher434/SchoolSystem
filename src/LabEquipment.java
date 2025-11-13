class LabEquipment extends Equipment {
    private String equipmentName;
    private int equipmentCount;

    public LabEquipment(int equipmentId, double cost, String equipmentName, int equipmentCount) {
        super(equipmentId, cost);
        this.equipmentName = equipmentName;
        this.equipmentCount = equipmentCount;
    }

    @Override
    public void equipmentDetails() {
        super.equipmentDetails();
        System.out.println("Equipment Name: " + equipmentName);
        System.out.println("Equipment Count: " + equipmentCount);
    }
}