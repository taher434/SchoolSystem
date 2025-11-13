class Bus {
    private int busId;
    private String driverName;
    private String areaList;
    private String busNumber;
    private int capacity;

    public Bus(int busId, String driverName, String areaList, String busNumber, int capacity) {
        this.busId = busId;
        this.driverName = driverName;
        this.areaList = areaList;
        this.busNumber = busNumber;
        this.capacity = capacity;
    }

    public void busDetails() {
        System.out.println("Bus ID: " + busId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Areas Covered: " + areaList);
        System.out.println("Bus Number: " + busNumber);
        System.out.println("Capacity: " + capacity);
    }

    public void showSeats() {
        System.out.println("Total seats in bus #" + busNumber + ": " + capacity);
        // طاهر عم ابراهيم
        System.out.println("Available seats: " + (capacity / 2));
        System.out.println("Occupied seats: " + (capacity - capacity / 2));
    }
}