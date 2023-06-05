
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Abstract class representing a seat

abstract class Seat {
   

    private final int seatNumber;
    private boolean isOccupied;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public abstract String getSeatType();

    public abstract double getSeatPrice(); 
    public abstract void setSeatPrice(double pricee);
    
}
