import serviceLoader.Cipher;

import java.util.Arrays;
import java.util.Objects;
import java.util.ServiceLoader;

/**
 * <description>
 *     This program demonstrates how service loaders work
 * </description>
 * @author Konstantine Vashlomidze
 * @version 0.0.1  12-07-2023
 */


public class Main {
    public static ServiceLoader<Cipher> cipherLoader = ServiceLoader.load(Cipher.class);

    public static void main(String[] args)
    {
        // Creates CaesarCipher
        Cipher cipher = getCipher(1);
        // Test
        byte[] toEncrypt = { 12, 54, 12, 33, 65, 3, 34 };
        byte[] key = { 23, 34, 56, 11, -43 };

        // Encrypted version
        var encrypted = cipher.encrypt(toEncrypt, key);
        // Decrypted version
        var decrypted = cipher.decrypt(encrypted, key);

        // Print results
        System.out.print("Non encrypted: ");
        System.out.println(Arrays.toString(toEncrypt));
        System.out.print("Encrypted: ");
        System.out.println(Arrays.toString(encrypted));
        System.out.print("Decrypted: ");
        System.out.println(Arrays.toString(decrypted));
    }

    public static Cipher getCipher(int minStrength)
    {
        // Find desired encryption algorithm, with minimal competence strength
        for (Cipher cipher: cipherLoader) // Implicitly calls cipherLoader.iterator()
        {
            if (cipher.strength() >= minStrength) return cipher;
        }
        return null;
    }

}