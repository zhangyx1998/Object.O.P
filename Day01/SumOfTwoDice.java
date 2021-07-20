/* Write a program SumOfTwoDice.java that prints
 * the sum of two random integers between 1 and 6
 * (such as you might get when rolling dice).
 */
import java.lang.Math;
public class SumOfTwoDice {
    public static void main(String[] args) {
        System.out.println(
            Math.floor(1 + Math.random() * 6) +
            Math.floor(1 + Math.random() * 6)
        );
    }
}