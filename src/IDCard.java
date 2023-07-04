import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class IDCard {
    public IDCard() {
        serialNumber = UUID.randomUUID();
        magneticStrip = CryptoTools.Encrypt(pin, Configuration.INSTANCE.secretKey);
    }


    public UUID getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(UUID serialNumber) {
        this.serialNumber = serialNumber;
    }

    private UUID serialNumber;

    public String getMagneticStrip() {
        return magneticStrip;
    }

    public void setMagneticStrip(String magneticStrip) {
        this.magneticStrip = magneticStrip;
    }

    private String magneticStrip;

    public String getPin() {
        return pin;
    }

    private final String pin = Integer.toString(ThreadLocalRandom.current().nextInt(1000, 10000));


}
