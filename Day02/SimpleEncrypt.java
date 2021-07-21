/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 */

// import java.util.Scanner;
// import java.lang.Math;
import javax.swing.JOptionPane; // Dialogs

public class SimpleEncrypt {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Please input your 4-digit data");
        int    encryptedCode[] = new int[4], tmp;
        // Check if the input is a 4-char string.
        if (input.length() == 4){
            boolean legal = true;
            for (int i = 0; i < 4; i++){
                // Check if each of the four characters are legal digits(0-9).
                if (!isDigit(input.charAt(i))){
                    System.out.print("Error: Illegal Character.");
                    legal = false;
                    break;
                };
                // Convert char to integer.
                encryptedCode[i] = input.charAt(i) - '0';
            }
            if (legal){
                tmp = encryptedCode[1];
                encryptedCode[1] = encryptedCode[3];
                encryptedCode[3] = tmp;
                for (int i = 0; i < 4; i++){
                    encryptedCode[i] = (encryptedCode[i] + 7 % 10);
                    System.out.print(encryptedCode[i]);
                }
            }
        }
        else{
            System.out.print("Error: Wrong Input Length.");
        }
        System.out.println();
    }
    private static boolean isDigit(char d) {
        return (d >= '0' && d <= '9');
    }
}