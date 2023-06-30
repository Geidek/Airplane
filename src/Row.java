import java.util.ArrayList;
import java.util.List;

public class Row {

    private final String[] seatCharBusiness =  {"A", "C", "D", "G", "H", "K"};
    private final String[] seatCharPremiumEconomy = {"A", "C", "D", "E", "G", "H", "K"};
    private final String[] seatCharEconomy = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"};
    private final String[] seatCharEconomy16or42 = {"A", "C", "D", "E", "G"};
    private final String[] seatCharEconomy27 = {"B", "C", "D", "E", "G", "H", "J"};
    

    private final BookingClass bookingClass;


    private final int rowNumber;
    private final List<Seat> seats = new ArrayList<Seat>();

    public Row(BookingClass bookingClass, int rowNumber) {
        this.bookingClass = bookingClass;
        this.rowNumber = rowNumber;

        if (this.bookingClass == BookingClass.BUSINESS)
        {
            for (String seatChar : seatCharBusiness) {
                AddSeatToList(seatChar, rowNumber, bookingClass);
            }
        } else if (this.bookingClass == BookingClass.PREMIUM_ECONOMY) {
            for (String seatChar : seatCharPremiumEconomy){
                AddSeatToList(seatChar, rowNumber, bookingClass);
            }
        } else if (this.bookingClass == BookingClass.ECONOMY && (this.rowNumber == 16 || this.rowNumber == 42)) {
            for (String seatChar : seatCharEconomy16or42){
                AddSeatToList(seatChar, rowNumber, bookingClass);
            }
        }else if (this.bookingClass == BookingClass.ECONOMY && this.rowNumber == 27){
            for (String seatChar : seatCharEconomy27){
                AddSeatToList(seatChar, rowNumber, bookingClass);
            }
        }else {
            for (String seatChar : seatCharEconomy) {
                AddSeatToList(seatChar, rowNumber, bookingClass);
            }

        }
    }

    private void AddSeatToList(String seatChar, int rowNumber, BookingClass bookingClass){
        seats.add(new Seat(seatChar, rowNumber, bookingClass));
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public int getRowNumber() {
        return rowNumber;
    }
}
