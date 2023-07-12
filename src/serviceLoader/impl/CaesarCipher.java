package serviceLoader.impl;

import serviceLoader.Cipher;


public class CaesarCipher implements Cipher
{

    /**
     * <description>
     *     encrypts array of byte
     * </description>
     * @param source Source array to encrypt
     * @param key Key for encryption
     * @return Encrypted source
     */
    @Override
    public byte[] encrypt(byte[] source, byte[] key)
    {

        var result = new byte[source.length];
        for (int i = 0; i < source.length; i++)
            result[i] = (byte) (source[i] + key[0]);
        return result;


    }

    /**
     * <description>
     *      Decrypts array of byte
     * </description>
     * @param source Source array to decrypt
     * @param key Key which was used for encryption
     * @return Decrypted source
     */
    @Override
    public byte[] decrypt(byte[] source, byte[] key)
    {
        // Instead of this
//        var result = new byte[source.length];
//        for (int i = 0; i < source.length)
//            result[i] = (byte) (source[i] - key[0]);
//        return result;
        return encrypt(source, new byte[]{ (byte) (-key[0]) }); // This is better. Avoid complexity.
    }

    /**
     * Determines the "strength" of the algorithm
     * @return Strength value, positive
     */
    @Override
    public int strength()
    {
        return 1;
    }
}
