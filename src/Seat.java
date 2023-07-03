public class Seat
{
    public Seat(String seatChar, int rowNumber, BookingClass bookingClass)
        {
             this.rowNumber = rowNumber;
             this.seatChar = seatChar;
             this.bookingClass = bookingClass;

             if (bookingClass == BookingClass.BUSINESS)
             {
                 this.pitch = 162;
                 this.width = 52;
             }else if (bookingClass == BookingClass.PREMIUM_ECONOMY){
                 this.pitch = 96;
                 this.width = 50;
             }else {
                 this.pitch = 96;
                 this.width = 38;
             }

        }

    private final int pitch;
    private final int width;
    private Passenger passenger;
    private final String seatChar;
    private final int rowNumber;
    private final BookingClass bookingClass;
    
    public String getSeatAsString(){
        return rowNumber + seatChar;
    }

    public int getPitch() {
        return pitch;
    }

    public int getWidth() {
        return width;
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }



    public String getSeatChar() {
        return seatChar;
    }
    public int getRowNumber() {
        return rowNumber;
    }


    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }




}
