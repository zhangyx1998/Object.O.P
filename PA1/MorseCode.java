/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 * ----------------------------------------
 * Task: Decode and *encode morse code.
 * ----------------------------------------
 * [*] optional
 * ----------------------------------------
 * Test command (bash):
 * $> echo hello,world test.123 | java MorseCode.java encode | java MorseCode.java decode
 */

import java.util.Scanner;

public class MorseCode {
    final public static String USAGE =
    "Morse Code Utility. Usage: MorseCode <command>\n" + 
    "    commands:\n" + 
    "      encode    Encode the given string of text, illegal character will be skipped.\n" + 
    "      decode    Decode the given string of morse code, unknown code will be skipped.";
    final public static String []codeSet = 
    ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. .---- ..--- ...-- ....- ..... -.... --... ---.. ----. ----- .-.-.- --..--"
    .split(" ");
    final public static String charSet = 
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (args.length < 1)
            System.out.print(USAGE);
        else
            switch (args[0]){
                case "encode":
                    morseEncode(sc.nextLine());
                    break;
                case "decode":
                    morseDecode(sc.nextLine());
                    break;
                default:
                    System.out.print(USAGE);
            }
        System.out.println();
        sc.close();
    }

    public static void morseDecode(String input){
        boolean firstWord = true;
        for (String word:input.split("   ")){
            if (!firstWord)
                System.out.print(" ");
            else
                firstWord = false;
            for (String letter:word.split(" ")){
                int i = 0;
                while (!letter.equals(codeSet[i]) && ++i < codeSet.length);
                if (i < codeSet.length) System.out.print(charSet.charAt(i));
            }
        }
    }

    public static void morseEncode(String input){
        boolean firstWord = true;
        for (int i = 0; i < input.length(); i++){
            char letter = input.charAt(i);
            if (letter == ' '){
                System.out.print("   ");
                firstWord = false;
            } else {
                int index = charSet.indexOf(Character.toUpperCase(letter));
                if (index >= 0){
                    if (!firstWord) System.out.print(" ");
                    System.out.print(codeSet[index]);
                    firstWord = false;
                }
            }
        }
    }
}
