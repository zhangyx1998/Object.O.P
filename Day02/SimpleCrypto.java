/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 */

// import java.util.Scanner;
// import java.lang.Math;
import javax.swing.JOptionPane; // Dialogs

public class SimpleCrypto {
    public static String usage =
        "Usage: SimpleCrypto [command]" + 
        "\n    encrypt: converts a 4-digit original token into encrypted token" +
        "\n    decrypt: converts a 4-digit encrypted token back to original token";
    public static void main(String[] args){
        if (args.length < 1) System.out.println(usage);
        else try {
            switch (args[0]){
                case "encrypt":
                    JOptionPane.showMessageDialog(
                        // parentComponent
                        null,
                        // Message body
                        encrypt(
                            checkToken(
                                JOptionPane.showInputDialog("[Encrypt] Please input your 4-digit token")
                            )
                        ),
                        // Message title
                        "Encrypted Token",
                        // Message type
                        JOptionPane.PLAIN_MESSAGE
                    );
                    break;
                case "decrypt":
                    JOptionPane.showMessageDialog(
                        // parentComponent
                        null,
                        // Message body
                        decrypt(
                            checkToken(
                                JOptionPane.showInputDialog("[Decrypt] Please input your encrypted token")
                            )
                        ),
                        // Message title
                        "Decrypted Token",
                        // Message type
                        JOptionPane.PLAIN_MESSAGE
                    );
                    break;
                default:
                    System.out.println(usage);
            }
        }
        catch (Exception IllegalTokenException) {
            // Handle exception
            JOptionPane.showMessageDialog(
                // parentComponent
                null,
                // Message body
                IllegalTokenException,
                // Message title
                "[Error] Illegal User Input",
                // Message type
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    /**
     * Encrypts a 4-digit token by:
     * 1. Rotate each decimal digit by 7;
     * 2. Swap the 2nd and 4th digit;
     * @param token
     * @return
     */
    private static String encrypt(String token){
        int tokenIntArray[] = new int[4], tmp;
        for (int i = 0; i < 4; i++) tokenIntArray[i] = (token.charAt(i) - '0' + 7) % 10;
        tmp = tokenIntArray[1];
        tokenIntArray[1] = tokenIntArray[3];
        tokenIntArray[3] = tmp;
        return composeIntArray(tokenIntArray);
    }
    /**
     * Decrypts a 4-digit token by:
     * 1. Rotate each decimal digit by 3;
     * 2. Swap the 2nd and 4th digit;
     * @param token
     * @return
     */
    private static String decrypt(String token){
        int tokenIntArray[] = new int[4], tmp;
        for (int i = 0; i < 4; i++) tokenIntArray[i] = (token.charAt(i) - '0' + 3) % 10;
        tmp = tokenIntArray[1];
        tokenIntArray[1] = tokenIntArray[3];
        tokenIntArray[3] = tmp;
        return composeIntArray(tokenIntArray);
    }
    /**
     * Checks if the given character is a valid digit.
     * @param d     Char digit to be examined.
     * @return      Boolean, whether this digit is valid.
     */
    private static boolean isDigit(char d) {
        return (d >= '0' && d <= '9');
    }
    /**
     * Examines if user input string can be accepted as a legal 4-digit token.
     * @param token
     * @return
     */
    private static String checkToken(String token) throws IllegalTokenException{
        if (token.length() != 4)
            throw new IllegalTokenException("Token should have 4 digits.");
        for (int i = 0; i < 4; i++){
            if (!isDigit(token.charAt(i)))
                throw new IllegalTokenException("Token should contain only digits (0-9).");
        }
        return token;
    }
    /**
     * Takes an array of integers[0-9], converts them into corresponding digit characters,
     * and returns a string of concatenated char string.
     * @param Token
     * @return
     */
    private static String composeIntArray(int []Token){
        char []charToken = new char[Token.length];
        for (int i = 0; i < Token.length; i++) charToken[i] = (char)('0' + Token[i]);
        return new String(charToken);
    }
}

/**
 * This is a custom exception defined for illegal token input.
 */
class IllegalTokenException extends Exception {
    public IllegalTokenException(String message) {
        super(message);
    }
}