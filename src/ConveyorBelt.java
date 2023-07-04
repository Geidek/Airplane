import java.util.Hashtable;
import java.util.List;

public class ConveyorBelt {

    private Hashtable<BaggageTag, Baggage> storage = new Hashtable<>();
    public void AddBaggageToConveyorBelt(BaggageTag baggageTag, Baggage baggage)
    {
        storage.put(baggageTag, baggage);
    }

}
