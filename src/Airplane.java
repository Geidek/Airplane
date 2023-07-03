import java.util.UUID;


public class Airplane {

    public Airplane(Wing leftWing, Wing rightWing, Stabilizer horizontalStabilizer, Stabilizer verticalStabilizer, String registration)
    {
        body = new Body();
        this.rightWing = rightWing;
        this.rightWing.setPosition(Wing.POSITION.RIGHT);
        this.leftWing = leftWing;
        this.leftWing.setPosition(Wing.POSITION.LEFT);
        this.registration = registration;
        this.serialNumber = UUID.randomUUID();
        this.actualSpeedInMach = 0;
    }

    private final Body body;
    private Wing leftWing;
    private Wing rightWing;
    private final String registration;

    private Stabilizer HorizontalStabilizer;
    private Stabilizer VerticalStabilizer;
    private final UUID serialNumber;
    private final double length = 66.89;
    private final double wingSpan = 64.75;
    private final double height = 17.05;
    private final int maximumRangeInKm = 15372;
    private final double cruiseSpeedInMach = 0.85;
    private final double maximumOperatingSpeedInMach = 0.89;

    private double actualSpeedInMach;
    public double getActualSpeedInMach() {
        return actualSpeedInMach;
    }

    public void setActualSpeedInMach(double speed) {
        if (speed <= maximumOperatingSpeedInMach)
        this.actualSpeedInMach = speed;
        else 
        this.actualSpeedInMach = maximumOperatingSpeedInMach;
    }

    private CARRIER carrier;

    public Body getBody() {
        return body;
    }

    public Stabilizer getHorizontalStabilizer() {
        return HorizontalStabilizer;
    }

    public Stabilizer getVerticalStabilizer() {
        return VerticalStabilizer;
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }

    public double getLength() {
        return length;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public double getHeight() {
        return height;
    }

    public double getCruiseSpeedInMach() {
        return cruiseSpeedInMach;
    }

    public double getMaximumOperatingSpeedInMach() {
        return maximumOperatingSpeedInMach;
    }

    public String getRegistration() {
        return registration;
    }

    public int getMaximumRangeInKm() {
        return maximumRangeInKm;
    }

    public CARRIER getCarrier() {
        return carrier;
    }

    public void setCarrier(CARRIER carrier) {
        this.carrier = carrier;
    }


    enum CARRIER {
        CATHAY_PACIFIC,
        EMIRATES,
        LUFTHANSA,
        QATAR_AIRWAYS

    }


}
