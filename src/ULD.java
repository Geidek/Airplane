import java.util.Random;

public class ULD
{
    public ULD()
    {
        int number = random.nextInt(10000,99999);
        id = "AKE" + String.valueOf(number);
    }

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
