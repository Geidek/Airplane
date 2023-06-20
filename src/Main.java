public class Main {
    public static void main(String[] args) {

        //Hashcode Variante 2 implementieren.

        Wing leftWing = new Wing();
        Wing rightWing = new Wing();
        String registration = "D-AIXN";
        Stabilizer horizontalStabilizer = new Stabilizer();
        Stabilizer verticalStabilizer = new Stabilizer();
        Airplane A350 = new Airplane(leftWing, rightWing, horizontalStabilizer, verticalStabilizer, registration);
        A350.setCarrier(Airplane.CARRIER.LUFTHANSA);
    }
}