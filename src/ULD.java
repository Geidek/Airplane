import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class ULD
{
    public ULD()
    {
        int lowNumber = 10000;
        int highNumber = 99999;
        int number = random.nextInt(highNumber- lowNumber+1) + lowNumber;
        id = "AKE" + String.valueOf(number);
    }

    public Deque<Baggage> getUldContent() {
        return uldContent;
    }

    public boolean AddBaggageToUldContent(Baggage baggage) {
        if(uldContent.size()<40) {
            uldContent.add(baggage);
            return true;
        }
        else return false;

    }

    private Deque<Baggage> uldContent = new ArrayDeque<>(40);


    private String id;
    private Random random = new Random();

    private final int volume = 150;
    private final int tareWeight = 72;
    private final String externalDimensions = "79\" x 43\" x 64\" x 61.5\" x 60.4\"";

    public String getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public int getTareWeight() {
        return tareWeight;
    }

    public String getExternalDimensions() {
        return externalDimensions;
    }




}
