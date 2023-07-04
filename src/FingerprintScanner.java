import java.util.Hashtable;

public class FingerprintScanner implements Scanner {


    @Override
    public boolean Scan(Hashtable<Integer, Passenger> database, Passenger passenger) {
        Passenger passengerFromDatabase = database.get(passenger.getNumber());
        return passengerFromDatabase.getFingerprint().contentEquals(passenger.getFingerprint());
    }



}
