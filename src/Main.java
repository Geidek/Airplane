import java.util.Hashtable;
import java.util.List;

public class Main {

    
    public static void main(String[] args) {

        Wing leftWing = new Wing();
        Wing rightWing = new Wing();
        String registration = "D-AIXN";
        Stabilizer horizontalStabilizer = new Stabilizer();
        Stabilizer verticalStabilizer = new Stabilizer();
        Airplane A350 = new Airplane(leftWing, rightWing, horizontalStabilizer, verticalStabilizer, registration);
        A350.setCarrier(Airplane.CARRIER.LUFTHANSA);
        CheckIn checkIn = new CheckIn();
        Hashtable<Integer, Passenger> database = checkIn.ReadPassengerList();
        checkIn.QueuePassengers(database);
        var records = checkIn.StartCheckIn(database);
        
    }
}