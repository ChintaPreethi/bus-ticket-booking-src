public class Passenger {

    private int seatNumber;
    private String name;
    private int age;
    private String destination;
    private double ticketPrice;

    public Passenger(int seatNumber, String name, int age,
                     String destination, double ticketPrice) {

        this.seatNumber = seatNumber;
        this.name = name;
        this.age = age;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void displayPassenger() {

        System.out.println("--------------------------------");
        System.out.println("Seat Number : " + seatNumber);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Destination : " + destination);

        System.out.printf(
                "Ticket Price: ₹%.2f%n",
                ticketPrice
        );

        System.out.println("--------------------------------");
    }
}