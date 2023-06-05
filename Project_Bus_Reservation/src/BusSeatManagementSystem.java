import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Class representing a bus
class BusSeatManagementSystem implements Bus {
    private final List<Seat> seats;
    private final Scanner scanner;
    private double totalDue;
    

    public BusSeatManagementSystem(int numSeats) {
        this.seats = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.totalDue = 0.0;

        for (int i = 0; i < numSeats; i++) {
            seats.add(new RegularSeat(i));
        }
    }

    public void showAvailableSeats() {
        System.out.println("Available seats:");
        int s = 0;
        for (Seat seat : seats) {
            if (!seat.isOccupied()) {
                System.out.print(seat.getSeatNumber() + "\t");
            } else {
                System.out.print("[*]\t");
            }
            s++;
            if(s%4==0) System.out.println();
        }
        System.out.println();
    }

    public void bookSeat(int seatNumber) {
    
        if (seatNumber >= 0 && seatNumber < seats.size()) {
            Seat seat = seats.get(seatNumber);
            if (!seat.isOccupied()) {
                seat.setOccupied(true);
                totalDue += seat.getSeatPrice();
                System.out.println("Seat " + seat.getSeatNumber() + " booked successfully.");
            } else {
                System.out.println("Seat " + seat.getSeatNumber() + " is already occupied.");
            }
        } else {
            System.out.println("Invalid seat number.");
        }
    }

    public void cancelSeat(int seatNumber) {
        if (seatNumber >= 0 && seatNumber < seats.size()) {
            Seat seat = seats.get(seatNumber);
            if (seat.isOccupied()) {
                seat.setOccupied(false);
                totalDue -= seat.getSeatPrice();
                System.out.println("Seat " + seat.getSeatNumber() + " canceled successfully.");
            } else {
                System.out.println("Seat " + seat.getSeatNumber() + " is not yet booked.");
            }
        } else {
            System.out.println("Invalid seat number.");
        }
    }

    public int getAvailableSeatCount() {
        int count = 0;
        for (Seat seat : seats) {
            if (!seat.isOccupied()) {
                count++;
            }
        }
        return count;
    }

    public void makePayment() {
        System.out.println("Total due amount: $" + getTotalDue());
        System.out.print("Enter the payment amount: $");
        double paymentAmount = scanner.nextDouble();
        if (paymentAmount >= totalDue) {
            totalDue -= paymentAmount;
            System.out.println("Congratulations! Payment successful.");
            if (totalDue == 0) {
                System.out.println("Have a safe journey!");
            } else {
                if(totalDue<0)
                System.out.println("Change: $" + abs(getTotalDue()));
                else 
                    System.out.println("Remaining: $" + abs(getTotalDue()));
            }
        } else {
            System.out.println("Insufficient payment amount.\n Payment failed.");
        }
    }

    public double getTotalDue() {
        return totalDue;
    }

    public void start() {
        int choice = 0;
        do {
            System.out.println("Bus Seat Management System");
            System.out.println("1. Show available seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Make payment");
            System.out.println("5. Total Due");
            System.out.println("6. Total available seat\n");
            System.out.println("7. Exit\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    showAvailableSeats();
                    break;
                case 2:
                    showAvailableSeats();
                    System.out.println();
                    System.out.print("Enter the seat number: ");
                    int seatToBook = scanner.nextInt();
                    bookSeat(seatToBook);
//                    System.out.println("Enter Destination :");
//                     System.out.println("1.Dhaka to Chittagong");
//                     System.out.println("1.Dhaka to Rajshahi");
//                     System.out.println("1.Dhaka to Noakhali");
//                     System.out.println("1.Dhaka to Barishal");
//                     System.out.println("1.Dhaka to Chittagong");
                    showAvailableSeats();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the seat number: ");
                    int seatToCancel = scanner.nextInt();
                    cancelSeat(seatToCancel);
                    break;
                case 4:
                    makePayment();
                    break;
                case 5:
                   double totalDue = getTotalDue();
                     if(totalDue<0)
                System.out.println("Advance Given: $" + abs(getTotalDue()));
                else 
                    System.out.println("Remaining: $" + abs(getTotalDue()));
                    break;
                    case 6:
                        System.out.println("Total available seats :" + getAvailableSeatCount() );
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 7);

        scanner.close();
    }

    
    
}
