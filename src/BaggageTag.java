import java.util.UUID;

public class BaggageTag {

    public BaggageTag()
    {
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    private UUID uuid;
    
    


}
