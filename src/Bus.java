class Bus {
    private int busId;
    private int driverId; 
    private String areaList;
    private String busNumber;
    private int capacity;

    public Bus(int busId, int driverId, String areaList, String busNumber, int capacity) {
        this.busId = busId;
        this.driverId = driverId;
        this.areaList = areaList;
        this.busNumber = busNumber;
        this.capacity = capacity;
    }

    public void busDetails() {
        System.out.println("Bus ID: " + busId);
        System.out.println("Bus Number: " + busNumber);
        System.out.println("Driver ID: " + driverId);
        System.out.println("Areas: " + areaList);
        System.out.println("Capacity: " + capacity);
    }

    public void showSeats() {
        System.out.println("Total seats: " + capacity);
        System.out.println("Available: " + (capacity)); 
    }
}