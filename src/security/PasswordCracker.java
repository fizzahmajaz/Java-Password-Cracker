package security;

import java.util.List;
import java.util.ArrayList;

public class PasswordCracker {

    // Dictonary attack

    public static boolean dictonaryAttack(String targetHash, List<String> dictonary) {
        int attempts = 0;
        for (String word : dictonary) {
            attempts++;
            if (PasswordHasher.hash(word).equals(targetHash)) {
                System.out.println("Pssword found: " + word + "(Attempts: " + attempts + ")");
                return true;
            }
        }
        System.out.println("Password not found after " + attempts + " attempts");
        return false;

    }

    // Brute-force Attack (Simplified: a-z only, max length 3)
    public static boolean bruteForceAttack(String targetHash){
        char[] chars = "abcdefghijklmnopqrstuvwxyz" .toCharArray();
        int attempts = 0;

        for(char c1 : chars) {
            attempts++;
            if(PasswordHasher.hash("" + c1).equals(targetHash)){
                System.out.println("Password found: " + c1 + " (Attempts: " + attempts + ")");
                return true;
            }

            for(char c2 : chars) {
            attempts++;
            if(PasswordHasher.hash("" + c1 + c2).equals(targetHash)){
                System.out.println("Password found: " + c1 + c2 + " (Attempts: " + attempts + ")");
                return true;
            }

            for(char c3 : chars) {
            attempts++;
            if(PasswordHasher.hash("" + c1 + c2 + c3).equals(targetHash)){
                System.out.println("Password found: " + c1 + c2 + c3 + " (Attempts: " + attempts + ")");
                return true;
            }

        }
            
        }

        }

        }

            

            
    }

}}
