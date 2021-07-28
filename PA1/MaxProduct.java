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

    public static class RotateQueue {
        private int length, ptr, data[];
        private long product = 0;

        public RotateQueue(int _length) {
            ptr = 0;
            length = _length;
            data = new int[_length];
        }

        public long rotate(int next) {
            // Store popped element in a temporary variable.
            int tmp = data[ptr];
            // Insert the new queue element to its place.
            data[ptr] = next;
            if (++ptr >= length)
                // Increment queue pointer, move to start if the pointer exceeds queue boundary.
                ptr = 0;
            // Determine the new queue multiplication product.
            if (product > 0)
                // When the current product is not 0, all its members are not 0.
                product = next * product / tmp;
            else if (tmp != 0)
                // When the product is 0 while the popped element is not 0, it means that at
                // least one of its remaining elements is 0, which makes the new product
                // remaining to be 0.
                return product = 0;
            else {
                // If the popped element is 0, it is possible that the new product is not 0. In
                // this case, we have to scan the new queue elements to find any other zero
                // element.
                for (int i = 0; i < length; i++) {
                    if (data[i] == 0)
                        return product = 0;
                }
                // Now we are sure that the new queue has no zero elements, hence we should
                // re-calculate the new queue product.
                product = 1;
                for (int i = 0; i < length; i++) {
                    product *= data[i];
                }
            }
            return product;
        }

        public RotateQueue dump() {
            RotateQueue tmp = new RotateQueue(length);
            for (int i = 0; i < length; i++) {
                tmp.rotate(data[(ptr + i) % length]);
            }
            return tmp;
        }

        public void print() {
            this.print(" ");
        }

        public void print(String conString) {
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    System.out.print(conString);
                }
                System.out.print(data[(ptr + i) % length]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rotate_length = Integer.parseInt(args[0]);
        RotateQueue queue = new RotateQueue(rotate_length), maxQueue = queue;
        String conString = sc.nextLine();
        int i = 0;
        while (conString.length() > 0) {
            if (i >= conString.length()) {
                if (!sc.hasNext())
                    break;
                if ((conString = sc.nextLine().trim()).isEmpty())
                    break;
                i = 0;
            }
            int nextInt = conString.charAt(i) - '0';
            product = queue.rotate(nextInt);
            if (product > maxProduct) {
                maxProduct = product;
                maxQueue = queue.dump();
            }
            i ++;
        }
        System.out.print(maxProduct + " = ");
        maxQueue.print(" * ");
        System.out.println();
        sc.close();
    }
}