package Cipher;

import java.util.*;
import java.io.*;

public class Client {
    // public static final Cipher.Cipher CHOSEN_CIPHER = null;
//     public static final Cipher.Cipher CHOSEN_CIPHER = new Cipher.CaesarShift(4);
    public static final Cipher CHOSEN_CIPHER = new Substitution("JRKAWPCNIQMTGZFVOLYDESUXHB");
    // public static final Cipher.Cipher CHOSEN_CIPHER = new Cipher.CaesarKey("BAG");
    // public static final Cipher.Cipher CHOSEN_CIPHER = new Cipher.MultiCipher(List.of(
    //     new Cipher.CaesarShift(4), new Cipher.CaesarKey("123"),
    //     new Cipher.CaesarShift(12), new Cipher.CaesarKey("lemon")));

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the CSE 123 cryptography application!");
        System.out.println("What would you like to do?");
        int chosen = -1;
        do {
            System.out.println();
            System.out.println("(1) Encode / (2) Decode a string");
            System.out.println("(3) Encode / (4) Decode a file");
            System.out.println("(5) Quit");
            System.out.print("Enter your choice here: ");
            
            chosen = Integer.parseInt(console.nextLine());
            while (chosen < 1 || chosen > 5) {
                System.out.print("Please enter a valid option from above: ");
                chosen = Integer.parseInt(console.nextLine());
            }

            if (chosen == 1 || chosen == 2) {
                System.out.println("Please enter the string you'd like to " +
                                    (chosen == 1 ? "encode" : "decode") + ": ");
                String input = console.nextLine();
                System.out.println(chosen == 1 ? CHOSEN_CIPHER.encrypt(input) :
                                                 CHOSEN_CIPHER.decrypt(input));
            } else if (chosen == 3 || chosen == 4) {
                System.out.print("Please enter the name of the file you'd like to " +
                                    (chosen == 3 ? "encode" : "decode") + ": ");
                String fileName = console.nextLine();
                if (chosen == 3) {
                    CHOSEN_CIPHER.encryptFile(fileName);
                } else {
                    CHOSEN_CIPHER.decryptFile(fileName);
                }      
            }
        } while (chosen != 5);
    }
}
