class Playground {
    private int area;
    private int classId; 
    

    public Playground(int area) {
        this.area = area;
        this.classId = 0; 
    }

    public boolean isOccupied() {
        return classId != 0;
    }

    
}