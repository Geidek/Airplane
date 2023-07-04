public class Baggage {
    private double weight;

    public BaggageTag getBaggageTag() {
        return baggageTag;
    }

    public void setBaggageTag(BaggageTag baggageTag) {
        this.baggageTag = baggageTag;
    }

    private BaggageTag baggageTag;


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public Baggage(double weight){

        this.weight = weight;

    }
}
