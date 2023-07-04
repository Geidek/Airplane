import java.util.Hashtable;

public class PassportScanner implements Scanner {



    @Override
    public boolean Scan(Hashtable<Integer, Passenger> database, Passenger passenger) {
        Passenger passengerFromDatabase = database.get(passenger.getNumber());
        return passengerFromDatabase.getPassport().getId().contentEquals(passenger.getPassport().getId());

    }
}
