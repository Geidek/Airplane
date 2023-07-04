import java.util.LinkedList;
import java.util.List;

public class Passenger extends Human
{
    public Passenger(){
        super();
        this.smartphone = new Smartphone();
        //Todo: hier weiter machen!
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result;
    private String role;
    private String bookingID;
    private String flight;
    private String from;
    private String to;
    private String departure;
    private String arrival;
    private BookingClass bookingClass;
    private String seatAsString;
    private int countCheckedBaggage;

    public void setBaggageList(List<Baggage> baggageList) {
        this.baggageList = baggageList;
    }

    private List<Baggage> baggageList = new LinkedList<Baggage>();
    private boolean warrant;
    private Smartphone smartphone;
    private Passport passport;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

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

    public void AddBaggageToConveyorBelt(ConveyorBelt conveyorBelt){
        for(Baggage baggage : baggageList){
            BaggageTag baggageTag = new BaggageTag();
            baggage.setBaggageTag(baggageTag);
            var documents = smartphone.getWallet().getDocuments();

            for (Document document : documents)
            {
                if(document.getDocumentType().equalsIgnoreCase("Boardingpass")){
                    BoardingPass boardingPass = (BoardingPass) document;
                    boardingPass.AddBaggageTagToBoardingPass(baggageTag);
                }
            }

            conveyorBelt.AddBaggageToConveyorBelt(baggageTag, baggage);
        }
    }


}
