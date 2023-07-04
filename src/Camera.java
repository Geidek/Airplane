import java.util.Hashtable;

public class Camera {


    public boolean IrisScan(Hashtable<Integer, Passenger> database, Passenger passenger)
    {
        Passenger passengerFromDatabase = database.get(passenger.getNumber());
        return passengerFromDatabase.getIris().contentEquals(passenger.getIris());
    }



}
