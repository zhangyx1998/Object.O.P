/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 * ----------------------------------------
 * Task: Monte Carlo Method
 * ----------------------------------------
 */

public class MonteCarlo {
    
    final static int NumberOfThrows = 100000;

    public static class Throw {
        double x, y;
        public Throw() {
            x = Math.random() * 2;
            y = Math.random() * 2;
        }

        public boolean hit() {
            return x <= 1 || (y >= 1 && x + y < 3);
        }
    }

    public static void main(String[] args) {
        int NumberOfHits = 0;
        for (int i = 0; i < NumberOfThrows; i++){
            NumberOfHits += new Throw().hit() ? 1 : 0;
        }
        System.out.println((double)NumberOfHits / NumberOfThrows);
    }
}
