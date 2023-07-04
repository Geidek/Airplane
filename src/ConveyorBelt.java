import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConveyorBelt {

    private Queue<Baggage> storage = new ConcurrentLinkedQueue<>();
    public void AddBaggageToConveyorBelt(Baggage baggage)
    {
        storage.add(baggage);
        isConveyorBeltEmpty = false;
    }

    public Baggage GetBaggageFromConveyorBelt(){
        Baggage baggage = storage.poll();
        if (baggage==null){
            isConveyorBeltEmpty = true;
            return null;
        }
        return baggage;
    }

    public boolean isConveyorBeltEmpty() {
        return isConveyorBeltEmpty;
    }

    private boolean isConveyorBeltEmpty = true;

}
