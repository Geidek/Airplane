

public class Main {

    
    public static void main(String[] args) {

        // Hashcode Variante 2 implementieren.


        final String secretKey = Configuration.INSTANCE.secretKey;
        String plainMessage = "";
        String encryptedString = CryptoTools.Encrypt(plainMessage, secretKey);
        String decryptedString = CryptoTools.Decrypt(encryptedString, secretKey);

        Wing leftWing = new Wing();
        Wing rightWing = new Wing();
        String registration = "D-AIXN";
        Stabilizer horizontalStabilizer = new Stabilizer();
        Stabilizer verticalStabilizer = new Stabilizer();
        Airplane A350 = new Airplane(leftWing, rightWing, horizontalStabilizer, verticalStabilizer, registration);
        A350.setCarrier(Airplane.CARRIER.LUFTHANSA);
        
    }
}