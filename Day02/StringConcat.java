/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 */

// import java.util.Scanner;
// import java.lang.Math;

public class StringConcat {
    public static void main(String[] args) {
        // Compile-time concatenation
        System.out.println("Ans = " + 1 + 2 + 3); // Compiles into "Ans = 123"
        System.out.println(1 + 2 + 3 + " = Ans"); // Compiles into "6 = Ans"
        // Runtime concatenation
        int a = 1, b = 2, c = 3;
        System.out.println("Ans = " + a + b + c); // Resolved into "Ans = 123"
        System.out.println(a + b + c + " = Ans"); // Resolved into "6 = Ans"
    }
}