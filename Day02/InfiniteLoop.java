/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 */

// import java.util.Scanner;
// import java.lang.Math;

public class InfiniteLoop {
    public static void main(String[] args) throws InterruptedException {
        long x = 1;
        while(true){
            System.out.print((x *= 2) + "\t");
            Thread.sleep(100);
        }
    }
}