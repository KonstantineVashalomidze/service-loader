package serviceLoader;

/**
 * @author Konstantine Vashalomidze
 * <description>
 *     Interface to group different cipher algorithms together
 * </description>
 */
public interface Cipher {
    /**
     * <description>
     *     encrypts array of byte
     * </description>
     * @param source Source array to encrypt
     * @param key Key for encryption
     * @return Encrypted source
     */
    byte[] encrypt(byte[] source, byte[] key);

    /**
     * <description>
     *      Decrypts array of byte
     * </description>
     * @param source Source array to decrypt
     * @param key Key which was used for encryption
     * @return Decrypted source
     */
    byte[] decrypt(byte[] source, byte[] key);

    /**
     * Determines the "strength" of the algorithm
     * @return Strength value, always positive
     */
    int strength();
}
