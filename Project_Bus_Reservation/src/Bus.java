
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Interface for bus operations

interface Bus {

    void showAvailableSeats();

    void bookSeat(int seatNumber);

    void cancelSeat(int seatNumber);

    int getAvailableSeatCount();

    void makePayment();

    double getTotalDue();
    
}
