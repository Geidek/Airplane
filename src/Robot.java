import java.util.Queue;

public class Robot {

    private ConveyorBelt conveyorBelt;
    private Queue<ULD> storageForFilledULDs;
    Queue<ULD> storageForEmptyULDs;
    private ULD actualULD;

    public Robot(Queue<ULD> storageForEmptyULDs, Queue<ULD> storageForFilledULDs, ConveyorBelt conveyorBelt) {
        this.storageForEmptyULDs = storageForEmptyULDs;
        this.storageForFilledULDs = storageForFilledULDs;
        this.conveyorBelt = conveyorBelt;
        this.actualULD = storageForEmptyULDs.poll();
    }

    private boolean added = false;


    public void AddBaggageToULD() {
        Baggage baggage = conveyorBelt.GetBaggageFromConveyorBelt();
        if (baggage != null) {
            added = actualULD.AddBaggageToUldContent(baggage);
        }
        if (!added && baggage != null) {
            AddULDToStorageForFilledULDs(actualULD);
            actualULD = storageForEmptyULDs.poll();
            added = actualULD.AddBaggageToUldContent(baggage);
        }


    }

    private void AddULDToStorageForFilledULDs(ULD actualULD) {
        storageForFilledULDs.add(actualULD);
    }


}
