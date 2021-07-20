/* Write a program SumOfSines.java that takes a
 * double command-line argument (in degrees) and
 * prints the value of sin(2t) + sin(3t).
 */
import java.lang.Math;
public class SumOfSines {
    public static void main(String[] args) {
        System.out.println(
            sine(args[0]) + sine(args[1])
        );
    }
    private static double sine(String arg){
        return Math.sin(
            Math.toRadians(
                Float.parseFloat(arg)
            )
        );
    }
}