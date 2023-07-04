import java.util.LinkedList;
import java.util.List;

public class BoardingPass extends Document {

    public BoardingPass(String documentType, String id) {
        super(documentType, id);
        this.baggageTags = new LinkedList<BaggageTag>();
    }

    private List<BaggageTag> baggageTags;

    public List<BaggageTag> getBaggageTags() {
        return baggageTags;
    }

    public void AddBaggageTagToBoardingPass(BaggageTag baggageTag) {
        baggageTags.add(baggageTag);
    }



}
