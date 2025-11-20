class ClassEquipment extends Equipment {
    private int classId;
    private int benchCount;
    private int fanCount;
    private int lightCount;

    public ClassEquipment(int equipmentId, double cost, int classId, int benchCount, int fanCount, int lightCount) {
        super(equipmentId, cost);
        this.classId = classId;
        this.benchCount = benchCount;
        this.fanCount = fanCount;
        this.lightCount = lightCount;
    }

    @Override
    public void equipmentDetails() {
        super.equipmentDetails();
        System.out.println("Class ID: " + classId);
        System.out.println("Bench Count: " + benchCount);
        System.out.println("Fan Count: " + fanCount);
        System.out.println("Light Count: " + lightCount);
    }
}
//Taher Ramzi - 451000573