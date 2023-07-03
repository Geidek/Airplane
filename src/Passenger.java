import java.util.LinkedList;
import java.util.List;

public class Passenger 
{
    public Passenger(){
        this.smartphone = new Smartphone();
        this.passport = new Passport();
    }

    private String name;
    private String role;
    private String gender;
    private String dateOfBirth;
    private String fingerprint;
    private String bookingID;
    private String flight;
    private String from;
    private String to;
    private String departure;
    private String arrival;
    private BookingClass bookingClass;
    private String seatAsString;
    private int countCheckedBaggage;
    private List<Baggage> baggageList = new LinkedList<Baggage>();
    private boolean warrant;
    private Smartphone smartphone;
    private Passport passport;
    private String passportId;
    private String iris;    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isWarrant() {
        return warrant;
    }

    public void setWarrant(boolean warrant) {
        this.warrant = warrant;
    }


    public List<Baggage> getBaggageList() {
        return baggageList;
    }

    public void AddBaggage(Baggage baggage) {
        baggageList.add(baggage);
    }



    public int getCountCheckedBaggage() {
        return countCheckedBaggage;
    }

    public void setCountCheckedBaggage(int countCheckedBaggage) {
        this.countCheckedBaggage = countCheckedBaggage;
    }

    public String getSeatAsString() {
        return seatAsString;
    }

    public void setSeatAsString(String seatAsString) {
        this.seatAsString = seatAsString;
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(BookingClass bookingClass) {
        this.bookingClass = bookingClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }



    public String getIris() {
        return iris;
    }

    public void setIris(String iris) {
        this.iris = iris;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }



    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }


}
