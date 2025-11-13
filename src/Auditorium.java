import java.util.ArrayList;

class Auditorium {
    private int totalSeats;
    private int seatsOccupied;
    private ArrayList<String> events;

    public Auditorium(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seatsOccupied = 0;
        this.events = new ArrayList<>();
    }

    public void bookAuditorium(String eventName, String eventDate, String eventTime, int participants) {
        if (participants <= (totalSeats - seatsOccupied)) {
            this.events.add("Event: " + eventName + ", Date: " + eventDate + ", Time: " + eventTime);
            seatsOccupied += participants;
            System.out.println("Auditorium booked successfully!");
        } else {
            System.out.println("Not enough seats available!");
        }
    }

    public void eventDetails() {
        if (events.isEmpty()) {
            System.out.println("No events booked.");
        } else {
            System.out.println("Events Booked:");
            for (String event : events) {
                System.out.println(event);
            }
        }
    }

    public void displaySeats() {
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Seats Occupied: " + seatsOccupied);
    }
}