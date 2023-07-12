package serviceLoader.impl;

import serviceLoader.Cipher;


public class CaesarCipher implements Cipher
{

    @Override
    public byte[] encrypt(byte[] source, byte[] key)
    {

        var result = new byte[source.length];
        for (int i = 0; i < source.length; i++)
            result[i] = (byte) (source[i] + key[0]);
        return result;


    }

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

    @Override
    public int strength()
    {
        return 1;
    }
}
