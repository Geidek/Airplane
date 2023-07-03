import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoTools {

private static SecretKeySpec secretKey;

private static void SetKey(String string)
{
    MessageDigest messageDigest;

    try {
        byte[] key = string.getBytes(StandardCharsets.UTF_8);
        messageDigest = MessageDigest.getInstance("SHA-1");
        key = messageDigest.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
    } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
    }
}

public static String Encrypt(String plainMessage, String secretKey) {
        try {
            SetKey(secretKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, CryptoTools.secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(plainMessage.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("error : " + e);
        }

        return null;
    }
}

public static String Decrypt(String cipher, String secretKey) {
        try {
            SetKey(secretKey);
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            instance.init(Cipher.DECRYPT_MODE, CryptoTools.secretKey);
            return new String(instance.doFinal(Base64.getDecoder().decode(cipher)));
        } catch (Exception e) {
            System.out.println("error : " + e);
        }

        return null;
    }
