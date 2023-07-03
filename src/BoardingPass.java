import java.util.LinkedList;
import java.util.List;

public class BoardingPass extends Document {

    public BoardingPass(String documentType) {
        super(documentType);
        this.baggages = new LinkedList<BaggageTag>();
    }

    private List<BaggageTag> baggages;

    public List<BaggageTag> getBaggages() {
        return baggages;
    }

    public void AddBaggageTagToBoardingPass(BaggageTag baggageTag) {
        baggages.add(baggageTag);
    }



}
