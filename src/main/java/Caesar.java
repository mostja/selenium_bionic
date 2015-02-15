/**
 * Created by Anastasiia Khalash on 08-Feb-15.
 */
public class Caesar {
    final static int ENGLISH_ALPHABET_SIZE = 'z' - 'a' + 1;
    public static void main(String[] args) {
        String original = "Bionic University:)";
        int key = 35;
        String encrypted = encrypt(original, key);
        String decrypted = decrypt(encrypted, key);
        System.out.println(encrypted);
        System.out.println(decrypted);
    }

    private static String encrypt (String toEncrypt, int key){
        if(key < 0)
        {
            throw new IllegalArgumentException("Key should be a non negative integer.");
        }
        char[] encrypted = toEncrypt.toCharArray();
        for (int i = 0; i< encrypted.length; i++){
            encrypted[i]= cyclicShift(encrypted[i], key);
        }
        return new String(encrypted);
    }
    private static String decrypt(String toDecrypt, int key){
        if(key < 0)
        {
            throw new IllegalArgumentException("Key should be a non negative integer.");
        }
        return encrypt(toDecrypt, ENGLISH_ALPHABET_SIZE -key% ENGLISH_ALPHABET_SIZE);
    }

    private static char cyclicShift (char given, int key){
        char lowerCaseFirst = 'a';
        char lowerCaseLast = 'z';
        char upperCaseFirst = 'A';
        char upperCaseLast = 'Z';
        if (given >= upperCaseFirst && given <= upperCaseLast){
            return (char)((given-upperCaseFirst+key)% ENGLISH_ALPHABET_SIZE + upperCaseFirst);
        }
        else if (given >= lowerCaseFirst && given <= lowerCaseLast){
            return (char)((given-lowerCaseFirst+key)% ENGLISH_ALPHABET_SIZE + lowerCaseFirst);
        }
        else {
            return given;
        }
    }
}
