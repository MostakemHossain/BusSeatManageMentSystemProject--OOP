
import java.util.ArrayList;
import java.util.List;

class RegularSeat extends Seat {

    private int seatPrice;

    public RegularSeat(int seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getSeatPrice() {
        return 50.0; // Assuming fixed price for regular seats
    }

    @Override
    public String getSeatType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setSeatPrice(double pricee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 

   
}
