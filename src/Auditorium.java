class Auditorium {
    private int totalSeats;
    private int seatsOccupied;
    private String eventName;
    private String eventDate;
    private String eventTime;

    public Auditorium(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seatsOccupied = 0;
        this.eventName = "None";
        this.eventDate = "N/A";
        this.eventTime = "N/A";
    }

    public void bookAuditorium(String eventName, String eventDate, String eventTime, int participants) {
        if (participants <= totalSeats) {
            this.eventName = eventName;
            this.eventDate = eventDate;
            this.eventTime = eventTime;
            this.seatsOccupied = participants;
            System.out.println("Auditorium booked for " + eventName);
        } else {
            System.out.println("Not enough seats!");
        }
    }

    public void eventDetails() {
        System.out.println("Event: " + eventName);
        System.out.println("Date: " + eventDate);
        System.out.println("Time: " + eventTime);
    }

    public void displaySeats() {
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Occupied: " + seatsOccupied);
        System.out.println("Available: " + (totalSeats - seatsOccupied));
    }
}

//Ibrahim Sarran -  451000513
