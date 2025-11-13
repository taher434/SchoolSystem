class Playground {
    private int area;
    private boolean isOccupied;

    public Playground(int area) {
        this.area = area;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupyPlayground() {
        if (!isOccupied) {
            isOccupied = true;
            System.out.println("Playground is now occupied.");
        } else {
            System.out.println("Playground is already occupied.");
        }
    }

    public void releasePlayground() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("Playground is now free.");
        } else {
            System.out.println("Playground is already free.");
        }
    }
}