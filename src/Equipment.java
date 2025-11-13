abstract class Equipment {
    protected int equipmentId;
    protected double cost;

    public Equipment(int equipmentId, double cost) {
        this.equipmentId = equipmentId;
        this.cost = cost;
    }

    public void equipmentDetails() {
        System.out.println("Equipment ID: " + equipmentId);
        System.out.println("Cost: " + cost);
    }

    public void purchaseEquipment() {
        System.out.println("Equipment purchased with ID: " + equipmentId);
    }

    public void repair() {
        System.out.println("Equipment with ID: " + equipmentId + " has been repaired.");
    }
}