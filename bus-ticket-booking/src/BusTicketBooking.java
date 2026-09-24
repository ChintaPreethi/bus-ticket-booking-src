import java.util.ArrayList;
import java.util.Scanner;

public class BusTicketBooking {

    static ArrayList<Passenger> passengers = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static final int TOTAL_SEATS = 20;
    static final double TICKET_PRICE = 250.00;

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("       BUS TICKET BOOKING");
            System.out.println("================================");
            System.out.println("1. View Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View All Bookings");
            System.out.println("5. Search Booking");
            System.out.println("6. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    viewAvailableSeats();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelTicket();
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    searchBooking();
                    break;

                case 6:
                    System.out.println(
                            "Thank you for using our booking system!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    static void viewAvailableSeats() {

        System.out.println("\n========== AVAILABLE SEATS ==========");

        for (int i = 1; i <= TOTAL_SEATS; i++) {

            if (findPassenger(i) == null) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

    static void bookTicket() {

        if (passengers.size() == TOTAL_SEATS) {
            System.out.println("All seats are booked!");
            return;
        }

        viewAvailableSeats();

        System.out.print("\nEnter seat number: ");
        int seatNumber = sc.nextInt();
        sc.nextLine();

        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number!");
            return;
        }

        if (findPassenger(seatNumber) != null) {
            System.out.println("This seat is already booked!");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter passenger age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (age <= 0) {
            System.out.println("Invalid age!");
            return;
        }

        System.out.print("Enter destination: ");
        String destination = sc.nextLine();

        Passenger passenger = new Passenger(
                seatNumber,
                name,
                age,
                destination,
                TICKET_PRICE
        );

        passengers.add(passenger);

        System.out.println("\nTicket booked successfully!");

        System.out.println("Seat Number: " + seatNumber);

        System.out.printf(
                "Ticket Price: ₹%.2f%n",
                TICKET_PRICE
        );
    }

    static void cancelTicket() {

        System.out.print("Enter seat number to cancel: ");
        int seatNumber = sc.nextInt();

        Passenger passenger = findPassenger(seatNumber);

        if (passenger == null) {
            System.out.println("No booking found for this seat.");
            return;
        }

        passengers.remove(passenger);

        System.out.println(
                "Ticket cancelled successfully!"
        );
    }

    static void viewBookings() {

        if (passengers.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("\n========== ALL BOOKINGS ==========");

        for (Passenger passenger : passengers) {
            passenger.displayPassenger();
        }
    }

    static void searchBooking() {

        System.out.print("Enter seat number: ");
        int seatNumber = sc.nextInt();

        Passenger passenger = findPassenger(seatNumber);

        if (passenger == null) {
            System.out.println("No booking found.");
        } else {
            System.out.println("\nBooking Found:");
            passenger.displayPassenger();
        }
    }

    static Passenger findPassenger(int seatNumber) {

        for (Passenger passenger : passengers) {

            if (passenger.getSeatNumber() == seatNumber) {
                return passenger;
            }
        }

        return null;
    }
}