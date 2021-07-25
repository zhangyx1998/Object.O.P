/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 */

import java.io.*;
import java.util.Scanner;

public class PigLatin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.length() == 0)
                break;
            int i = 0, j = 0;
            while (i < str.length() && j < str.length()){
                if (i == j && str.charAt(i) == ' '){
                    // If i and j are pointing to a whitespace
                    System.out.print(' ');
                    j = ++i;
                } else if (j < str.length() - 1 && str.charAt(j + 1) != ' '){
                    // If j is not pointing to the end of a word
                    j++;
                } else {
                    // Process word
                    pigify(str, i, j);
                    // Move pointers to next unprocessed character
                    i = ++j;
                }
            }
            System.out.println();
        }
        scanner.close();
    }
    /**
     * Scans the input string and prints the processed sentence.
     * @param str
     * @param start
     * @param end
     */
    private static void pigify(String str, int i, int j) {
        // Todo: Complete pig-latin converting algorithm 
        while (j >= i){
            System.out.print(str.charAt(j--));
        }
        System.out.print("-ay");
    }
}
