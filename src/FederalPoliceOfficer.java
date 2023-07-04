import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class FederalPoliceOfficer {

    public List<Passenger> getArrestedPassengers() {
        return arrestedPassengers;
    }

    public void setArrestedPassengers(List<Passenger> arrestedPassengers) {
        this.arrestedPassengers = arrestedPassengers;
    }

    private List<Passenger> arrestedPassengers = new LinkedList<Passenger>();
    private Hashtable<Passenger, List<Baggage>> confiscatedBaggage = new Hashtable<>() ;
    
    public void ArrestPassenger(Passenger passenger){
        arrestedPassengers.add(passenger);
        confiscatedBaggage.put(passenger, passenger.getBaggageList());
        passenger.setBaggageList(new LinkedList<Baggage>());
    }
    
}
