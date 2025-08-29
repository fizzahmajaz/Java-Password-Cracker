package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    //hash a password with SHA-256

    public static String hash(String password){
        try {
            
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashByte = messageDigest.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : hashByte){
            stringBuilder.append(String.format("%02x", b));
        }

        return stringBuilder.toString();
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found");
        }
    }

    
}
