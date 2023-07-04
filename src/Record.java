import java.time.LocalDateTime;

public class Record {

    public Record(String bookingId, String passengerName, String flight, String destination, int countCheckedBaggage, String result){
        timeStamp = LocalDateTime.now();
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flight = flight;
        this.destination = destination;
        this.countCheckedBaggage = countCheckedBaggage;
        this.result = result;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCountCheckedBaggage() {
        return countCheckedBaggage;
    }

    public void setCountCheckedBaggage(int countCheckedBaggage) {
        this.countCheckedBaggage = countCheckedBaggage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    private final LocalDateTime timeStamp;
    private String bookingId;
    private String passengerName;
    private String flight;
    private String destination;
    private int countCheckedBaggage;
    private String result;
}
