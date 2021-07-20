/* Write a program Distance.java that takes two integer
 * command-line arguments x and y and prints the Euclidean
 * distance frome the point(x, y) to the origin (0,0)
 */
import java.util.Scanner;
import java.lang.Math;
public class Distance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float x = input.nextFloat(),
              y = input.nextFloat();
        System.out.println(Math.sqrt(x * x + y * y));
        input.close();
    }
}
