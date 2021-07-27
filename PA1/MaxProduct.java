/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 * ----------------------------------------
 * Task: Find the max multiplication product
 * from a consonant series of integers.
 * The number of multiplication elements are
 * defined from input arguments, and the
 * series are streamed from standard input.
 * ----------------------------------------
 */

// Usage (bash)
// $> java MaxProduct.java 4 < data.txt

import java.util.Scanner;

public class MaxProduct {
    public static long product = 0, maxProduct = 0;

    public static class RotateMemory {
        private int length, ptr, data[];
        private long product = 0;

        public RotateMemory(int _length) {
            ptr = 0;
            length = _length;
            data = new int[_length];
        }

        public long rotate(int next) {
            int tmp = data[ptr];
            data[ptr] = next;
            if (product > 0){
                product = next * product / tmp;
            } else {
                product = 1;
                for (int i = 0; i < length; i++){
                    product *= data[i];
                }
            }
            if (++ptr >= length)
                ptr = 0;
            return product;
        }

        public RotateMemory dump(){
            RotateMemory tmp = new RotateMemory(length);
            for (int i = 0; i < length; i ++){
                tmp.rotate(data[(ptr + i) % length]);
            }
            return tmp;
        }

        public void print(){
            print(" ");
        }

        public void print(String str){
            for (int i = 0; i < length; i ++){
                if (i > 0){
                    System.out.print(str);
                }
                System.out.print(data[(ptr + i) % length]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rotate_length = Integer.parseInt(args[0]);
        RotateMemory ram = new RotateMemory(rotate_length), maxRam = ram;
        String str = sc.nextLine();
        int i = 0;
        while (str.length() > 0){
            if (i >= str.length()){
                if (!sc.hasNext())
                    break;
                if ((str = sc.nextLine().trim()).isEmpty())
                    break;
                i = 0;
            }
            int nextInt = str.charAt(i) - '0';
            product = ram.rotate(nextInt);
            if (product > maxProduct){
                maxProduct  = product;
                maxRam = ram.dump();
            }
            i ++;
            // input_length --;
        }
        System.out.print(maxProduct + " = ");
        maxRam.print(" * ");
        System.out.println();
        sc.close();
    }
}
